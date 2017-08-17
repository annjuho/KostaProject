package erp.basic.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.krysalis.barcode4j.BarcodeClassResolver;
import org.krysalis.barcode4j.DefaultBarcodeClassResolver;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.MimeTypes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.basic.domain.ListModelProduct;
import erp.basic.domain.Product;
import erp.basic.domain.ProductGroup;
import erp.basic.domain.ProductList;
import erp.basic.domain.Standards;
import erp.basic.domain.Stock;
import erp.basic.persistence.BasicProductDAO;
import erp.pch.domain.GetCustomer;

@Service
public class BasicProductServiceImpl implements BasicProductService{

	@Inject
	private BasicProductDAO dao;
	private static final int PAGE_SIZE = 5;
	
	/*품목 그룹 목록 - MJ*/
	@Override
	public List<ProductGroup> pgroupList() throws Exception {
		return dao.pgroupList();
	}

	/*규격 목록 - MJ*/
	@Override
	public List<Standards> standardList() throws Exception {
		return dao.standardList();
	}

	/*품목 목록 + 페이징 - MJ*/
	@Override
	public ListModelProduct productList(int requestPage) throws Exception {
		
		int totalCount = dao.totalCountProduct();
		int totalPageCount = totalCount/PAGE_SIZE;
		
		
		if(totalCount%PAGE_SIZE != 0){
			totalPageCount++;
		}

		int startPage = requestPage - (requestPage -1) % 5;
		int endPage = startPage + 4;
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		List<ProductList> list = dao.productList((requestPage - 1)*PAGE_SIZE);
		
		return new ListModelProduct(list, requestPage, totalPageCount, startPage, endPage);
	}

	/*품목 등록 - MJ*/
	@Transactional
	@Override
	public void productInsert(Product product) throws Exception {
		Stock stock = new Stock();
		stock.setProduct_id(product.getProduct_id());
		stock.setStock_amount(0);
		stock.setStock_loc("");
		stock.setWarehouse_id("warehouse_id_03");
		
		try {
			dao.productInsert(product);
			dao.stockInsert(stock);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}

	}

	/*품목 수정 - MJ*/
	@Override
	public void productUpdate(Product product) throws Exception {
		dao.productUpdate(product);
	}

	/*품목 삭제 - MJ*/
	@Override
	public void productDelete(String product_id) throws Exception {
		dao.productDelete(product_id);
	}

	@Override
	public List<Product> productCodeJson(String searchKey) throws Exception {
		String word = "%"+searchKey+"%";
		return dao.productCodeJson(word);
	}

	/*바코드 - MJ*/
	@Override
	public void productBarcode(HttpServletResponse res, String product_id) throws Exception {
		/* 바코드 타입
		28.
		* "codabar", "code39", "postnet", "intl2of5", "ean-128"
		29.
		* "royal-mail-cbc", "ean-13", "itf-14", "datamatrix", "code128"
		30.
		* "pdf417", "upc-a", "upc-e", "usps4cb", "ean-8", "ean-13" */
		Product p = dao.getProduct(product_id);
		String barcodeType = "ean-13";		
		/* 바코드 데이터 */
		String barcodeData = "100000000001";
		
		/* 이미지의 dpi */
		final int dpi = 203;
		/* 이미지 파일 포맷\
		* SVG, EPS, TIFF, JPEG, PNG, GIF, BMP */
		String fileFormat = "jpg";
		/* 출력될 파일 */
		String fileName = p.getProduct_name() + barcodeType;
		String outputFile = fileName+"."+fileFormat;
		outputFile = new String ( outputFile.getBytes("KSC5601"), "8859_1");
		/* anti-aliasing */
		boolean isAntiAliasing = false;
		try {
			AbstractBarcodeBean bean = null;			
			BarcodeClassResolver resolver = new DefaultBarcodeClassResolver();

			Class clazz = resolver.resolveBean(barcodeType);

			bean = (AbstractBarcodeBean)clazz.newInstance();

			bean.doQuietZone(true);
			res.setContentType("application/download");
			res.setHeader("Content-Disposition", "attachment; filename=" + outputFile + ";");
			//Open output file
			OutputStream out = res.getOutputStream();
			try {
				//Set up the canvas provider for monochrome JPEG output
				String mimeType = MimeTypes.expandFormat(fileFormat);
				int imageType   = BufferedImage.TYPE_BYTE_BINARY;
				BitmapCanvasProvider canvas = new BitmapCanvasProvider(
				out, mimeType, dpi, imageType, isAntiAliasing, 0);
				
				//Generate the barcode
				bean.generateBarcode(canvas, barcodeData);
				
				//Signal end of generation
				canvas.finish();
				System.out.println("create image success.");
			} finally {
				out.close();
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}

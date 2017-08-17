package erp.sale.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import erp.basic.domain.Product;
import erp.basic.persistence.BasicProductDAO;
import erp.common.domain.Criteria;
import erp.pch.domain.PurchaseExcelUp;
import erp.pch.domain.PurchaseListView;
import erp.pch.domain.PurchaseVO;
import erp.pch.persistence.PurchaseDAO;
import erp.sale.domain.SaleCustomerChart;
import erp.sale.domain.SaleGoodsDataXml;
import erp.sale.domain.SaleListView;
import erp.sale.domain.SaleProductChart;
import erp.sale.domain.SaleSearch;
import erp.sale.domain.SaleSearchTimeSet;
import erp.sale.domain.SaleVO;
import erp.sale.persistence.SaleDAO;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Inject
	private SaleDAO dao;
	@Inject
	private PurchaseDAO pDao;
	@Inject
	private BasicProductDAO bdao;
	
	@Transactional
	@Override
	public void insertSale(SaleVO vo) throws Exception {
		Product p = bdao.getProduct(vo.getProduct_id());
		vo.setSell_price(p.getPrice_out());
		try {
			dao.addSale(vo);
			dao.addXmlDataSell(vo);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
		
		
	}

	@Override
	public List<SaleListView> listSale() throws Exception {
		return dao.listSale();
	}

	@Override
	public void deleteSale(String sell_id) throws Exception {
		dao.removeSale(sell_id);
	}
	@Override
	public void updateSale(SaleVO vo) throws Exception {
		dao.updateSale(vo);		
	}

	@Override
	public List<SaleListView> saleSearchList(SaleSearch ss) throws Exception {
		SaleSearchTimeSet sst = new SaleSearchTimeSet();
		sst.setCustomer_id(ss.getCustomer_id());
		sst.setProduct_id(ss.getProduct_id());
		sst.setWarehouse_id(ss.getWarehouse_id());
		sst.setStart_date(Timestamp.valueOf(ss.getStart_date()+" 00:00:00"));
		sst.setEnd_date(Timestamp.valueOf(ss.getEnd_date()+" 23:59:59"));
		return dao.searchSale(sst);
	}

	@Override
	public List<SaleListView> listAll() throws Exception {
		return dao.listAll();
	}
	@Override
	public List<SaleListView> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}
	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public void downloadExcel(OutputStream out, HttpServletResponse res) throws Exception {
		Map<String,Object> map=null;
		ArrayList<Map<String,Object>> excelList=new ArrayList<Map<String,Object>>();
		ArrayList<String> columnList=new ArrayList<String>();
		List<SaleListView> list = null;
		
		try {
			list = dao.listSale();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//구매번호(PK)	거래처번호(FK)	품목번호(FK)	구매일자	창고번호(FK)	
		//지급방법	구매금액	수량	직원번호(fk)
		map = new HashMap<String,Object>();
		
		map.put("판매번호", "판매번호");
		map.put("거래처명", "거래처명");
		map.put("품목명", "품목명");
		map.put("판매일자", "판매일자");
		map.put("창고명", "창고명");
		map.put("지급유형", "지급유형");
		map.put("판매금액", "판매금액");
		map.put("수량", "수량");
		excelList.add(map);
		for(int i=0; i<list.size();i++){
			map = new HashMap<String,Object>();
			
			map.put("판매번호", list.get(i).getSell_id());
			map.put("거래처명", list.get(i).getCustomer_name());
			map.put("품목명", list.get(i).getProduct_name());
			map.put("판매일자", list.get(i).getSell_date());
			map.put("창고명", list.get(i).getWarehouse_name());
			map.put("지급유형", list.get(i).getPay_type());
			map.put("판매금액", list.get(i).getSell_price());
			map.put("수량", list.get(i).getSell_amount());
			excelList.add(map);
		}
		if(list !=null &&list.size() >0){
		    //LIST의 첫번째 데이터의 KEY값만 알면 되므로 
		    Map<String,Object> m = excelList.get(0);
		    //MAP의 KEY값을 columnList객체에 ADD 
		    for(String k : m.keySet()){
		        columnList.add(k);
		    }
		}
		//1차로 workbook을 생성 
		XSSFWorkbook workbook=new XSSFWorkbook();
		//2차는 sheet생성 
		XSSFSheet sheet=workbook.createSheet("판매 조회");
		//엑셀의 행 
		XSSFRow row = null;
		//엑셀의 셀 
		XSSFCell cell = null;
		//임의의 DB데이터 조회 
		if(list != null &&list.size() >0){
		    int i = 0;
		    for(Map<String,Object>mapobject : excelList){
		        // 시트에 하나의 행을 생성한다(i 값이 0이면 첫번째 줄에 해당) 
		        row = sheet.createRow((short)i);
		        i++;
		        if(columnList !=null &&columnList.size() >0){
		            for(int j=0;j<columnList.size();j++){
		                //생성된 row에 컬럼을 생성한다 
		                cell=row.createCell(j);
		                //map에 담긴 데이터를 가져와 cell에 add한다 
		                cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
		            }
		        }
		    }
		}
		
		//OutputStream fileoutputstream = null;
		String fileName = "판매현황.xlsx";
		fileName = new String ( fileName.getBytes("KSC5601"), "8859_1");
		
		res.setContentType("application/vnd.ms-excel");
		res.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
		
		//fileoutputstream = res.getOutputStream();
		//파일을 쓴다
		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
			//필수로 닫아주어야함 
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void uploadExcel(String path) throws Exception {
		FileInputStream fis=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int rowindex=0;
		int columnindex=0;
		List<String> list = null;
		SaleVO vo = null;
		//시트 수 (첫번째에만 존재하므로 0을 준다)
		//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		XSSFSheet sheet=workbook.getSheetAt(0);
		//행의 수
		int rows=sheet.getPhysicalNumberOfRows();
		for(rowindex=1;rowindex<rows;rowindex++){
		    //행을읽는다
			//SaleExcelUp su = null;			
		    XSSFRow row=sheet.getRow(rowindex);
		    list = new ArrayList<String>();
		    vo = new SaleVO();
		    if(row !=null){
		        //셀의 수
		        int cells=row.getPhysicalNumberOfCells();
		        for(columnindex=0;columnindex<=cells;columnindex++){
		            //셀값을 읽는다
		            XSSFCell cell=row.getCell(columnindex);
		            String value="";
		            //셀이 빈값일경우를 위한 널체크
		            if(cell==null){
		                continue;
		            }else{
		                //타입별로 내용 읽기
		                switch (cell.getCellType()){
		                case XSSFCell.CELL_TYPE_FORMULA:
		                    value=cell.getCellFormula();
		                    break;
		                case XSSFCell.CELL_TYPE_NUMERIC:
		                    value=cell.getNumericCellValue()+"";
		                    break;
		                case XSSFCell.CELL_TYPE_STRING:
		                    value=cell.getStringCellValue()+"";
		                    break;
		                case XSSFCell.CELL_TYPE_BLANK:
		                    value=cell.getBooleanCellValue()+"";
		                    break;
		                case XSSFCell.CELL_TYPE_ERROR:
		                    value=cell.getErrorCellValue()+"";
		                    break;
		                }
		            }
		            		            
		          /*  품목명	지급유형	구매일자	구매금액	창고명	거래처명	수량	구매번호*/
		            if(columnindex==0){
		            	value = pDao.getProductId(value);
		            }else if(columnindex==2){
		            	value = pDao.getWarehouseId(value);
		            }else if(columnindex==4){
		            	value = pDao.getCustomerId(value);
		            }
		            list.add(value);
		        }
		        //품목명	지급유형	창고명	판매번호	거래처명	수량	판매일자	판매금액
		        vo.setProduct_id(list.get(0));
		        vo.setPay_type(list.get(1));
		        vo.setWarehouse_id(list.get(2));
		        vo.setSell_id(list.get(3));
		        vo.setCustomer_id(list.get(4));
		        vo.setSell_amount(Integer.parseInt(list.get(5)));
		        vo.setSell_date(Timestamp.valueOf(list.get(6)));
		        vo.setSell_price(Integer.parseInt(list.get(7)));		  
		        dao.insertSaleExcel(vo);
		    }		   
		}
	}

	@Override
	public List<SaleProductChart> saleProductChart(String customer_id) throws Exception {
		return dao.saleProductChart(customer_id);
	}

	@Override
	public List<SaleCustomerChart> saleCustomerChart() throws Exception {
		return dao.saleCustomerChart();
	}

	@Override
	public SaleGoodsDataXml selectSaleXml(String sell_id) throws Exception {
		return dao.selectSaleXml(sell_id);
	}

}

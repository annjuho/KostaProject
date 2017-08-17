package erp.pch.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import erp.basic.domain.Product;
import erp.common.domain.Criteria;
import erp.pch.domain.GetCustomer;
import erp.pch.domain.GetWareHouse;
import erp.pch.domain.JsonDataChart;
import erp.pch.domain.PurchaseExcelUp;
import erp.pch.domain.PurchaseListView;
import erp.pch.domain.PurchaseSearch;
import erp.pch.domain.PurchaseSearchTimeSet;
import erp.pch.domain.PurchaseVO;
import erp.pch.domain.Slip;
import erp.pch.domain.TotalDataChart;
import erp.pch.persistence.PurchaseDAO;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Inject
	private PurchaseDAO dao;
	
	@Override
	public void insertPch(PurchaseVO vo) throws Exception {
		dao.addPch(vo);
	}

	@Override
	public List<PurchaseListView> detailPch() throws Exception {
		return dao.readPch();
	}

	@Override
	public void delete(String buy_id) throws Exception {
		dao.removePch(buy_id);
	}

	@Override
	public List<GetCustomer> customerList(String customer_id) throws Exception {
		return dao.customerList(customer_id);
	}

	@Override
	public List<PurchaseListView> purchaseSearch(PurchaseSearch ps) throws Exception {
		PurchaseSearchTimeSet pst = new PurchaseSearchTimeSet();
		pst.setCustomer_id(ps.getCustomer_id());
		pst.setProduct_id(ps.getProduct_id());
		pst.setWarehouse_id(ps.getWarehouse_id());
		pst.setStart_date(Timestamp.valueOf(ps.getStart_date()+" 00:00:00"));
		pst.setEnd_date(Timestamp.valueOf(ps.getEnd_date()+" 23:59:59"));
		return dao.purchaseSearch(pst);
	}

	@Override
	public List<Product> productList(String product_id) throws Exception {
		return dao.productList(product_id);
	}

	@Override
	public List<GetWareHouse> warehouseList(String warehouse_id) throws Exception {
		return dao.warehouseList(warehouse_id);
	}

	@Override
	public List<PurchaseListView> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<PurchaseListView> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}

	@Override
	public void updatePurchase(PurchaseVO vo) throws Exception {
		dao.updatePurchase(vo);
	}

	@Override
	public void downloadExcel(OutputStream out,HttpServletResponse res) throws Exception {
		Map<String,Object> map=null;
		ArrayList<Map<String,Object>> excelList=new ArrayList<Map<String,Object>>();
		ArrayList<String> columnList=new ArrayList<String>();
		List<PurchaseListView> list = null;
		
		try {
			list = dao.readPch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//구매번호(PK)	거래처번호(FK)	품목번호(FK)	구매일자	창고번호(FK)	
		//지급방법	구매금액	수량	직원번호(fk)
		map = new HashMap<String,Object>();
		
		map.put("구매번호", "구매번호");
		map.put("거래처명", "거래처명");
		map.put("품목명", "품목명");
		map.put("구매일자", "구매일자");
		map.put("창고명", "창고명");
		map.put("지급유형", "지급유형");
		map.put("구매금액", "구매금액");
		map.put("수량", "수량");
		excelList.add(map);
		for(int i=0; i<list.size();i++){
			map = new HashMap<String,Object>();
			
			map.put("구매번호", list.get(i).getBuy_id());
			map.put("거래처명", list.get(i).getCustomer_name());
			map.put("품목명", list.get(i).getProduct_name());
			map.put("구매일자", list.get(i).getBuy_date());
			map.put("창고명", list.get(i).getWarehouse_name());
			map.put("지급유형", list.get(i).getPay_type());
			map.put("구매금액", list.get(i).getBuy_price());
			map.put("수량", list.get(i).getBuy_amount());
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
						XSSFSheet sheet=workbook.createSheet("구매 조회");
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
						                cell.setCellValue(
						                	String.valueOf(mapobject.get(columnList.get(j))));
						            }
						        }
						    }
						}
		
		String fileName = "구매현황.xlsx";
		fileName = new String ( fileName.getBytes("KSC5601"), "8859_1");
		
		res.setContentType("application/vnd.ms-excel");
		res.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
	
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
			// TODO Auto-generated catch block
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
		PurchaseVO vo = null;
		//시트 수 (첫번째에만 존재하므로 0을 준다)
		//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		XSSFSheet sheet=workbook.getSheetAt(0);
		//행의 수
		int rows=sheet.getPhysicalNumberOfRows();
		for(rowindex=1;rowindex<rows;rowindex++){
		    //행을읽는다
			PurchaseExcelUp eu = null;			
		    XSSFRow row=sheet.getRow(rowindex);
		    list = new ArrayList<String>();
		    vo = new PurchaseVO();
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
		            		            
		            if(columnindex==0){
		            	value = dao.getProductId(value);
		            }else if(columnindex==4){
		            	value = dao.getWarehouseId(value);
		            }else if(columnindex==5){
		            	value = dao.getCustomerId(value);
		            }
		            list.add(value);
		            System.out.println(value);
		        }	
		        vo.setProduct_id(list.get(0));
		        vo.setPay_type(list.get(1));
		        vo.setBuy_date(Timestamp.valueOf(list.get(2)));
		        vo.setBuy_price(Integer.parseInt(list.get(3)));
		        vo.setWarehouse_id(list.get(4));
		        vo.setCustomer_id(list.get(5));
		        vo.setBuy_amount(Integer.parseInt(list.get(6)));
		        vo.setBuy_id(list.get(7));
		        vo.setEmp_id(list.get(8));
		        System.out.println(vo);
		        dao.insertExcel(vo);
		    }		   
		}
	}

	@Override
	public List<JsonDataChart> getChartData() throws Exception {
		List<PurchaseListView> list = dao.getTotalPrice();
		List<PurchaseListView> customerList = dao.getCustomerGroup();
		List<JsonDataChart> json = new ArrayList<JsonDataChart>();
		int totalPirce = 0;
		for(int i=0;i<customerList.size();i++){
			int tmp = 0;
			boolean check = false;
			for(int j=0;j<list.size();j++){				
				if(customerList.get(i).getCustomer_name().equals(list.get(j).getCustomer_name())){
					tmp += list.get(j).getBuy_price() * list.get(j).getBuy_amount();
					System.out.println(customerList.get(i).getCustomer_name()+":"+list.get(j).getCustomer_name()+":"+tmp);
					check = true;
				}
			}
			if(check){
				customerList.get(i).setBuy_price(tmp);
				totalPirce += tmp;
			}
		}
		for(PurchaseListView plv : customerList){
			JsonDataChart jdc = new JsonDataChart();
			double y = (double)plv.getBuy_price()/totalPirce * 100;
			jdc.setName(plv.getCustomer_name());
			jdc.setDrilldown(plv.getCustomer_name());
			jdc.setY(y);
			json.add(jdc);
		}
		return json;
	}

	
	
	
								@Override
								public List<TotalDataChart> getTotalSales() throws Exception {		
									List<TotalDataChart> list = new ArrayList<TotalDataChart>();
									List<Slip> slipList = null;
									long[] temps = new long[12];
									for(int i=1;i<13;i++){
										long val = 0;
										if(i<10){
											slipList = dao.getMonth("16/0"+i+"%");
										}else{
											slipList = dao.getMonth("16/"+i+"%");
										}
										for(int j=0;j<slipList.size();j++){
											val += slipList.get(j).getSlip_amount();
										}
										temps[i-1] = val;
									}
									TotalDataChart tdc = new TotalDataChart();
									tdc.setName("shop");
									tdc.setData(temps);
									list.add(tdc);
									return list;
								}
								
								
}

package erp.gw.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import erp.common.domain.FolderFileVO;
import erp.common.domain.MediaUtils;
import erp.common.domain.UploadFileUtils;
import erp.common.service.CommonService;
import erp.gw.deptboard.service.ShareFolderService;

@Controller
@RequestMapping("/groupware/dept_board/share_folder")
public class ShareFolderController {
	
	@Inject
	private ShareFolderService service;
	
	private static String uploadPath = "";
	
	@RequestMapping("")
	public String sharefolderMain(HttpServletRequest request, Model model) throws Exception{
		
		String[] arr = request.getSession().getServletContext().getRealPath("/").split("\\\\");
		
		for(int i=0; i<arr.length; i++){
			System.out.println("간다!!!"+arr[i]);
			
		}
			
		String path ="";
//		for (int i=0; i<3; i++){
//			path += arr[i] + "/"; 
//		}
		
//		path += "git/Spring/springERP/src/main/webapp/resources/groupware/upload";
		path += "C:/Users/pado/git/Spring/springERP/src/main/webapp/resources/groupware/upload";
		uploadPath = path;
		
		System.out.println(uploadPath);
		System.out.println();
		
		List<FolderFileVO> list = service.listFile();
		
		model.addAttribute("e_name", service.getEname(CommonService.getEmployeeId()));
		model.addAttribute("list",list);
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/share_folder.jsp");
		return "/main";
	}
	
	@RequestMapping(value="/uploadAjax", method=RequestMethod.GET)
	public String uploadAjax(Model model){
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/share_folder.jsp");
		return "/main";
	}

	// 드래그앤 드랍으로 파일업로드
	@ResponseBody
	@RequestMapping(value="/uploadAjax", method=RequestMethod.POST, produces="texet/plain;charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(CommonService.getEmployeeId());
		
		String uploadedFileName = UploadFileUtils.uploadFile(
				uploadPath, file.getOriginalFilename(),
				file.getBytes());
		System.out.println(uploadedFileName);
		System.out.println(uploadedFileName.split("/")[4].substring(2));
		
		FolderFileVO folderFile = new FolderFileVO();
		
		folderFile.setEmp_id(CommonService.getEmployeeId());
		folderFile.setFile_type(file.getContentType());
		folderFile.setFile_name(file.getOriginalFilename());
		folderFile.setFile_size((int)file.getSize());
		folderFile.setUpload_file(uploadedFileName);
		
		service.insertFile(folderFile);
		
		return new ResponseEntity<String>(
				uploadedFileName,
				HttpStatus.CREATED);
	}
	
	// 올리기 버튼으로 파일업로드
	@RequestMapping(value="/uploadForm", method=RequestMethod.POST)
	public String uploadForm(MultipartHttpServletRequest request, Model model) throws Exception{
		List<MultipartFile> fileList = request.getFiles("file");
		
		for(int i=0; i<fileList.size(); i++){
			
			String uploadedFileName = UploadFileUtils.uploadFile(
					uploadPath, fileList.get(i).getOriginalFilename(),
					fileList.get(i).getBytes());
			
			FolderFileVO folderFile = new FolderFileVO();
			
			folderFile.setEmp_id(CommonService.getEmployeeId());
			folderFile.setFile_type(fileList.get(i).getContentType());
			folderFile.setFile_name(fileList.get(i).getOriginalFilename());
			folderFile.setFile_size((int)fileList.get(i).getSize());
			folderFile.setUpload_file(uploadedFileName);
			
			service.insertFile(folderFile);
		}

		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/share_folder.jsp");
		
		return "redirect:/groupware/share_folder";
	}
	
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]>  displayFile(String fileName, Model model) throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		System.out.println(fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			
			MediaType mType = MediaUtils.geteMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath+fileName);
			
			if(mType != null){
				headers.setContentType(mType);
			} else{
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add(
						"Content-Disposition",
						"attachment; filename=\"" +
						new String(fileName.getBytes("utf-8"),
								"ISO-8859-1")+"\"");
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	}
	
	
	@RequestMapping(value="/download", method=RequestMethod.POST)
	public void downloadFile(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String[] strarr = request.getParameterValues("fileCheck");
		
		for(int i=0; i<strarr.length; i++){
			System.out.println(strarr[i]);
			
			int file_id = Integer.parseInt(strarr[i]);
			FolderFileVO folderFile = service.selectFile(file_id);
			
			// 파일 업로드된 경로
			String savePath = uploadPath + folderFile.getUpload_file().split("s")[0];
			System.out.println("이값은 무엇일까욘 ~ : " + folderFile.getUpload_file().split("s")[0]);
			System.out.println("저장된경로!! : "+savePath);
			
			// 서버에 실제 저장된 파일명
			String filename = folderFile.getUpload_file().split("/")[4].substring(2);
			System.out.println("filename 내용은 : "+filename);
			// 실제 내보낼 파일명
			String orgfilename = folderFile.getUpload_file().split("_")[2] ;
			
			System.out.println("orgfilename : " + orgfilename);
			
			InputStream in = null;
			OutputStream os = null;
			File file = null;
			boolean skip = false;
			String client = "";
			
			try{
				// 파일을 읽어 스트림에 담기
				try{
					file = new File(savePath, filename);
					in = new FileInputStream(file);
				}catch(FileNotFoundException fe){
					skip = true;
				}
				
				client = request.getHeader("User-Agent");
				
				// 파일 다운로드 헤더 지정
				//response.reset() ;
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Description", "JSP Generated Data");
				
				if(!skip){
					// IE
					if(client.indexOf("MSIE") != -1){
						response.setHeader ("Content-Disposition", "attachment; filename="+new String(orgfilename.getBytes("KSC5601"),"ISO8859_1"));
						
					}else{
						// 한글 파일명 처리
						orgfilename = new String(orgfilename.getBytes("utf-8"),"iso-8859-1");
						
						response.setHeader("Content-Disposition", "attachment; filename=\"" + orgfilename + "\"");
						response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
					}  
					
					response.setHeader ("Content-Length", ""+file.length() );
					
					os = response.getOutputStream();
					byte b[] = new byte[(int)file.length()];
					int leng = 0;
					
					while( (leng = in.read(b)) > 0 ){
						os.write(b,0,leng);
					}
					
				}else{
					response.setContentType("text/html;charset=UTF-8");
					System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			} finally {
				in.close();
				os.close();
			}
		}
	}
	
//	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public String deleteFile(MultipartHttpServletRequest request, Model model) throws Exception{
		
		String[] strarr = request.getParameterValues("fileCheck");
		
		for(int i=0; i<strarr.length; i++){
			System.out.println(strarr[i]);
			
			int file_id = Integer.parseInt(strarr[i]);
			FolderFileVO folderFile = service.selectFile(file_id);
			
			String[] arr = folderFile.getUpload_file().split("/");
			String fileName = folderFile.getUpload_file().split("/")[4].substring(2);
			String folderName = "";
			
			for(int j=0; j<4; j++){
				folderName += arr[j] + "/";
			}
					
			String filePath = folderName + fileName;
			
			System.out.println("del filePath : " + filePath);
			System.out.println("folderName : " + folderName);
			
			//원본 삭제
			new File(uploadPath + filePath).delete();
			
			//썸네일 삭제
			new File(uploadPath + folderFile.getUpload_file()).delete();
			service.deleteFile(file_id);
		}
		
		model.addAttribute("left", "groupware/groupware.jsp");
		model.addAttribute("contents", "groupware/dept_board/share_folder.jsp");
		
		return "redirect:/groupware/share_folder";
	}
	
}

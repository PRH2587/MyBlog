package com.bomb.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bomb.base.repository.LocalFileService;

@Controller
@RequestMapping("/repository")
public class FileController {
	
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private LocalFileService localFileService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST )
	public void upload(MultipartHttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		try{
			out = response.getWriter(); 
			response.reset();
			Iterator<String> itr =  request.getFileNames();
			MultipartFile mpf = null;
			while(itr.hasNext()){
				mpf = request.getFile(itr.next());
				InputStream content = null;
				try{
					content = mpf.getInputStream();
					String filePath = localFileService.saveFile(content);
					String rtContent = "{\"status\":200,\"data\": \""+request.getContextPath() + "/repository/"+ filePath + "\"}";
					log.info("Visit url:" + rtContent);
					out.print(rtContent);
				}catch(IOException e){
					log.error("uploadHeadIcon error :" +e.getMessage(),e);
				}finally{
					try{
						if(content!= null){
							content.close();
							content = null;
						}
					}catch(IOException e){
						log.error("uploadHeadIcon close stream error :" +e.getMessage(),e);
					}
				}
			}
		}catch(IOException e){
			log.error("upload file error :" + e.getMessage() ,e);
		}finally{
			if(out!=null){
				out.close();
				out = null;
			}
		}	
	}
	
	@RequestMapping(value="/{day}/{hour}/{fileName}", method = RequestMethod.GET)
	public void downloadFile(@PathVariable(value = "day") String day,
			@PathVariable(value = "hour") String hour,
			@PathVariable(value = "fileName") String fileName,
			HttpServletResponse response){
		log.debug("Input Param [day] -> " + day);
		log.debug("Input Param [hour] -> " + hour);
		log.debug("Input Param [fileName] -> " + fileName);
		String fileFullPath = localFileService.getFileFullPath(day,hour,fileName);
		OutputStream os = null;
		FileInputStream  fis = null; 
		try{
			os = response.getOutputStream(); 
			response.reset();
			response.setContentType("application/octet-stream; charset=utf-8");
			fis= new FileInputStream(fileFullPath);
			final int bufferLength =  16384; 
			if(fis!=null && fis.available()>-1){
				byte[]buffer = new byte[bufferLength];
				int flag = -1;
				while((flag = fis.read(buffer))!=-1){
					os.write(buffer,0,flag);
				}
				os.flush();
			}
		}catch(IOException e){
			log.error("download file error :" + e.getMessage() ,e);
		}finally{
			try{
				if(fis!=null){
					fis.close();
					fis = null;
				}
				if(os!=null){
					os.close();
					os = null;
				}
			}catch(IOException e){
				log.error("download file error :" + e.getMessage() ,e);
			}
		}
	}
	
	
}

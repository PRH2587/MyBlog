package com.bomb.base.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalFileService {
	
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	public static final String FILE_SEPARATOR = "/";
	
	private DateFormat df = new SimpleDateFormat("yyyyMMdd");
	
	private String repositoryPath;
	
	private int bufferLength;
	
	public void setRepositoryPath(String repositoryPath){
		this.repositoryPath = repositoryPath;
	}
	
	public void setBufferLength(int bufferLength){
		this.bufferLength = bufferLength;
	}
	
	public String saveFile(InputStream content){
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		String fileSystemName = UUID.randomUUID().toString();
		StringBuffer filePath = new StringBuffer(256);
		StringBuffer rt = new StringBuffer(256);
		filePath.append(repositoryPath).append(File.separator).append(df.format(currentDate));
		rt.append(df.format(currentDate));
		File _folder = new File(filePath.toString());
		if(!_folder.exists()){
			_folder.mkdir();
		}
		filePath.append(File.separator).append(c.get(Calendar.HOUR_OF_DAY));
		rt.append(FILE_SEPARATOR).append(c.get(Calendar.HOUR_OF_DAY)).append(FILE_SEPARATOR).append(fileSystemName);
		_folder = new File(filePath.toString());
		if(!_folder.exists()){
			_folder.mkdir();
		}
		filePath.append(java.io.File.separator).append(fileSystemName);
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(filePath.toString());
			byte[] buffer = new byte[bufferLength==0? 16384 : bufferLength];
			int flag = -1;
			while((flag=content.read(buffer))!=-1){
				fos.write(buffer, 0, flag);
			}
			fos.flush();
		}catch(IOException e){
			log.error("LocalFileService.saveFile() error:\n"+e.getMessage());
			throw new RuntimeException();
		}finally{
			try{
				if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
				
			}
		}
		return rt.toString();
	}
	
	public void saveStaticFile(InputStream content,String path,String fileName){
		StringBuffer filePath = new StringBuffer(256);
		filePath.append(repositoryPath).append(File.separator).append(path);
		File _folder = new File(filePath.toString());
		if(!_folder.exists()){
			_folder.mkdir();
		}
		filePath.append(java.io.File.separator).append(fileName);
		
		File existFile = new File(filePath.toString());
		if(existFile.exists()){
			existFile.delete();
		}
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(filePath.toString());
			byte[] buffer = new byte[bufferLength==0? 16384 : bufferLength];
			int flag = -1;
			while((flag=content.read(buffer))!=-1){
				fos.write(buffer, 0, flag);
			}
			fos.flush();
		}catch(IOException e){
			log.error("LocalFileService.saveFile() error:\n"+e.getMessage());
			throw new RuntimeException();
		}finally{
			try{
				if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
				
			}
		}
	}
	
	public String getFileFullPath(String yyyyMMdd,String hour,String path){
		StringBuffer filePath = new StringBuffer(256);
		filePath.append(repositoryPath);
		filePath.append(File.separator);
		filePath.append(yyyyMMdd);
		filePath.append(File.separator);
		filePath.append(hour);
		filePath.append(File.separator);
		filePath.append(path);
		return filePath.toString();
	}
	
	public String getStaticFileFullPath(String path,String fileName){
		StringBuffer filePath = new StringBuffer(256);
		filePath.append(repositoryPath);
		filePath.append(File.separator);
		filePath.append(path);
		filePath.append(File.separator);
		filePath.append(fileName);
		return filePath.toString();
	}
	
	
}

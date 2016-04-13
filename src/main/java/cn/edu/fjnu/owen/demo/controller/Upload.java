
package cn.edu.fjnu.owen.demo.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/** 
* @author 李冰冰
* @date 创建时间：2016年4月13日 下午4:40:58 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/

public class Upload {

	/**
	* 处理文件上传
	* @param response
	* @param request
	* @return
	* @throws IOException
	*/
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)  
	public String upload(HttpServletResponse response,HttpServletRequest request) throws IOException{  
	String responseStr="";
	MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest) request;
	Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();    
	//String savePath = this.getServletConfig().getServletContext().getRealPath("");
	        //savePath = savePath + "/uploads/";
	// 文件保存路径  ctxPath本地路径
	String ctxPath=request.getSession().getServletContext().getRealPath("/")+File.separator+"uploadFiles";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");  
	String ymd = sdf.format(new Date());  
	ctxPath += File.separator + ymd + File.separator;  
	System.out.println("ctxpath="+ctxPath);
	// 创建文件夹  
	File file = new File(ctxPath);    
	if (!file.exists()) {    
	file.mkdirs();    
	}
	String fileName = null;    
	for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {    
	// 上传文件   
	MultipartFile mf = entity.getValue();  
	fileName = mf.getOriginalFilename();//获取文件名  
	System.out.println("filename="+fileName);
	File uploadFile = new File(ctxPath + fileName);
	try {  
	FileCopyUtils.copy(mf.getBytes(), uploadFile);  
	   responseStr="上传成功";  
	   } catch (IOException e) {  
	   	responseStr="上传失败";  
	       e.printStackTrace();  
	       }
	}   
	return responseStr;    
	}
}


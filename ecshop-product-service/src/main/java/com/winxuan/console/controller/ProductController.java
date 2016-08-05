package com.winxuan.console.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.winxuan.console.service.ProductService;
import com.winxuan.console.util.DateUtil;
import com.winxuan.console.util.FileUtil;
import com.winxuan.console.util.Message;

/**
 * @ClassName:ProductController.java 
 * @Description: 
 * @author: wangpanyong
 * @date: 2015年12月14日
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Log LOG = LogFactory.getLog(ProductController.class);
	private static final String filePathPrefix = "./logs/upload/product";
	
	@Autowired
	ProductService productService;
	
	/**
	 * 通过上传文件方式，恢复商品价格
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/price/recover/upload", method = RequestMethod.POST)
	public Object priceRecoverUpload(@RequestParam() MultipartFile file, HttpServletRequest request)throws Exception{
		String fileName = file.getOriginalFilename();
		LOG.info("upload file name : " + fileName);
		if(!fileName.endsWith(".txt")){
			throw new Exception("upload file is not a txt");
		}
		//目标文件名
		File destinationFile = new File(filePathPrefix + File.separator + DateUtil.date2String("yyyyMMddHHmmss") + "_" + fileName);
		if(!destinationFile.getParentFile().exists())
			destinationFile.getParentFile().mkdirs();
		
		LOG.info("file upload to : " + destinationFile.getAbsolutePath());
		FileUtil.writeFile(destinationFile, file.getInputStream());
		
		productService.priceRecover(destinationFile);
		return new Message();
	}
	
	
	/**
	 * 商品价格恢复
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/price/recover", method = RequestMethod.POST)
	public Object priceRecover(@RequestParam String ids)throws Exception{
		LOG.info("ids -> "+ ids);
		productService.priceRecover(ids);
		return new Message();
	}
	
	@ExceptionHandler(Exception.class)
	public Object handleError(HttpServletRequest req, HttpServletResponse response, Exception e) {
		LOG.error("error url : "+ req.getRequestURL() +"?"+ req.getQueryString(), e);
		response.setStatus(500);
		return new Message(e.getMessage(), false);
	}
	
}

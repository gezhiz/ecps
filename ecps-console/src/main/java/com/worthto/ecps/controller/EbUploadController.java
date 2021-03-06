package com.worthto.ecps.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rl.ecps.util.UploadResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.worthto.ecps.service.IUploadService;
import com.worthto.ecps.utils.EcpsUtils;

/**
 * 处理品牌添加时上传图片的ajax异步请求
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/upload")
public class EbUploadController {

	@Autowired
	private IUploadService uploadService;

	@RequestMapping("/uploadPic.do")
	public void upload(Model model, HttpServletRequest request,
			HttpServletResponse response, String lastPath) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;// 文件上传的请求服务
		// 获得文件
		Iterator<String> iter = multipartRequest.getFileNames();
		String fileInputName = iter.next();
		MultipartFile multipartFile = multipartRequest.getFile(fileInputName);
		
		byte[] fileBytes = null;
		try {
			fileBytes = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String originalName = multipartFile.getOriginalFilename();
		String suffix = originalName.substring(originalName.lastIndexOf("."));

		String file_host_path = EcpsUtils.readProp("file_host_path");// 主机地址
		String fileName = new SimpleDateFormat("yyyyMMddssSSS")
				.format(new Date()) + suffix;// 文件名
		String relativePath = "upload/" + fileName;

		String realPath = file_host_path + "upload/" + fileName;

		if (StringUtils.isNotBlank(lastPath)) {
			uploadService.deleteBrandPic(lastPath);// 删除上一张图片
		}
		uploadService.saveBrandPic(fileBytes, realPath);

		JSONObject jo = new JSONObject();
		jo.accumulate("relativePath", relativePath);
		jo.accumulate("realPath", realPath);
		model.addAttribute("realPath", realPath);
		try {
			response.getWriter().print(jo.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/uploadForFck.do")
	public void uploadForFck(Model model, HttpServletRequest request,
			HttpServletResponse response, String lastPath, PrintWriter out) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;// 文件上传的请求服务
		// 获得文件
		Iterator<String> iter = multipartRequest.getFileNames();
		String fileInputName = iter.next();
		MultipartFile multipartFile = multipartRequest.getFile(fileInputName);
		
		byte[] fileBytes = null;
		try {
			fileBytes = multipartFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String originalName = multipartFile.getOriginalFilename();
		String suffix = originalName.substring(originalName.lastIndexOf("."));

		String file_host_path = EcpsUtils.readProp("file_host_path");// 主机地址
		String fileName = new SimpleDateFormat("yyyyMMddssSSS")
				.format(new Date()) + suffix;// 文件名

		String realPath = file_host_path + "upload/" + fileName;

		if (StringUtils.isNotBlank(lastPath)) {
			uploadService.deleteBrandPic(lastPath);// 删除上一张图片
		}
		uploadService.saveBrandPic(fileBytes, realPath);

		UploadResponse ur = new UploadResponse(UploadResponse.EN_OK, realPath);
		out.print(ur);
	}
}

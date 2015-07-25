package com.worthto.ecps.dao.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.worthto.ecps.dao.IUploadDao;

@Repository
public class UploadDaoImpl implements IUploadDao {

	public void saveBrandPic(byte[] fileBytes, String realPath) {
		Client client = new Client();
		WebResource wr = client.resource(realPath);// 指定资源的路径
		wr.put(String.class, fileBytes);
	}

	public void deleteBrandPic(String realPath) {
		Client client = new Client();// 创建JerSey客户端
		// 如果有误传图片，则删除
		if (StringUtils.isNotBlank(realPath)) {
			try {
				WebResource wr1 = client.resource(realPath);// 指定资源的路径
				wr1.delete();
			} catch (Exception e) {
				// 捕获异常，防止恶意修改删除路径
				e.printStackTrace();
			}
		}
	}
}

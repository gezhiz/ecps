package com.worthto.ecps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worthto.ecps.dao.IUploadDao;
import com.worthto.ecps.service.IUploadService;

@Service
public class UploadServiceImpl implements IUploadService {
	@Autowired
	private IUploadDao uploadDao;

	public void saveBrandPic(byte[] fileBytes, String realPath) {
		uploadDao.saveBrandPic(fileBytes, realPath);
	}

	public void deleteBrandPic(String realPath) {
		uploadDao.deleteBrandPic(realPath);
	}

}

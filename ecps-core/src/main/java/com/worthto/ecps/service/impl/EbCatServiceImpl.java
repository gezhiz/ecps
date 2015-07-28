package com.worthto.ecps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worthto.ecps.dao.IEbCatDao;
import com.worthto.ecps.model.EbCat;
import com.worthto.ecps.service.IEbCatService;

@Service
public class EbCatServiceImpl implements IEbCatService {

	@Autowired
	private IEbCatDao catDao = null;

	public EbCat selectCatById(Long catId) {
		return catDao.selectCatById(catId);
	}

}

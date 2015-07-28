package com.worthto.ecps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worthto.ecps.dao.IEbItemClobDao;
import com.worthto.ecps.model.EbItemClob;
import com.worthto.ecps.service.IEbItemClobService;

@Service
public class EbItemClobServiceImpl implements IEbItemClobService {
	@Autowired
	private IEbItemClobDao itemClobDao;

	public void insert(EbItemClob itemClob) {
		itemClobDao.insert(itemClob);
	}

}

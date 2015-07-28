package com.worthto.ecps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worthto.ecps.dao.IEbFeatureDao;
import com.worthto.ecps.model.EbFeature;
import com.worthto.ecps.service.IEbFeatureService;

@Service
public class EbFeatureServiceimpl implements IEbFeatureService {

	@Autowired
	private IEbFeatureDao featureDao;

	public List<EbFeature> selectCommFeatures() {
		return featureDao.selectCommBySpec(0);
	}

	public List<EbFeature> selectSpecFeatures() {
		return featureDao.selectCommBySpec(1);
	}

}

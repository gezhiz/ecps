package com.worthto.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.worthto.ecps.dao.IEbFeatureDao;
import com.worthto.ecps.model.EbFeature;

@Repository
public class EbFeatureDaoImpl extends SqlSessionDaoSupport implements
		IEbFeatureDao {

	private String namespace = "com.worthto.ecps.mapper.EbFeatureMapper.";

	public List<EbFeature> selectCommBySpec(int isSpec) {
		return getSqlSession().selectList(namespace + "selectCommBySpec",
				isSpec);
	}

}

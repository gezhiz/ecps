package com.worthto.ecps.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.worthto.ecps.dao.IEbCatDao;
import com.worthto.ecps.model.EbCat;

@Repository
public class EbCatDaoImpl extends SqlSessionDaoSupport implements IEbCatDao {
	
	private String namespace = "com.worthto.ecps.mapper.EbCatMapper.";

	public EbCat selectCatById(Long catId) {
		return getSqlSession().selectOne(namespace+"selectByPrimaryKey",catId);
	}

}

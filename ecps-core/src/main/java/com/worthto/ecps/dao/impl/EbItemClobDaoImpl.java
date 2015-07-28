package com.worthto.ecps.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.worthto.ecps.dao.IEbItemClobDao;
import com.worthto.ecps.model.EbItemClob;

@Repository
public class EbItemClobDaoImpl extends SqlSessionDaoSupport implements
		IEbItemClobDao {
	private String namespace = "com.worthto.ecps.mapper.EbItemClobMapper.";

	public void insert(EbItemClob itemClob) {
		getSqlSession().insert(namespace + "insert", itemClob);
	}

}

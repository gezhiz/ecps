package com.worthto.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.worthto.ecps.dao.IEbItemDao;
import com.worthto.ecps.model.EbItem;
import com.worthto.ecps.utils.QueryCondition;

@Repository
public class ItemDaoImpl extends SqlSessionDaoSupport implements IEbItemDao {
	private String namespace = "com.worthto.ecps.mapper.EbItemMapper.";

	public List<EbItem> selectItemByCondition(QueryCondition queryCondition) {
		return getSqlSession().selectList(namespace+"selectItemByCondition",queryCondition);
	}

	public int selectItemByConditionCount(QueryCondition queryCondition) {
		return getSqlSession().selectOne(namespace+"selectItemByConditionCount",queryCondition);
	}

}

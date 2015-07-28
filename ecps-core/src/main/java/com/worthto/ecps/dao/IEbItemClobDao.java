package com.worthto.ecps.dao;

import com.worthto.ecps.model.EbItemClob;

public interface IEbItemClobDao {

	/**
	 * 插入一条商品大字段表数据
	 * @param itemClob
	 */
	void insert(EbItemClob itemClob);
	
}

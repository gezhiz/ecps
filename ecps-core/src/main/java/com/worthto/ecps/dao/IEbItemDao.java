package com.worthto.ecps.dao;

import java.util.List;

import com.worthto.ecps.model.EbItem;
import com.worthto.ecps.utils.QueryCondition;

public interface IEbItemDao {

	/**
	 * 按条件查找商品信息
	 * 
	 * @param queryCondition
	 * @return
	 */
	List<EbItem> selectItemByCondition(QueryCondition queryCondition);

	/**
	 * 
	 * @param queryCondition
	 * @return
	 */
	int selectItemByConditionCount(QueryCondition queryCondition);

}

package com.worthto.ecps.service;

import com.worthto.ecps.utils.Page;
import com.worthto.ecps.utils.QueryCondition;

public interface IEbItemService {
	/**
	 * 按条件查找商品信息
	 * @param queryCondition
	 * @return
	 */
	public Page selectItemByCondition(QueryCondition queryCondition);
}

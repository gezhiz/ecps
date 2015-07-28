package com.worthto.ecps.service;

import com.worthto.ecps.model.EbItem;
import com.worthto.ecps.utils.Page;
import com.worthto.ecps.utils.QueryCondition;

public interface IEbItemService {
	/**
	 * 按条件查找商品信息
	 * 
	 * @param queryCondition
	 * @return
	 */
	public Page selectItemByCondition(QueryCondition queryCondition);

	/**
	 * 根据id查找商品
	 * 
	 * @param itemId
	 * @return
	 */
	public EbItem selectItemById(Long itemId);

	/**
	 * 插入一条商品记录
	 * @param item
	 */
	public void insert(EbItem item);
}

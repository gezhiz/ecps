package com.worthto.ecps.dao;

import com.worthto.ecps.model.EbCat;

public interface IEbCatDao {

	/**
	 * 根据catId查询商品分类
	 * @param catId
	 * @return
	 */
	EbCat selectCatById(Long catId);

}

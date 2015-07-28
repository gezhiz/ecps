package com.worthto.ecps.service;

import com.worthto.ecps.model.EbCat;

public interface IEbCatService {

	/**
	 * 根据catId查看商品分类
	 * @param catId
	 * @return
	 */
	EbCat selectCatById(Long catId);

}

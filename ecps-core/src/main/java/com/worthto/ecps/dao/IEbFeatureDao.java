package com.worthto.ecps.dao;

import java.util.List;

import com.worthto.ecps.model.EbFeature;

public interface IEbFeatureDao {


	/**
	 * 查询普通属性：is_spec为0的属性
	 * @return
	 */
	List<EbFeature> selectCommBySpec(int isSpec);

}

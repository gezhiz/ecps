package com.worthto.ecps.service;

import java.util.List;

import com.worthto.ecps.model.EbFeature;

public interface IEbFeatureService {

	/**
	 * 查询普通属性:is_spec属性为0的属性
	 * @return
	 */
	List<EbFeature> selectCommFeatures();
	/**
	 * 查询普通属性:is_spec属性为1的属性
	 * @return
	 */
	List<EbFeature> selectSpecFeatures();

}

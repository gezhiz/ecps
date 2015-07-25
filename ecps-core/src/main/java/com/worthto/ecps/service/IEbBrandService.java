package com.worthto.ecps.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.worthto.ecps.model.EbBrand;

public interface IEbBrandService {
	/**
	 * 添加品牌
	 * 
	 * @param ebBrand
	 */
	public void saveEbBrand(EbBrand ebBrand);

	/**
	 * 查询所有品牌
	 * 
	 * @return
	 */
	public List<EbBrand> selectEbBrandAll();

	/**
	 * 根据品牌名称查询品牌
	 * 
	 * @param brandName
	 * @return *如果返回结果list大于2，证明有脏数据
	 */
	public List<EbBrand> selectEbBrandByName(String brandName);
	
	/**
	 * 根据ID删除品牌
	 * @param brandId
	 */
	public void deleteBrandById(Long brandId);

	public EbBrand selectEbBrandById(Long brandId);

	public void updateEbBrand(EbBrand brand);
}

package com.worthto.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.worthto.ecps.dao.IEbBrandDao;
import com.worthto.ecps.model.EbBrand;

@Repository
public class EbBrandDaoImpl extends SqlSessionDaoSupport implements IEbBrandDao {

	public void saveEbBrand(EbBrand ebBrand) {
		this.getSqlSession().insert("insert", ebBrand);
	}

	public List<EbBrand> selectEbBrandAll() {
		return this.getSqlSession().selectList("selectEbBrandAll");
	}

	public List<EbBrand> selectEbBrandByName(String brandName) {
		return this.getSqlSession().selectList("selectEbBrandByName",brandName);
	}

	public void deleteBrandById(Long brandId) {
		this.getSqlSession().delete("deleteByPrimaryKey",brandId);
	}

	public EbBrand selectEbBrandById(Long brandId) {
		return this.getSqlSession().selectOne("selectByPrimaryKey",brandId);
	}

	public void updateEbBrand(EbBrand brand) {
		this.getSqlSession().update("updateByPrimaryKeySelective",brand);
	}

}

package com.worthto.ecps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worthto.ecps.dao.IEbBrandDao;
import com.worthto.ecps.dao.IUploadDao;
import com.worthto.ecps.model.EbBrand;
import com.worthto.ecps.service.IEbBrandService;
import com.worthto.ecps.utils.EcpsUtils;

@Service
public class EbBrandServiceImpl implements IEbBrandService {
	@Autowired
	private IEbBrandDao erBrandDao;
	@Autowired
	private IUploadDao uploadDao;

	public void saveEbBrand(EbBrand ebBrand) {
		erBrandDao.saveEbBrand(ebBrand);
	}

	public List<EbBrand> selectEbBrandAll() {
		return erBrandDao.selectEbBrandAll();
	}

	public List<EbBrand> selectEbBrandByName(String brandName) {
		return erBrandDao.selectEbBrandByName(brandName);
	}

	public void deleteBrandById(Long brandId) {
		EbBrand brand = erBrandDao.selectEbBrandById(brandId);//查询结果
		erBrandDao.deleteBrandById(brandId);
		uploadDao.deleteBrandPic(EcpsUtils.readProp("file_host_path")+brand.getImgs());//删除对应的图片
	}

	public EbBrand selectEbBrandById(Long brandId) {
		return erBrandDao.selectEbBrandById(brandId);
	}

	public void updateEbBrand(EbBrand brand) {
		erBrandDao.updateEbBrand(brand);
	}

}

package com.test.java.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.worthto.ecps.model.EbBrand;
import com.worthto.ecps.service.IEbBrandService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/beans.xml")
public class EbBrandServiceTest {

	@Autowired
	private IEbBrandService service;

	@Test
	public void testSaveEbBrand() {
		EbBrand ebBrand = new EbBrand();
		ebBrand.setBrandName("vivo");
		ebBrand.setBrandSort(1);
		ebBrand.setBrandDesc("verygood");
		ebBrand.setImgs("vivo.jpg");
		ebBrand.setWebsite("http://www.vivo.com");
		service.saveEbBrand(ebBrand);
	}

	@Test
	public void testSelectEbBrandAll() {
		System.out.println(service.selectEbBrandAll());
	}

	@Test
	public void testSelectEbBrandByName() {
		System.out.println(service.selectEbBrandByName("步步高"));
	}
	
	@Test
	public void testDeleteEbBrandById(){
		service.deleteBrandById(3058L);
	}
	
	@Test
	public void testSelectEbBrandById(){
		EbBrand brand = service.selectEbBrandById(3065L);
		System.out.println(brand);
	}
	
	@Test
	public void testUpdateEbBrandById(){
		EbBrand brand = service.selectEbBrandById(3065L);
		brand.setBrandName("黎倩");
		service.updateEbBrand(brand);
		System.out.println(brand);
	}

}

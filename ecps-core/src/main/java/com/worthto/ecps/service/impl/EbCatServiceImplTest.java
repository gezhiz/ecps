package com.worthto.ecps.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.worthto.ecps.model.EbCat;
import com.worthto.ecps.service.IEbCatService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/beans.xml")
public class EbCatServiceImplTest {

	@Autowired
	private IEbCatService catService;

	@Test
	public void testSelectCatById() {
		EbCat ebCat = catService.selectCatById(1l);
		System.out.println(ebCat);
	}

}

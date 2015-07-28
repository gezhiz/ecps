package com.test.java.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.worthto.ecps.model.EbFeature;
import com.worthto.ecps.service.IEbFeatureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/beans.xml")
public class EbFeatureServiceimplTest {

	@Autowired
	private IEbFeatureService service;

	@Test
	public void testSelectCommBySpec() {
		List<EbFeature> features = service.selectCommFeatures();
		System.out.println(features.size());
	}

}

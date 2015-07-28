package com.test.java.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.worthto.ecps.model.EbItemClob;
import com.worthto.ecps.service.IEbItemClobService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/beans.xml")
public class EbItemClobServiceTest {

	@Autowired
	private IEbItemClobService service;

	@Test
	public void testInsert() {
		EbItemClob itemClob= new EbItemClob();
		itemClob.setItemId(2201L);
		itemClob.setItemDesc("gegeg");
		service.insert(itemClob);
	}
}
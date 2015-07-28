package com.test.java.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.worthto.ecps.model.EbItem;
import com.worthto.ecps.service.IEbItemService;
import com.worthto.ecps.utils.Page;
import com.worthto.ecps.utils.QueryCondition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/beans.xml")
public class EbItemServiceTest {

	@Autowired
	private IEbItemService service;

	@Test
	public void testSelectItemByCondition() {
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setPageNo(9);
		short audit = 1;
		short showstatus = 0;
		queryCondition.setAuditStatus(audit);
		queryCondition.setShowStatus(showstatus);
		queryCondition.setStartNo(10);
		queryCondition.setEndNo(20);
		Page page = service.selectItemByCondition(queryCondition);
		System.out.println(page.getItems());
	}

	@Test
	public void testSelectItemById() {
		EbItem item = service.selectItemById(3040L);
		System.out.println(item.getItemNo());
	}

	@Test
	public void testInsert(){
		EbItem item = new EbItem();
		item.setImgs("gegg");
		item.setItemName("李琴");
		item.setItemNo(new SimpleDateFormat("yyyyMMddss").format(new Date()));
		item.setCatId(1L);
		service.insert(item);
	}
}
package com.worthto.ecps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worthto.ecps.dao.IEbItemDao;
import com.worthto.ecps.model.EbItem;
import com.worthto.ecps.service.IEbItemService;
import com.worthto.ecps.utils.Page;
import com.worthto.ecps.utils.QueryCondition;

@Service
public class EbItemServiceImpl implements IEbItemService {

	@Autowired
	private IEbItemDao itemDao;

	public Page selectItemByCondition(QueryCondition queryCondition) {
		Page page = new Page();
		if (queryCondition.getPageNo()==null) {
			queryCondition.setPageNo(1);
		}else {
			queryCondition.setPageNo(queryCondition.getPageNo());
		}
		List<EbItem> list = itemDao.selectItemByCondition(queryCondition);
		page.setData(list);
		page.setTotalCount(itemDao.selectItemByConditionCount(queryCondition));
		return page;
	}

}

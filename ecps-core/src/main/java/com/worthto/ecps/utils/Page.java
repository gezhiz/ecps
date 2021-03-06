package com.worthto.ecps.utils;

import java.util.List;

public class Page {
	private Integer pageNo = 1;// 当前页码,需要设定
	private Integer pageSize = Context.getInt("pageSize");// 每页记录条数,需要设定
	private Integer totalCount = 0;// 总记录条数,需要设定
	private List<?> items;// 当前页的数据,需要给定

	private Integer totalPage = 0;// 总页数

	private Integer startNo;// 数据库中查询时开始条数
	private Integer endNo;// 数据库中查询时最终条数

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		totalPage = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
		return totalPage;
	}

	public Integer getStartNo() {
		return pageSize * (pageNo - 1);
	}

	public Integer getEndNo() {
		return pageSize * pageNo + 1;
	}

	public List<?> getItems() {
		return items;
	}

	public void setItems(List<?> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalCount=" + totalCount + ", items=" + items
				+ ", totalPage=" + totalPage + ", startNo=" + startNo
				+ ", endNo=" + endNo + "]";
	}

}

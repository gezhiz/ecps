package com.worthto.ecps.utils;

public class QueryCondition {
	private Long brandId;
	private short auditStatus;
	private short showStatus;
	private String itemName;
	private Integer endNum;
	private Integer startNum;
	private Integer pageNo;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public short getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(short auditStatus) {
		this.auditStatus = auditStatus;
	}

	public short getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(short showStatus) {
		this.showStatus = showStatus;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getEndNum() {
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

}

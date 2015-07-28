package com.worthto.ecps.utils;

public class QueryCondition {
	private Long brandId;
	private Short auditStatus;
	private Short showStatus;
	private String itemName;
	private Integer endNo = Context.getInt("pageSize") + 1;
	private Integer startNo = 0;
	private Integer pageNo;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Short getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Short auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Short getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Short showStatus) {
		this.showStatus = showStatus;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getEndNo() {
		return endNo;
	}

	public void setEndNo(Integer endNo) {
		this.endNo = endNo;
	}

	public Integer getStartNo() {
		return startNo;
	}

	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "QueryCondition [brandId=" + brandId + ", auditStatus="
				+ auditStatus + ", showStatus=" + showStatus + ", itemName="
				+ itemName + ", endNo=" + endNo + ", startNo=" + startNo
				+ ", pageNo=" + pageNo + "]";
	}

}

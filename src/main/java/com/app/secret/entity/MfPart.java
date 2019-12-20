package com.app.secret.entity;

public class MfPart {

	private java.lang.String id; // 主键
	private java.lang.String partName; // 中心名
	private java.util.Date insertTime; // 插入时间
	private java.util.Date updateTime; // 更新时间
	private java.lang.String updateUserPcode; // 更新人员工号

	public java.lang.String getId() {
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getPartName() {
		return this.partName;
	}

	public void setPartName(java.lang.String partName) {
		this.partName = partName;
	}

	public java.util.Date getInsertTime() {
		return this.insertTime;
	}

	public void setInsertTime(java.util.Date insertTime) {
		this.insertTime = insertTime;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public java.lang.String getUpdateUserPcode() {
		return this.updateUserPcode;
	}

	public void setUpdateUserPcode(java.lang.String updateUserPcode) {
		this.updateUserPcode = updateUserPcode;
	}
}

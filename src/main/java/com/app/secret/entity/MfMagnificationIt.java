package com.app.secret.entity;

import javax.persistence.Id;

public class MfMagnificationIt {
	@Id
	private java.lang.String id; // 主键
	private java.lang.Integer workDateType; // 工作日类型：1工作日 2周末 3节假日
	private java.lang.Integer magValue; // 倍率
	private java.util.Date insertTime; // 插入时间
	private java.util.Date updateTime; // 更新时间
	private java.lang.String updateUserPcode; // 更新人员工号

	public java.lang.String getId() {
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.Integer getWorkDateType() {
		return this.workDateType;
	}

	public void setWorkDateType(java.lang.Integer workDateType) {
		this.workDateType = workDateType;
	}

	public java.lang.Integer getMagValue() {
		return this.magValue;
	}

	public void setMagValue(java.lang.Integer magValue) {
		this.magValue = magValue;
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

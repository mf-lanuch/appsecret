package com.app.secret.entity;

import javax.persistence.Id;

public class MfUserInfo {
	@Id
	private java.lang.String id; // 主键
	private java.lang.String pcode; // 工号
	private java.lang.String pname; // 姓名
	private java.lang.String password; // 密码
	private java.lang.Integer isIt; // 是否为IT人员:1是 0否
	private java.lang.String partId; // 中心关联ID
	private java.lang.String poId; // 职位关联ID
	private java.util.Date insertTime; // 插入时间
	private java.util.Date updateTime; // 更新时间
	private java.lang.String updateUserPcode; // 更新人员工号

	public java.lang.String getId() {
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getPcode() {
		return this.pcode;
	}

	public void setPcode(java.lang.String pcode) {
		this.pcode = pcode;
	}

	public java.lang.String getPname() {
		return this.pname;
	}

	public void setPname(java.lang.String pname) {
		this.pname = pname;
	}

	public java.lang.String getPassword() {
		return this.password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.Integer getIsIt() {
		return this.isIt;
	}

	public void setIsIt(java.lang.Integer isIt) {
		this.isIt = isIt;
	}

	public java.lang.String getPartId() {
		return this.partId;
	}

	public void setPartId(java.lang.String partId) {
		this.partId = partId;
	}

	public java.lang.String getPoId() {
		return this.poId;
	}

	public void setPoId(java.lang.String poId) {
		this.poId = poId;
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

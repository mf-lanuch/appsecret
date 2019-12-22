package com.app.secret.entity;

public class MfWork {

	private java.lang.String id; // 主键
	private java.lang.String userId; // 关联用户ID
	private java.util.Date workDate; // 工作日期
	private java.lang.Integer week; // 周期
	private java.lang.Object workYear; // 工作年份
	private java.lang.Integer workMonth; // 工作月份
	private java.lang.Integer status; // 工作状态：1上班 2事假 3调休 4病假 5公务外出 6异常
	private java.util.Date startTime; // 打卡起始时间
	private java.util.Date endTime; // 打卡终止时间
	private java.util.Date insertTime; // 插入时间
	private java.util.Date updateTime; // 更新时间

	public java.lang.String getId() {
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}

	public java.lang.String getUserId() {
		return this.userId;
	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

	public java.util.Date getWorkDate() {
		return this.workDate;
	}

	public void setWorkDate(java.util.Date workDate) {
		this.workDate = workDate;
	}

	public java.lang.Integer getWeek() {
		return this.week;
	}

	public void setWeek(java.lang.Integer week) {
		this.week = week;
	}

	public java.lang.Object getWorkYear() {
		return this.workYear;
	}

	public void setWorkYear(java.lang.Object workYear) {
		this.workYear = workYear;
	}

	public java.lang.Integer getWorkMonth() {
		return this.workMonth;
	}

	public void setWorkMonth(java.lang.Integer workMonth) {
		this.workMonth = workMonth;
	}

	public java.lang.Integer getStatus() {
		return this.status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}

	public java.util.Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}

	public java.util.Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
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
}

package com.app.secret.entity;

import javax.persistence.Id;
import java.util.Date;

public class MfBreakOff {

    @Id
    private java.lang.String id; // 主键
    private java.lang.String userId; // 用户ID
    private java.lang.Object workYear; // 工作年份
    private java.lang.Integer workMonth; // 工作月份
    private java.util.Date usableBreakOffTime; // 打卡起始时间
    private java.util.Date usedBreakOffTime; // 打卡终止时间
    private java.util.Date insertTime; // 插入时间
    private java.util.Date updateTime; // 更新时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getWorkYear() {
        return workYear;
    }

    public void setWorkYear(Object workYear) {
        this.workYear = workYear;
    }

    public Integer getWorkMonth() {
        return workMonth;
    }

    public void setWorkMonth(Integer workMonth) {
        this.workMonth = workMonth;
    }

    public Date getUsableBreakOffTime() {
        return usableBreakOffTime;
    }

    public void setUsableBreakOffTime(Date usableBreakOffTime) {
        this.usableBreakOffTime = usableBreakOffTime;
    }

    public Date getUsedBreakOffTime() {
        return usedBreakOffTime;
    }

    public void setUsedBreakOffTime(Date usedBreakOffTime) {
        this.usedBreakOffTime = usedBreakOffTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

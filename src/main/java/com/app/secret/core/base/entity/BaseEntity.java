package com.app.secret.core.base.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import com.app.secret.core.base.annotation.EnableExample;
import io.swagger.annotations.ApiModelProperty;

public class BaseEntity {

	@EnableExample
	@Id
	@ApiModelProperty("主键ID")
	protected String uuid;

	@Column(name = "DOC_CREATOR_ID")
	@ApiModelProperty("创建者ID")
	protected String docCreatorId;
	@Column(name = "DOC_CREATOR_NAME")
	@ApiModelProperty("创建者名称")
	protected String docCreatorName;
	@Column(name = "DOC_ALTEROR_ID")
	@ApiModelProperty("修改者ID")
	protected String docAlterorId;
	@Column(name = "DOC_ALTEROR_NAME")
	@ApiModelProperty("修改者名称")
	protected String docAlterorName;
	@Column(name = "DOC_CREATE_TIME")
	@ApiModelProperty("创建时间")
	protected String docCreateTime;
	@Column(name = "DOC_ALTEROR_TIME")
	@ApiModelProperty("修改时间")
	protected String docAlterorTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDocCreatorId() {
		return docCreatorId;
	}

	public void setDocCreatorId(String docCreatorId) {
		this.docCreatorId = docCreatorId;
	}

	public String getDocCreatorName() {
		return docCreatorName;
	}

	public void setDocCreatorName(String docCreatorName) {
		this.docCreatorName = docCreatorName;
	}

	public String getDocAlterorId() {
		return docAlterorId;
	}

	public void setDocAlterorId(String docAlterorId) {
		this.docAlterorId = docAlterorId;
	}

	public String getDocAlterorName() {
		return docAlterorName;
	}

	public void setDocAlterorName(String docAlterorName) {
		this.docAlterorName = docAlterorName;
	}

	public String getDocCreateTime() {
		return docCreateTime;
	}

	public void setDocCreateTime(String docCreateTime) {
		this.docCreateTime = docCreateTime;
	}

	public String getDocAlterorTime() {
		return docAlterorTime;
	}

	public void setDocAlterorTime(String docAlterorTime) {
		this.docAlterorTime = docAlterorTime;
	}
	
}

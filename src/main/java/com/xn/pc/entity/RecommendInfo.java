package com.xn.pc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "recommend_info")
public class RecommendInfo {
	
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "RI_ID")// 主键
	private String riId; 
	@Column(name = "RII_ID")// 图片信息表外键
	private String riiId; 
	@Column(name = "RI_CATEGORY")// 品类 0:食材，1:手艺，2:新农人，3:手艺人，4:其他
	private String riCategory; 
	@Column(name = "RI_CATEGORY_NAME")// 名称
	private String riCategoryName; 
	@Column(name = "RI_LOCATION")// 产地
	private String riLocation; 
	@Column(name = "RI_ON_CATEGORY")// 关于TA
	private String riOnCategory; 
	@Column(name = "RI_PERSONAL_OR_UNIT")// 选择单位或个人 0：个人，1：单位
	private String riPersonalOrUnit; 
	@Column(name = "RI_NAME")// （个人或单位）名称
	private String riName; 
	@Column(name = "RI_PHONE")//（个人或单位）电话
	private String riPhone; 
	@Column(name = "RI_UNIT_LOCATION") // （单位）所在地区
	private String riUnitLocation;
	@Column(name = "CREATE_TIME") // 创建时间
	private String createTime;
	@Column(name = "UPDATE_TIME")// 更新时间
	private String updateTime; 
	@Column(name = "DELETE_FLAG")// 删除标示
	private String deleteFlag;
	
	
	
	
	
	public String getRiId() {
		return riId;
	}
	public void setRiId(String riId) {
		this.riId = riId;
	}
	public String getRiiId() {
		return riiId;
	}
	public void setRiiId(String riiId) {
		this.riiId = riiId;
	}
	public String getRiCategory() {
		return riCategory;
	}
	public void setRiCategory(String riCategory) {
		this.riCategory = riCategory;
	}
	public String getRiCategoryName() {
		return riCategoryName;
	}
	public void setRiCategoryName(String riCategoryName) {
		this.riCategoryName = riCategoryName;
	}
	public String getRiLocation() {
		return riLocation;
	}
	public void setRiLocation(String riLocation) {
		this.riLocation = riLocation;
	}
	public String getRiOnCategory() {
		return riOnCategory;
	}
	public void setRiOnCategory(String riOnCategory) {
		this.riOnCategory = riOnCategory;
	}
	public String getRiPersonalOrUnit() {
		return riPersonalOrUnit;
	}
	public void setRiPersonalOrUnit(String riPersonalOrUnit) {
		this.riPersonalOrUnit = riPersonalOrUnit;
	}
	public String getRiName() {
		return riName;
	}
	public void setRiName(String riName) {
		this.riName = riName;
	}
	public String getRiPhone() {
		return riPhone;
	}
	public void setRiPhone(String riPhone) {
		this.riPhone = riPhone;
	}
	public String getRiUnitLocation() {
		return riUnitLocation;
	}
	public void setRiUnitLocation(String riUnitLocation) {
		this.riUnitLocation = riUnitLocation;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	

}
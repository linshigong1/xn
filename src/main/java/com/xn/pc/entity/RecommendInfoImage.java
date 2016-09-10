package com.xn.pc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "recommend_info_image")
public class RecommendInfoImage {
	
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "RII_ID")// 主键
	private String riiId; 
	@Column(name = "RII_IMAGE_INFO")// 图片信息
	private String riiImageInfo; 
	@Column(name = "RII_DESCRI")// 描述
	private String riiDescri; 
	@Column(name = "CREATE_TIME") // 创建时间
	private String createTime;
	@Column(name = "UPDATE_TIME")// 更新时间
	private String updateTime; 
	@Column(name = "DELETE_FLAG")// 删除标示
	private String deleteFlag;
	
	
	
	public String getRiiId() {
		return riiId;
	}

	public void setRiiId(String riiId) {
		this.riiId = riiId;
	}


	public String getRiiImageInfo() {
		return riiImageInfo;
	}

	public void setRiiImageInfo(String riiImageInfo) {
		this.riiImageInfo = riiImageInfo;
	}

	
	public String getRiiDescri() {
		return riiDescri;
	}

	public void setRiiDescri(String riiDescri) {
		this.riiDescri = riiDescri;
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
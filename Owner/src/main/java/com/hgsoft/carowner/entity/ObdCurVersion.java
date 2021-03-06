package com.hgsoft.carowner.entity;


import java.util.Date;

/**
 * ObdVersion generated by hbm2java
 * obd当前版本号
 */
public class ObdCurVersion implements java.io.Serializable {

	private Integer id;
	private String obdSn;
	private String hardware;//
	private String iap;
	private String osoftware;//obd主动上传的版本号
	private String software;//升级版本号
	private Date createTime;
	private Date updateTime;
	private String remark;

	public ObdCurVersion() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObdSn() {
		return obdSn;
	}

	public void setObdSn(String obdSn) {
		this.obdSn = obdSn;
	}

	public String getHardware() {
		return hardware;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public String getIap() {
		return iap;
	}

	public void setIap(String iap) {
		this.iap = iap;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOsoftware() {
		return osoftware;
	}

	public void setOsoftware(String osoftware) {
		this.osoftware = osoftware;
	}
	
	
}

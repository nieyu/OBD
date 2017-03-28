package com.hgsoft.carowner.entity;


import java.util.Date;

/**
 * Wifi generated by hbm2java
 */
public class GpsSet implements java.io.Serializable {

	private Integer id;
	private String obdSn;
	private String gpsState;
	private Date createTime;
	private Date updateTime;
	private String valid;

	public GpsSet() {
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

	public String getGpsState() {
		return gpsState;
	}

	public void setGpsState(String gpsState) {
		this.gpsState = gpsState;
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

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "GpsSet [id=" + id + ", obdSn=" + obdSn + ", gpsState="
				+ gpsState + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", valid=" + valid + "]";
	}

}
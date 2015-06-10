/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.vo;

/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.vo.Weather
 * @version	V0.0.1-SNAPSHOT, 2015年6月10日 下午4:46:35
 * @description
 * 
 */
public class Weather {
	/**
	 * 城市
	 */
	private String city;
	
	/**
	 * 城市
	 */
	private String cityid;
	
	/**
	 * 最高气温
	 */
	private String temp1;
	
	/**
	 * 最低气温
	 */
	private String temp2;
	
	/**
	 * 天气
	 */
	private String weather;
	
	/**
	 * 天气图片1
	 */
	private String img1;
	
	/**
	 * 天气图片2
	 */
	private String img2;
	
	/**
	 * 发布时间
	 */
	private String ptime;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getTemp1() {
		return temp1;
	}

	public void setTemp1(String temp1) {
		this.temp1 = temp1;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
}

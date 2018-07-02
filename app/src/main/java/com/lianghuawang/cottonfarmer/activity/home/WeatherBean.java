package com.lianghuawang.cottonfarmer.activity.home;


public class WeatherBean {

	private String w_am; // 天气现象上午
	private String wind; // 风力
	private String tmp_max; // 预测最高温度
	private String tmp_min; // 预测最低温度

	public String getW_am() {
		return w_am;
	}

	public void setW_am(String w_am) {
		this.w_am = w_am;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getTmp_max() {
		return tmp_max;
	}

	public void setTmp_max(String tmp_max) {
		this.tmp_max = tmp_max;
	}

	public String getTmp_min() {
		return tmp_min;
	}

	public void setTmp_min(String tmp_min) {
		this.tmp_min = tmp_min;
	}
}

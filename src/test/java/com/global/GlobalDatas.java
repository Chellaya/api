package com.global;

/**
 * @author ashok
 * @see  this method used to perform global values
 * @since 02-06-2023
 *
 */
public class GlobalDatas {
	
	private int statusCode;
	private String stateId;
	private String CityId;
	
	private int stateid;
	private String logtoken;
	
	private String address_Id;
	
	

	public String getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(String address_Id) {
		this.address_Id = address_Id;
	}

	public String getLogtoken() {
		return logtoken;
	}

	public void setLogtoken(String logtoken) {
		this.logtoken = logtoken;
	}

	public int getStateid() {
		return stateid;
	}

	public void setStateid(int stateid) {
		this.stateid = stateid;
	}

	public String getCityId() {
		return CityId;
	}

	public void setCityId(String cityId) {
		CityId = cityId;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public int setStatusCode(int statusCode) {
		return this.statusCode = statusCode;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	

}

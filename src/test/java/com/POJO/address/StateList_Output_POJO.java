package com.POJO.address;

import java.util.ArrayList;

public class StateList_Output_POJO {
	
	 private int status;
	 private String message;
	 private ArrayList<State> data;
	 
	 
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<State> getData() {
		return data;
	}
	public void setData(ArrayList<State> data) {
		this.data = data;
	}

}

package com.topcheersc.schoolsystem.pojo;

import java.io.Serializable;
/**
 * 
* @author YX
* @date 2019年11月19日下午4:07:06
* @Description:学生表
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6985627308611620235L;
	/*
	 * 学生id
	 */
	private int ID;
	/*
	 * 学生姓名
	 */
	private String NAME;
	/*
	 * 学生性别，0表示男性，1表示女性
	 */
	private String GENDER;
	/*
	 * 年龄
	 */
	private String AGE;
	/*
	 * 出生日期
	 */
	private String BIRTHDAY;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getGENDER() {
		return GENDER;
	}
	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	
	public String getBIRTHDAY() {
		return BIRTHDAY;
	}
	public void setBIRTHDAY(String bIRTHDAY) {
		BIRTHDAY = bIRTHDAY;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", NAME=" + NAME + ", GENDER=" + GENDER + ", AGE=" + AGE + ", BIRTHDAY=" + BIRTHDAY
				+ "]";
	}
	
	
	
}

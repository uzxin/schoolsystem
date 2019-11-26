package com.topcheersc.schoolsystem.pojo;
/**
 * 
* @author YX
* @date 2019年11月21日下午8:29:03
* @Description:教师
 */

import java.io.Serializable;

public class Teacher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 教师ID
	 */
	private int ID;
	/*
	 * 教师姓名
	 */
	private String NAME;
	/**
	 * 教师性别
	 */
	private String GENDER;
	/**
	 * 教师年龄
	 */
	private String AGE;
	/**
	 * 教师生日
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
		return "Teacher [ID=" + ID + ", NAME=" + NAME + ", GENDER=" + GENDER + ", AGE=" + AGE + ", BIRTHDAY=" + BIRTHDAY
				+ "]";
	}
	
	
}

package com.topcheersc.schoolsystem.vo;

import java.io.Serializable;
/**
 * 
* @author YX
* @date 2019年11月19日下午4:07:06
* @Description:学生表的VO对象
 */
public class UserVO implements Serializable{

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
	/**
	 * 班级ID
	 */
	private Integer CLASS_ID;
	/**
	 * 班级名字
	 */
	private String CLASS_NAME;
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
	public Integer getCLASS_ID() {
		return CLASS_ID;
	}
	public void setCLASS_ID(Integer cLASS_ID) {
		CLASS_ID = cLASS_ID;
	}
	public String getCLASS_NAME() {
		return CLASS_NAME;
	}
	public void setCLASS_NAME(String cLASS_NAME) {
		CLASS_NAME = cLASS_NAME;
	}
	@Override
	public String toString() {
		return "UserVO [ID=" + ID + ", NAME=" + NAME + ", GENDER=" + GENDER + ", AGE=" + AGE + ", BIRTHDAY=" + BIRTHDAY
				+ ", CLASS_ID=" + CLASS_ID + ", CLASS_NAME=" + CLASS_NAME + "]";
	}
	public UserVO(int iD, String nAME, String gENDER, String aGE, String bIRTHDAY, Integer cLASS_ID,
			String cLASS_NAME) {
		super();
		ID = iD;
		NAME = nAME;
		GENDER = gENDER;
		AGE = aGE;
		BIRTHDAY = bIRTHDAY;
		CLASS_ID = cLASS_ID;
		CLASS_NAME = cLASS_NAME;
	}
	public UserVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

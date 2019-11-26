package com.topcheersc.schoolsystem.pojo;

import java.io.Serializable;

/**
* @author YX
* @date 2019年11月22日上午9:46:28
* @Description:课程
*/
public class Subject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2493803395360117475L;
	/**
	 * 课程ID
	 */
	private Integer ID;
	/**
	 * 课程名字
	 */
	private String NAME;
	/**
	 * 课程类型ID
	 */
	private Integer TYPE_ID;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public Integer getTYPE_ID() {
		return TYPE_ID;
	}
	public void setTYPE_ID(Integer tYPE_ID) {
		TYPE_ID = tYPE_ID;
	}
	@Override
	public String toString() {
		return "Subject [ID=" + ID + ", NAME=" + NAME + ", TYPE_ID=" + TYPE_ID + "]";
	}
	
}

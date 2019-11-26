package com.topcheersc.schoolsystem.pojo;

import java.io.Serializable;

/**
* @author YX
* @date 2019年11月22日上午9:51:07
* @Description:课程类型
*/
public class SubjectType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 课程类型ID
	 */
	private Integer ID;
	/**
	 * 课程类型名字
	 */
	private String NAME;
	/**
	 * 上级类型
	 */
	private String P_ID;
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
	public String getP_ID() {
		return P_ID;
	}
	public void setP_ID(String p_ID) {
		P_ID = p_ID;
	}
	@Override
	public String toString() {
		return "SubjectType [ID=" + ID + ", NAME=" + NAME + ", P_ID=" + P_ID + "]";
	}
	
}

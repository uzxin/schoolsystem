package com.topcheersc.schoolsystem.vo;

import java.io.Serializable;


/**
* @author YX
* @date 2019年11月22日上午10:58:08
* @Description:课程表的VO对象
*/
public class SubjectVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	/**
	 * 课程类型名字
	 */
	private String TYPE_NAME;
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
	public String getTYPE_NAME() {
		return TYPE_NAME;
	}
	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}
	public SubjectVO(Integer iD, String nAME, Integer tYPE_ID, String tYPE_NAME) {
		super();
		ID = iD;
		NAME = nAME;
		TYPE_ID = tYPE_ID;
		TYPE_NAME = tYPE_NAME;
	}
	public SubjectVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SubjectVO [ID=" + ID + ", NAME=" + NAME + ", TYPE_ID=" + TYPE_ID + ", TYPE_NAME=" + TYPE_NAME + "]";
	}
	
	
	
}

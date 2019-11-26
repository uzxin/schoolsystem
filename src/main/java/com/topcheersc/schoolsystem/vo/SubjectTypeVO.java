package com.topcheersc.schoolsystem.vo;

import java.io.Serializable;

/**
* @author YX
* @date 2019年11月22日上午11:04:36
* @Description:课程类型表的VO对象
*/
public class SubjectTypeVO implements Serializable{

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
	 * 课程类型上级类型ID
	 */
	private Integer P_ID;
	/**
	 * 课程类型上级类型名字
	 */
	private String P_NAME;
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
	public Integer getP_ID() {
		return P_ID;
	}
	public void setP_ID(Integer p_ID) {
		P_ID = p_ID;
	}
	public String getP_NAME() {
		return P_NAME;
	}
	public void setP_NAME(String p_NAME) {
		P_NAME = p_NAME;
	}
	@Override
	public String toString() {
		return "SubjectTypeVO [ID=" + ID + ", NAME=" + NAME + ", P_ID=" + P_ID + ", P_NAME=" + P_NAME + "]";
	}
	public SubjectTypeVO(Integer iD, String nAME, Integer p_ID, String p_NAME) {
		super();
		ID = iD;
		NAME = nAME;
		P_ID = p_ID;
		P_NAME = p_NAME;
	}
	public SubjectTypeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

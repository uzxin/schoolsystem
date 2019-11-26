package com.topcheersc.schoolsystem.pojo;

import java.io.Serializable;

/**
* @author YX
* @date 2019年11月22日下午3:03:20
* @Description:班级
*/
public class ClassPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 班级ID
	 */
	private Integer ID;
	/**
	 * 班级名字
	 */
	private String NAME;
	/**
	 * 级别
	 */
	private Integer CLASS_LEVEL;
	/**
	 * 班级号码
	 */
	private Integer CLASS_NUM;
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
	public Integer getCLASS_LEVEL() {
		return CLASS_LEVEL;
	}
	public void setCLASS_LEVEL(Integer cLASS_LEVEL) {
		CLASS_LEVEL = cLASS_LEVEL;
	}
	public Integer getCLASS_NUM() {
		return CLASS_NUM;
	}
	public void setCLASS_NUM(Integer cLASS_NUM) {
		CLASS_NUM = cLASS_NUM;
	}
	@Override
	public String toString() {
		return "ClassPO [ID=" + ID + ", NAME=" + NAME + ", CLASS_LEVEL=" + CLASS_LEVEL + ", CLASS_NUM=" + CLASS_NUM
				+ "]";
	}
	
}

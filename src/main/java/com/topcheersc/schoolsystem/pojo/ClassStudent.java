package com.topcheersc.schoolsystem.pojo;

import java.io.Serializable;

/**
* @author YX
* @date 2019年11月22日下午4:07:54
* @Description:班级 and 学生
*/
public class ClassStudent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 学生ID
	 */
	private Integer STUDENT_ID;
	/**
	 * 班级ID
	 */
	private Integer CLASS_ID;
	public Integer getSTUDENT_ID() {
		return STUDENT_ID;
	}
	public void setSTUDENT_ID(Integer sTUDENT_ID) {
		STUDENT_ID = sTUDENT_ID;
	}
	public Integer getCLASS_ID() {
		return CLASS_ID;
	}
	public void setCLASS_ID(Integer cLASS_ID) {
		CLASS_ID = cLASS_ID;
	}
	@Override
	public String toString() {
		return "ClassStudent [STUDENT_ID=" + STUDENT_ID + ", CLASS_ID=" + CLASS_ID + "]";
	}
	
}

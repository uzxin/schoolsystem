package com.topcheersc.schoolsystem.service;

import java.util.List;

import com.topcheersc.schoolsystem.pojo.SubjectType;

/**
* @author YX
* @date 2019年11月22日上午11:09:14
* @Description:课程类型表的操作接口
*/
public interface SubjectTypeService {

	/**
	 * 
	 * @Description:根据课程类型ID查询课程类型名字
	 * @param @param type_ID 课程类型ID
	 * @param @return
	 * @return String
	 */
	String getTypeNameById(Integer type_ID);

	/**
	 * 
	 * @Description:返回课程类型列表
	 * @param @return
	 * @return List<SubjectType>
	 */
	List<SubjectType> listSubjectType();

	/**
	 * 
	 * @Description:修改课程类型信息
	 * @param @param s
	 * @return void
	 */
	void update(SubjectType subjectType);

	/**
	 * 
	 * @Description:返回学科类型个数
	 * @param @return
	 * @return int
	 */
	int countSubjectType();

	/**
	 * 
	 * @Description:根据ID删除学科类型
	 * @param @param parseInt
	 * @param @return
	 * @return boolean
	 */
	boolean deleteById(int id);

	/**
	 * 
	 * @Description:批量删除课程类型
	 * @param @param idList
	 * @param @return
	 * @return boolean
	 */
	boolean batchDelete(List<Integer> idList);

	/**
	 * 
	 * @Description:添加学科类型
	 * @param @param subjectType
	 * @param @return
	 * @return boolean
	 */
	boolean saveSubjectType(SubjectType subjectType);

}

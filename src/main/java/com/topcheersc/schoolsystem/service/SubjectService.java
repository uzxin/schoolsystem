package com.topcheersc.schoolsystem.service;

import java.util.List;

import com.topcheersc.schoolsystem.pojo.Subject;

/**
* @author YX
* @date 2019年11月22日上午10:03:32
* @Description:课程表的操作接口
*/
public interface SubjectService {

	/**
	 * 
	 * @Description:返回课程列表
	 * @param @param page 当前页数
	 * @param @param limit 每页显示的条数
	 * @param @return
	 * @return List<Subject>
	 */
	List<Subject> listSubject(int page, int limit);

	/**
	 * 
	 * @Description:返回课程表的行数
	 * @param @return
	 * @return int
	 */
	int countSubject();

	/**
	 * 
	 * @Description:模糊查询课程表
	 * @param @param id 课程ID
	 * @param @param name 课程名字
	 * @param @param type_id 课程类型
	 * @param @param page 当前页数
	 * @param @param limit 每页显示的条数
	 * @param @return
	 * @return List<Subject>
	 */
	List<Subject> queryByCondition(Integer id, String name, String type_id, int page, int limit);

	/**
	 * 
	 * @Description:根据ID删除课程信息
	 * @param @param id
	 * @param @return
	 * @return boolean
	 */
	boolean deleteById(int id);

	/**
	 * 
	 * @Description:批量删除
	 * @param @param idList
	 * @param @return
	 * @return boolean
	 */
	boolean batchDelete(List<Integer> idList);

	/**
	 * 
	 * @Description:修改课程信息
	 * @param @param subject
	 * @param @return
	 * @return boolean
	 */
	boolean update(Subject subject);

	/**
	 * 
	 * @Description:添加课程
	 * @param @param subject
	 * @param @return
	 * @return boolean
	 */
	boolean saveSubject(Subject subject);

}

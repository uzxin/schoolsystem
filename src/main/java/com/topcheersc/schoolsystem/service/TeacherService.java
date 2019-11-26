package com.topcheersc.schoolsystem.service;

import java.util.List;

import com.topcheersc.schoolsystem.pojo.Teacher;;

/**
* @author YX
* @date 2019年11月22日上午8:48:52
* @Description:教师表操作接口
*/
public interface TeacherService {

	/**
	 * 
	 * @Description:返回教师数据
	 * @param limit 
	 * @param page 
	 * @param @return
	 * @return List<User>
	 */
	List<Teacher> listTeacher(int page, int limit);

	/**
	 * 
	 * @Description:根据id删除教师信息
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
	 * @Description:修改教师信息
	 * @param @param teacher
	 * @param @return
	 * @return boolean
	 */
	boolean update(Teacher teacher);

	/**
	 * 
	 * @Description:获取教师表的总条数
	 * @param @return
	 * @return int
	 */
	int countTeacher();

	/**
	 * 
	 * @Description:添加教师
	 * @param @param teacher
	 * @param @return
	 * @return boolean
	 */
	boolean saveTeacher(Teacher teacher);

	/**
	 * 
	 * @Description:教师列表模糊查询
	 * @param @param id 教师ID
	 * @param @param name 学教师姓名
	 * @param @param gender 教师性别
	 * @param @param page 当前页数
	 * @param @param limit 每页显示的条数
	 * @param @return
	 * @return List<Teacher>
	 */
	List<Teacher> queryByCondition(Integer id, String name, String gender, int page, int limit);

}

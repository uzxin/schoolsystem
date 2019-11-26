package com.topcheersc.schoolsystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.topcheersc.schoolsystem.pojo.Teacher;

/**
* @author YX
* @date 2019年11月22日上午8:53:38
* @Description:教师表的mapper接口
*/
@Mapper
public interface TeacherMapper {

	/**
	 * 
	 * @Description:获取所有教师数据
	 * @param limit 
	 * @param page 
	 * @param @return
	 * @return List<Teacher>
	 */
	List<Teacher> listTeacher(@Param("page") int page, @Param("limit") int limit);

	/**
	 * 
	 * @Description:根据id删除教师信息
	 * @param @param id
	 * @param @return
	 * @return int
	 */
	int deleteById(int id);

	/**
	 * 
	 * @Description:修改教师信息
	 * @param @param Teacher
	 * @param @return
	 * @return int
	 */
	int update(@Param("teacher") Teacher teacher);

	/**
	 * 
	 * @Description:查询教师表总条数
	 * @param @return
	 * @return int
	 */
	int countTeacher();

	/**
	 * 
	 * @Description:批量删除
	 * @param @param idList
	 * @param @return
	 * @return int
	 */
	int batchDelete(@Param("list") List<Integer> idList);

	/**
	 * 
	 * @Description:添加教师
	 * @param @param Teacher
	 * @param @return
	 * @return int
	 */
	int saveTeacher(@Param("teacher") Teacher teacher);

	/**
	 * 
	 * @param limit 
	 * @param page 
	 * @Description:教师列表模糊查询
	 * @param @param id 教师ID
	 * @param @param name 教师姓名
	 * @param @param gender 教师性别
	 * @param @param page 当前页数
	 * @param @param limit 每页显示的条数
	 * @param @return
	 * @return List<Teacher>
	 */
	List<Teacher> queryByCondition(@Param("id") Integer id, @Param("name")String name
			, @Param("gender")String gender, @Param("page") int page
			, @Param("limit") int limit);
	

}

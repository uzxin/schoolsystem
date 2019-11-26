package com.topcheersc.schoolsystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.topcheersc.schoolsystem.pojo.Subject;

/**
* @author YX
* @date 2019年11月22日上午10:05:03
* @Description:课程表的mapper接口
*/
@Mapper
public interface SubjectMapper {

	/**
	 * 
	 * @Description:获取课程列表
	 * @param @param page 当前页数
	 * @param @param limit 每页显示的条数
	 * @param @return
	 * @return List<Subject>
	 */
	List<Subject> listSubject(@Param("page") int page, @Param("limit") int limit);

	/**
	 * 
	 * @Description:获取课程表总条数
	 * @param @return
	 * @return int
	 */
	int countSubject();

	/**
	 * 
	 * @Description:课程列表模糊查询
	 * @param @param id 课程ID
	 * @param @param name 课程名字
	 * @param @param type_id 课程类型
	 * @param @param page 当前页数
 	 * @param @param limit 每页显示的条数
	 * @param @return
	 * @return List<Subject>
	 */
	List<Subject> queryByCondition(@Param("id") Integer id, @Param("name") String name
			, @Param("type_id") String type_id, @Param("page") int page, @Param("limit")int limit);

	/**
	 * 
	 * @Description:根据ID删除课程信息
	 * @param @param id 课程ID
	 * @param @return
	 * @return int
	 */
	int deleteById(@Param("id") int id);

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
	 * @Description:修改课程信息
	 * @param @param subject
	 * @param @return
	 * @return int
	 */
	int update(@Param("subject") Subject subject);

	/**
	 * 
	 * @Description:添加课程
	 * @param @param subject
	 * @param @return
	 * @return int
	 */
	int saveSubject(@Param("subject") Subject subject);

}

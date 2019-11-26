package com.topcheersc.schoolsystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.topcheersc.schoolsystem.pojo.SubjectType;

/**
* @author YX
* @date 2019年11月22日上午11:13:41
* @Description:课程类型mapper接口
*/
@Mapper
public interface SubjectTypeMapper {

	/**
	 * 
	 * @Description:根据课程类型ID查询课程类型名字
	 * @param @param type_ID 课程类型ID
	 * @param @return
	 * @return String
	 */
	String getTypeNameById(Integer ID);

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
	 * @param @param subjectType
	 * @return void
	 */
	void update(@Param("subjectType") SubjectType subjectType);

	/**
	 * 
	 * @Description:统计学科类型数量
	 * @param @return
	 * @return int
	 */
	int countSubjectType();

	/**
	 * 
	 * @Description:根据ID删除学科类型
	 * @param @param id 学科类型ID
	 * @param @return
	 * @return int
	 */
	int deleteById(int id);

	/**
	 * 
	 * @Description:批量删除学科类型
	 * @param @param idList
	 * @param @return
	 * @return int
	 */
	int batchDelete(@Param("list") List<Integer> idList);
	
	/**
	 * 
	 * @Description:根据pid删除课程类型
	 * @param @param pid 课程类型上级类型
	 * @param @return
	 * @return int
	 */
	int deleteByPid(@Param("pid") int pid);

	/**
	 * 
	 * @Description:添加学科类型
	 * @param @param subjectType
	 * @param @return
	 * @return int
	 */
	int saveSubjectType(@Param("subjectType") SubjectType subjectType);

}

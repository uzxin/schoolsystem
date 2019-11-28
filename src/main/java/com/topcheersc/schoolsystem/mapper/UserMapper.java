package com.topcheersc.schoolsystem.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.topcheersc.schoolsystem.pojo.ClassPO;
import com.topcheersc.schoolsystem.pojo.User;
import com.topcheersc.schoolsystem.vo.UserVO;
/**
 * 
* @author YX
* @date 2019年11月19日下午4:17:31
* @Description:学生表的mapper接口
 */
@Mapper
public interface UserMapper {
	
	/**
	 * 
	 * @Description:获取所有学生数据
	 * @param limit 
	 * @param page 
	 * @param @return
	 * @return List<User>
	 */
	List<User> listUser(@Param("page") int page, @Param("limit") int limit);

	/**
	 * 
	 * @Description:根据id删除学生信息
	 * @param @param id
	 * @param @return
	 * @return int
	 */
	int deleteById(int id);

	/**
	 * 
	 * @Description:修改学生信息
	 * @param @param user
	 * @param @return
	 * @return int
	 */
	int update(@Param("user") User user);

	/**
	 * 
	 * @Description:查询学生表总条数
	 * @param @return
	 * @return int
	 */
	int countUser();

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
	 * @Description:添加学生
	 * @param @param userVO
	 * @param @return
	 * @return int
	 */
	int saveUser(@Param("user") UserVO userVO);

	/**
	 * 
	 * @Description:添加学生班级关系
	 * @param @param userVO
	 * @param @return
	 * @return int
	 */
	int saveClassStudent(@Param("user") UserVO userVO);
	
	/**
	 * 
	 * @param limit 
	 * @param page 
	 * @Description:学生列表模糊查询
	 * @param @param id 学生ID
	 * @param @param name 学生姓名
	 * @param @param gender 学生性别
	 * @param @param page 当前页数
	 * @param @param limit 每页显示的条数
	 * @param @return
	 * @return List<User>
	 */
	List<User> queryByCondition(@Param("id") Integer id, @Param("name")String name
			, @Param("gender")String gender, @Param("page") int page
			, @Param("limit") int limit);

	/**
	 * 
	 * @Description:根据学生ID查找班级
	 * @param @param ID
	 * @param @return
	 * @return ClassPO
	 */
	ClassPO getClassByUserId(Integer ID);

	/**
	 * 
	 * @Description:查找同班同学
	 * @param @param classID 班级ID
	 * @param @return
	 * @return List<User>
	 */
	List<User> listClassMates(int classID);
	
	/**
	 * 
	 * @Description 通过用户名获取用户信息
	 * @param @param username 用户名
	 * @param @return
	 * @return User
	 */
	User getUserByUserName(@Param("username") String username);

}

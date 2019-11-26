package com.topcheersc.schoolsystem.service;

import java.util.List;

import com.topcheersc.schoolsystem.pojo.ClassPO;
import com.topcheersc.schoolsystem.pojo.User;
import com.topcheersc.schoolsystem.vo.UserVO;
/**
 * 
* @author YX
* @date 2019年11月20日上午8:44:47
* @Description:学生表操作接口
 */
public interface UserService {

	/**
	 * 
	 * @Description:返回学生数据
	 * @param limit 
	 * @param page 
	 * @param @return
	 * @return List<User>
	 */
	List<User> listUser(int page, int limit);

	/**
	 * 
	 * @Description:根据id删除学生信息
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
	 * @Description:修改学生信息
	 * @param @param user
	 * @param @return
	 * @return boolean
	 */
	boolean update(User user);

	/**
	 * 
	 * @Description:获取学生表的总条数
	 * @param @return
	 * @return int
	 */
	int countUser();

	/**
	 * 
	 * @Description:添加学生
	 * @param @param userVO
	 * @param @return
	 * @return boolean
	 */
	boolean saveUser(UserVO userVO);

	/**
	 * 
	 * @Description:学生列表模糊查询
	 * @param @param id 学生ID
	 * @param @param name 学生姓名
	 * @param @param gender 学生性别
	 * @param @param page 当前页数
	 * @param @param limit 每页显示的条数
	 * @param @return
	 * @return List<User>
	 */
	List<User> queryByCondition(Integer id, String name, String gender, int page, int limit);
	
	/**
	 * 
	 * @Description:通过学生ID查找班级
	 * @param @param userId
	 * @param @return
	 * @return ClassPO
	 */
	ClassPO getClassByUserId(Integer userId);

	/**
	 * @Description:查找同班同学
	 * @param @param classID 班级ID
	 * @param @return
	 * @return List<User>
	 */
	List<User> listClassMates(int classID);
}

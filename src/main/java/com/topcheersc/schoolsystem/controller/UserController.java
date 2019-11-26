package com.topcheersc.schoolsystem.controller;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.topcheersc.schoolsystem.pojo.ClassPO;
import com.topcheersc.schoolsystem.pojo.CodeMsg;
import com.topcheersc.schoolsystem.pojo.Result;
import com.topcheersc.schoolsystem.pojo.User;
import com.topcheersc.schoolsystem.service.UserService;
import com.topcheersc.schoolsystem.vo.UserVO;
/**
 * 
* @author YX
* @date 2019年11月19日下午4:09:15
* @Description:对学生表的增删改查
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @Description:返回学生信息
	 * @param @param page 当前页
	 * @param @param limit 每页显示的条数
	 * @param @param id 学生ID
	 * @param @param name 学生姓名
	 * @param @param gender 学生性别
	 * @param @return
	 * @return Result<List<User>>
	 */
	@RequestMapping("/listUser")
	public Result<List<UserVO>> listUser(int page, int limit, String id, String name, String gender){
		List<User> userList = new ArrayList<User>();
		List<UserVO> userVOList = new ArrayList<UserVO>();
		
		if ((id == null) && (name == null) && (gender == null)) {
			//分页查询
			userList = userService.listUser(page, limit);
		} else {
			//模糊查询(参数校验需优化，暂时先就这样)
			Integer id_Integer = null;
			if ((!("").equals(id)) && (null != id) ) {
				id_Integer = Integer.valueOf(id);
			}
			userList = userService.queryByCondition(id_Integer, name, gender, page, limit);
		}
		for (User user : userList) {
			//根据学生ID查询班级信息
			ClassPO classPO = userService.getClassByUserId(user.getID());
			//如果没有查询到学生所在班级
			if (classPO == null) {
				classPO = new ClassPO();
			}
			//将班级信息注入学生VO对象
			userVOList.add(new UserVO(user.getID(), user.getNAME(), user.getGENDER(), user.getAGE(), 
									user.getBIRTHDAY(), classPO.getID(), classPO.getNAME()));
		}
		return Result.success(userVOList,userService.countUser());
	}
	
	
	/**
	 * 
	 * @Description:根据id删除学生信息
	 * @param @param id
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/delete")
	public Result<Object> deleteById(String id) {
		boolean b = userService.deleteById(Integer.parseInt(id));
		if (b == true) {
			logger.info("成功删除ID为"+id+"的学生");
			return Result.success(null);
		}
		logger.info("删除ID为"+id+"的学生失败");
		return Result.error(CodeMsg.DELETE_ERROR);
	}
	
	/**
	 * 
	 * @Description:批量删除
	 * @param @param data
	 * @param @return
	 * @return String
	 */
	@RequestMapping("/batchDelete")
	public Result<Object> batchDelete(String data) {
		//本段代码后续需优化
		List<Integer> idList = new ArrayList<Integer>();
		//字符串转json数组
		JSONArray jsonArray = JSONArray.parseArray(data);
		for (int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			idList.add((Integer) jsonObject.get("id"));
		}
		if (userService.batchDelete(idList) == true) {
			logger.info("批量删除"+idList.size()+"个学生");
			return Result.success(null);
		}
		logger.info("批量删除失败");
		return Result.error(CodeMsg.DELETE_ERROR);
	}
	
	/**
	 * 
	 * @Description:修改学生信息
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/editUser")
	public Result<Object> editUser(String id, String name, String gender, String age, String birthday) {
		User user = new User();
		user.setID(Integer.parseInt(id));
		user.setNAME(name);
		user.setGENDER(gender);
		user.setAGE(age);
		user.setBIRTHDAY(birthday);
		boolean b = userService.update(user);
		if (b == true) {
			logger.info("成功修改ID为"+id+"学生的资料");
			return Result.success(null);
		}
		logger.info("修改ID为"+id+"学生的资料失败");
		return Result.error(CodeMsg.UPDATE_ERROR);
	}
	
	/**
	 * 
	 * @Description:添加学生
	 * @param @param data
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/addUser")
	public Result<Object> addUser(String data) {
		UserVO userVO = JSON.parseObject(data, UserVO.class);
		boolean b = userService.saveUser(userVO);
		if (b == true) {
			logger.info("添加学生成功");
			return Result.success(null);
		}
		logger.info("添加学生失败");
		return Result.error(CodeMsg.SAVE_ERROR);
	}
	
	/**
	 * 
	 * @Description:查找同班同学
	 * @param @param CLASS_ID 班级ID
	 * @param @return
	 * @return Result<List<User>>
	 */
	@RequestMapping("/listClassMates")
	public Result<List<User>> listClassMates(String CLASS_ID) {
		List<User> classMateList = userService.listClassMates(Integer.parseInt(CLASS_ID));
		return Result.success(classMateList);
	}
}

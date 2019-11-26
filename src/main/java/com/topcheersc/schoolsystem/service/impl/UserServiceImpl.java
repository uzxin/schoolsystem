package com.topcheersc.schoolsystem.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topcheersc.schoolsystem.mapper.UserMapper;
import com.topcheersc.schoolsystem.pojo.ClassPO;
import com.topcheersc.schoolsystem.pojo.User;
import com.topcheersc.schoolsystem.service.UserService;
import com.topcheersc.schoolsystem.vo.UserVO;
/**
 * 
* @author YX
* @date 2019年11月20日上午8:45:32
* @Description:学生表操作接口的实现类
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> listUser(int page, int limit) {
		return userMapper.listUser(page, limit);
	}

	@Override
	public boolean deleteById(int id) {
		if (userMapper.deleteById(id) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		if (userMapper.update(user) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public int countUser() {
		return userMapper.countUser();
	}

	@Override
	public boolean batchDelete(List<Integer> idList) {
		if (userMapper.batchDelete(idList) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveUser(UserVO userVO) {
		// 为用户随机生成一个0-1000的ID
		userVO.setID(new Random().nextInt(1000));
		int result = userMapper.saveUser(userVO);
		while(result != 1) {
			//插入失败（可能是主键重复）
			userVO.setID(new Random().nextInt(1000));
			result = userMapper.saveUser(userVO);
		}
		//userMapper.saveClassStudent(userVO);
		return true;
	}

	@Override
	public List<User> queryByCondition(Integer id, String name, String gender, int page, int limit) {
		return userMapper.queryByCondition(id, name, gender, page, limit);
	}

	@Override
	public ClassPO getClassByUserId(Integer userId) {
		return userMapper.getClassByUserId(userId);
	}

	@Override
	public List<User> listClassMates(int classID) {
		return userMapper.listClassMates(classID);
	}

}

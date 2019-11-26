package com.topcheersc.schoolsystem.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topcheersc.schoolsystem.mapper.TeacherMapper;
import com.topcheersc.schoolsystem.pojo.Teacher;
import com.topcheersc.schoolsystem.service.TeacherService;;

/**
* @author YX
* @date 2019年11月22日上午8:52:15
* @Description:教师表操作接口的实现类
*/
@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherMapper teacherMapper;
	
	@Override
	public List<Teacher> listTeacher(int page, int limit) {
		return teacherMapper.listTeacher(page, limit);
	}

	@Override
	public boolean deleteById(int id) {
		if (teacherMapper.deleteById(id) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Teacher teacher) {
		if (teacherMapper.update(teacher) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public int countTeacher() {
		return teacherMapper.countTeacher();
	}

	@Override
	public boolean batchDelete(List<Integer> idList) {
		if (teacherMapper.batchDelete(idList) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveTeacher(Teacher teacher) {
		// 为用户随机生成一个0-1000的ID
		teacher.setID(new Random().nextInt(1000));
		int result = teacherMapper.saveTeacher(teacher);
		while(result != 1) {
			//插入失败（可能是主键重复）
			teacher.setID(new Random().nextInt(1000));
			result = teacherMapper.saveTeacher(teacher);
		}
		return true;
	}

	@Override
	public List<Teacher> queryByCondition(Integer id, String name, String gender, int page, int limit) {
		return teacherMapper.queryByCondition(id, name, gender, page, limit);
	}

}

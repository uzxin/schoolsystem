package com.topcheersc.schoolsystem.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topcheersc.schoolsystem.mapper.SubjectMapper;
import com.topcheersc.schoolsystem.pojo.Subject;
import com.topcheersc.schoolsystem.service.SubjectService;

/**
* @author YX
* @date 2019年11月22日上午10:03:56
* @Description:课程表操作接口的实现类
*/
@Service("SubjectService")
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;
	
	@Override
	public List<Subject> listSubject(int page, int limit) {
		return subjectMapper.listSubject(page, limit);
	}

	@Override
	public int countSubject() {
		return subjectMapper.countSubject();
	}

	@Override
	public List<Subject> queryByCondition(Integer id, String name, String type_id, int page, int limit) {
		return subjectMapper.queryByCondition(id, name, type_id, page, limit);
	}

	@Override
	public boolean deleteById(int id) {
		if (subjectMapper.deleteById(id) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean batchDelete(List<Integer> idList) {
		if (subjectMapper.batchDelete(idList) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Subject subject) {
		if (subjectMapper.update(subject) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveSubject(Subject subject) {
		// 为课程随机生成一个0-1000的ID
		subject.setID(new Random().nextInt(1000));
		int result = subjectMapper.saveSubject(subject);
		while(result != 1) {
			//插入失败（可能是主键重复）
			subject.setID(new Random().nextInt(1000));
			result = subjectMapper.saveSubject(subject);
		}
		return true;
	}

}

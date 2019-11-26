package com.topcheersc.schoolsystem.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topcheersc.schoolsystem.mapper.SubjectTypeMapper;
import com.topcheersc.schoolsystem.pojo.SubjectType;
import com.topcheersc.schoolsystem.service.SubjectTypeService;

/**
* @author YX
* @date 2019年11月22日上午11:10:04
* @Description:课程类型表操作接口的实现类
*/
@Service("SubjectTypeService")
public class SubjectTypeServiceImpl implements SubjectTypeService {

	@Autowired
	private SubjectTypeMapper subjectTypeMapper;
	
	@Override
	public String getTypeNameById(Integer type_ID) {
		return subjectTypeMapper.getTypeNameById(type_ID);
	}

	@Override
	public List<SubjectType> listSubjectType() {
		return subjectTypeMapper.listSubjectType();
	}

	@Override
	public void update(SubjectType subjectType) {
		subjectTypeMapper.update(subjectType);
	}

	@Override
	public int countSubjectType() {
		return subjectTypeMapper.countSubjectType();
	}

	@Override
	public boolean deleteById(int id) {
		if (subjectTypeMapper.deleteById(id) == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean batchDelete(List<Integer> idList) {
		if (subjectTypeMapper.batchDelete(idList) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveSubjectType(SubjectType subjectType) {
		// 为学科类型随机生成一个0-1000的ID
		subjectType.setID(new Random().nextInt(1000));
		int result = subjectTypeMapper.saveSubjectType(subjectType);
		while(result != 1) {
			//插入失败（可能是主键重复）
			subjectType.setID(new Random().nextInt(1000));
			result = subjectTypeMapper.saveSubjectType(subjectType);
		}
		return true;
	}

}

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
import com.topcheersc.schoolsystem.pojo.CodeMsg;
import com.topcheersc.schoolsystem.pojo.Result;
import com.topcheersc.schoolsystem.pojo.SubjectType;
import com.topcheersc.schoolsystem.service.SubjectTypeService;
import com.topcheersc.schoolsystem.vo.SubjectTypeVO;


/**
* @author YX
* @date 2019年11月25日下午2:39:06
* @Description:学科类型操作
*/
@RestController
@RequestMapping("/subjectType")
public class SubjectTypeController {

	protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private SubjectTypeService subjectTypeService;
	
	/**
	 * 
	 * @Description:返回学科类型集合
	 * @param @return
	 * @return List<SubjectVO>
	 */
	@RequestMapping("/listSubjectType")
	public Result<List<SubjectTypeVO>> listSubjectType() {
		List<SubjectType> list = subjectTypeService.listSubjectType();
		List<SubjectTypeVO> voList = new ArrayList<SubjectTypeVO>();
		for (SubjectType s : list) {
			if (s.getP_ID() != null) {
				voList.add(new SubjectTypeVO(s.getID(), s.getNAME(), 
						Integer.parseInt(s.getP_ID()), subjectTypeService.getTypeNameById(Integer.parseInt(s.getP_ID()))));
			}else {
				voList.add(new SubjectTypeVO(s.getID(), s.getNAME(), 
						null, null));
			}
		}
		return Result.success(voList,subjectTypeService.countSubjectType());
	}
	
	/**
	 * 
	 * @Description:修改学科类型信息
	 * @param @param id 学科类型ID
	 * @param @param name 学科类型名字
	 * @param @param p_ID 学科类型上级类型
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/editSubjectType")
	public Result<Object> editSubjectType(String id, String name, String p_ID) {
		SubjectType s = new SubjectType();
		s.setID(Integer.parseInt(id));
		s.setNAME(name);
		if (("0").equals(p_ID)) {
			s.setP_ID(null);
		}else {
			s.setP_ID(p_ID);
		}
		subjectTypeService.update(s);
		logger.info("修改ID为"+id+"的学科类型信息成功");
		return Result.success(null);
	}
	
	/**
	 * 
	 * @Description:根据id删除课程信息
	 * @param @param id 课程ID
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/delete")
	public Result<Object> deleteById(String id) {
		boolean b = subjectTypeService.deleteById(Integer.parseInt(id));
		if (b == true) {
			logger.info("成功删除ID为"+id+"的学科类型信息");
			return Result.success(null);
		}
		logger.info("删除ID为"+id+"的学科类型失败");
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
		if (subjectTypeService.batchDelete(idList) == true) {
			logger.info("批量删除"+idList.size()+"个课程类型");
			return Result.success(null);
		}
		logger.info("批量删除失败");
		return Result.error(CodeMsg.DELETE_ERROR);
	}
	
	/**
	 * 
	 * @Description:添加学科类型
	 * @param @param data
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/addSubjectType")
	public Result<Object> addSubjectType(String data) {
		SubjectType subjectType = JSON.parseObject(data, SubjectType.class);
		boolean b = subjectTypeService.saveSubjectType(subjectType);
		if (b == true) {
			logger.info("添加学科类型成功");
			return Result.success(null);
		}
		logger.info("添加学科类型失败");
		return Result.error(CodeMsg.SAVE_ERROR);
	}
}

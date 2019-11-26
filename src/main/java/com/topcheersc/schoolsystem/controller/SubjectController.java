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
import com.topcheersc.schoolsystem.pojo.Subject;
import com.topcheersc.schoolsystem.pojo.SubjectType;
import com.topcheersc.schoolsystem.service.SubjectService;
import com.topcheersc.schoolsystem.service.SubjectTypeService;
import com.topcheersc.schoolsystem.vo.SubjectVO;

/**
* @author YX
* @date 2019年11月22日上午10:02:53
* @Description:课程表的增删改查
*/
@RestController
@RequestMapping("/subject")
public class SubjectController {

	protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SubjectTypeService subjectTypeService;
	
	/**
	 * 
	 * @Description:返回课程信息
	 * @param @param page 当前页数
	 * @param @param limit 每页显示的条数
	 * @param @param id 课程ID
	 * @param @param name 课程名字
	 * @param @param type_id 课程类型
	 * @param @return
	 * @return Result<List<Subject>>
	 */
	@RequestMapping("/listSubject")
	public Result<List<SubjectVO>> listSubject(int page, int limit, String id, String name, String type_id){
		List<SubjectVO> subjectVOList = new ArrayList<SubjectVO>();
		List<Subject> subjectList = new ArrayList<Subject>();
		if ((id == null) && (name == null) && (type_id == null)) {
			//分页查询
			subjectList = subjectService.listSubject(page, limit);
		} else {
			//模糊查询(参数校验需优化，暂时先就这样)
			Integer id_Integer = null;
			if ((!("").equals(id)) && (null != id) ) {
				id_Integer = Integer.valueOf(id);
			}
			subjectList = subjectService.queryByCondition(id_Integer, name, type_id, page, limit);
		}
		for (Subject subject : subjectList) {
			//根据课程类型ID查询课程类型名字
			String typeName = subjectTypeService.getTypeNameById(subject.getTYPE_ID());
			//将课程类型名字注入到课程的VO对象中
			subjectVOList.add(new SubjectVO(subject.getID(), subject.getNAME(), subject.getTYPE_ID(), typeName));
		}
		return Result.success(subjectVOList,subjectService.countSubject());
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
		boolean b = subjectService.deleteById(Integer.parseInt(id));
		if (b == true) {
			logger.info("成功删除ID为"+id+"的课程信息");
			return Result.success(null);
		}
		logger.info("删除ID为"+id+"的课程失败");
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
		if (subjectService.batchDelete(idList) == true) {
			logger.info("批量删除"+idList.size()+"个课程");
			return Result.success(null);
		}
		logger.info("批量删除失败");
		return Result.error(CodeMsg.DELETE_ERROR);
	}
	
	/**
	 * 
	 * @Description:修改课程信息
	 * @param @param id 课程ID
	 * @param @param name 课程名字
	 * @param @param type_id 课程类型
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/editSubject")
	public Result<Object> editSubject(String id, String name, String type_id) {
		Subject subject = new Subject();
		subject.setID(Integer.parseInt(id));
		subject.setNAME(name);
		subject.setTYPE_ID(Integer.parseInt(type_id));
		boolean b = subjectService.update(subject);
		if (b == true) {
			logger.info("成功修改ID为"+id+"的课程信息");
			return Result.success(null);
		}
		logger.info("修改ID为"+id+"的课程信息失败");
		return Result.error(CodeMsg.UPDATE_ERROR);
	}
	
	/**
	 * 
	 * @Description:添加课程
	 * @param @param data
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/addSubject")
	public Result<Object> addSubject(String data) {
		Subject subject = JSON.parseObject(data, Subject.class);
		boolean b = subjectService.saveSubject(subject);
		if (b == true) {
			logger.info("添加课程成功");
			return Result.success(null);
		}
		logger.info("添加课程失败");
		return Result.error(CodeMsg.SAVE_ERROR);
	}
	
	@RequestMapping("/listSubjectType")
	public JSONObject listSubjectType() {
		List<SubjectType> list = subjectTypeService.listSubjectType();
		JSONObject ServerJson = new JSONObject();
		for (SubjectType s : list) {
			ServerJson.put((s.getID()).toString(), s.getNAME());
		}
		return ServerJson;
	}
}

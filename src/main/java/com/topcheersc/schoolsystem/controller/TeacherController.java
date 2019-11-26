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
import com.topcheersc.schoolsystem.pojo.Teacher;
import com.topcheersc.schoolsystem.service.TeacherService;

/**
* @author YX
* @date 2019年11月22日上午8:47:11
* @Description:对教师表的增删改查
*/
@RestController
@RequestMapping("/teacher")
public class TeacherController {

	protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private TeacherService teacherService;
	
	/**
	 * 
	 * @Description:返回教师信息
	 * @param @param page 当前页
	 * @param @param limit 每页显示的条数
	 * @param @param id 教师ID
	 * @param @param name 教师姓名
	 * @param @param gender 教师性别
	 * @param @return
	 * @return Result<List<Teacher>>f
	 */
	@RequestMapping("/listTeacher")
	public Result<List<Teacher>> listTeacher(int page, int limit, String id, String name, String gender){
		List<Teacher> TeacherList = new ArrayList<Teacher>();
		if ((id == null) && (name == null) && (gender == null)) {
			TeacherList = teacherService.listTeacher(page, limit);
			return Result.success(TeacherList,teacherService.countTeacher());
		}
		//模糊查询(参数校验需优化，暂时先就这样)
		Integer id_Integer = null;
		if ((!("").equals(id)) && (null != id) ) {
			id_Integer = Integer.valueOf(id);
		}
		TeacherList = teacherService.queryByCondition(id_Integer, name, gender, page, limit);
		return Result.success(TeacherList,teacherService.countTeacher());
	}
	
	
	/**
	 * 
	 * @Description:根据id删除教师信息
	 * @param @param id
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/delete")
	public Result<Object> deleteById(String id) {
		boolean b = teacherService.deleteById(Integer.parseInt(id));
		if (b == true) {
			logger.info("成功删除ID为"+id+"的教师");
			return Result.success(null);
		}
		logger.info("删除ID为"+id+"的教师失败");
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
		if (teacherService.batchDelete(idList) == true) {
			logger.info("批量删除"+idList.size()+"个教师");
			return Result.success(null);
		}
		logger.info("批量删除失败");
		return Result.error(CodeMsg.DELETE_ERROR);
	}
	
	/**
	 * 
	 * @Description:修改教师信息
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/editTeacher")
	public Result<Object> editTeacher(String id, String name, String gender, String age, String birthday) {
		Teacher Teacher = new Teacher();
		Teacher.setID(Integer.parseInt(id));
		Teacher.setNAME(name);
		Teacher.setGENDER(gender);
		Teacher.setAGE(age);
		Teacher.setBIRTHDAY(birthday);
		boolean b = teacherService.update(Teacher);
		if (b == true) {
			logger.info("成功修改ID为"+id+"教师的资料");
			return Result.success(null);
		}
		logger.info("修改ID为"+id+"教师的资料失败");
		return Result.error(CodeMsg.UPDATE_ERROR);
	}
	
	/**
	 * 
	 * @Description:添加教师
	 * @param @param data
	 * @param @return
	 * @return Result<Object>
	 */
	@RequestMapping("/addTeacher")
	public Result<Object> addTeacher(String data) {
		Teacher Teacher = JSON.parseObject(data, Teacher.class);
		boolean b = teacherService.saveTeacher(Teacher);
		if (b == true) {
			logger.info("添加教师成功");
			return Result.success(null);
		}
		logger.info("添加学生失败");
		return Result.error(CodeMsg.SAVE_ERROR);
	}
	
}
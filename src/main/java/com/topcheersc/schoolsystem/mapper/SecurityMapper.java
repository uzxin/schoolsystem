package com.topcheersc.schoolsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.topcheersc.schoolsystem.pojo.SecurityUser;

/**
* @author YX
* @date 2019年11月27日上午11:05:00
* @Description:
*/
@Mapper
public interface SecurityMapper {

	SecurityUser getUserByUserName(@Param("username") String username);
}

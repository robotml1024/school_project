package com.zhengyuan.liunao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zhengyuan.liunao.entity.Stu;

@Mapper
public interface StuMapper {
	List<Stu> findStu(String stuno, String psw);

	int addStu(Map map);

	List<Stu> findAllStu(Map<String, Object> map);

	List<Stu> findAll();

	List<Stu> findStuByName(String name, int start, int pagesize);

	int stuCount();

	int deleteStu(String stuno);

	List<Stu> getStuByNum(String stuno);

	int updateStu(Map map);
}

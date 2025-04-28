package com.zhengyuan.liunao.service;

import java.util.List;
import java.util.Map;

import com.zhengyuan.liunao.entity.Stu;

public interface StuService {
	List<Stu> findStu(String stuno, String psw);

	int addStu(Map map);

	List<Stu> findAllStu(Map<String, Object> map);

	List<Stu> findAll();

	List<Stu> findStuByName(String name, int start, int pagesize);

	int stuCount();

	int deleteStu(String stuNo);

	List<Stu> getStuByNum(String num);

	int updateStu(Map maps);
}

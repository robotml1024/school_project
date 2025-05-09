package com.zhengyuan.liunao.controller.dealcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.zhengyuan.liunao.entity.Stu;
import com.zhengyuan.liunao.service.StuService;

import cn.hutool.crypto.SecureUtil;

@Controller
@RequestMapping("/Sys")
public class LoginResgisterDeal {
	@Autowired
	StuService stuService;

    @ResponseBody
	@RequestMapping(value = "/dealLogin")
	public String getInfo(@RequestParam(value = "num") String num, @RequestParam(value = "psw") String psw,
			@RequestParam(value = "identify") String identify, HttpSession httpSession) {

		String dataJson = "fail";

		List<Stu> stuList = new ArrayList<>();
		stuList = stuService.findStu(num, SecureUtil.md5(psw));
		if (!stuList.isEmpty()) {
			String name = stuList.get(0).getName();
			String photo = stuList.get(0).getPhoto();
			String account = stuList.get(0).getStuno();
			httpSession.setAttribute("account", account);
			httpSession.setAttribute("name", name);
			httpSession.setAttribute("photo", photo);
			httpSession.setAttribute("role", "stu");
			dataJson = JSON.toJSONString(stuList);
			return dataJson;
		}
		return "fail";
	}
	
	@RequestMapping(value = "/registerStuDeal")
	@ResponseBody
	public String registerDeal(@RequestBody Map map) {
		System.out.println("stu psw:"+map.get("psw"));
		map.put("psw", SecureUtil.md5(map.get("psw").toString()));
		if (stuService.addStu(map) > 0) {
			return "success";
		}

		return "failure";
	}
}

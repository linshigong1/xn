package com.xn.pc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xn.pc.dao.IRecommendInfoDao;




@Controller
@RequestMapping("/login")
public class RecommendInfoController extends BaseController {
	 // 记录日志信息对象
    private Logger log = LoggerFactory.getLogger(RecommendInfoController.class);
    
    @Autowired
	private IRecommendInfoDao recommendInfoDao;
    
    
	@RequestMapping(value="/indexInfo",method=RequestMethod.GET)
	public String indexInfo(HttpServletRequest request, HttpServletResponse response){
	    System.out.print("sssssssssssssssssssssss");
	    recommendInfoDao.find();
		return "pc/index";
	}
	

}

package com.xn.pc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xn.pc.dao.BaseDao;
import com.xn.pc.entity.RecommendInfo;

@Service
public class RecommendInfoService {
	 @Autowired
	private BaseDao baseDao;
	 
	 public void save(RecommendInfo recommendInfo){
		 baseDao.insertLoginLog(recommendInfo);
	 }
}

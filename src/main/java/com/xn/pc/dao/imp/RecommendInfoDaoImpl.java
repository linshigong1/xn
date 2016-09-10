package com.xn.pc.dao.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xn.pc.dao.IRecommendInfoDao;

@Service
@Transactional
public class RecommendInfoDaoImpl implements IRecommendInfoDao {
	
	 @Autowired 
	 private JdbcTemplate jdbcTemplate;
		
	 public List find(){
		String sql="select * from recommend_info";
	    return jdbcTemplate.queryForList(sql);
	  }
}
   
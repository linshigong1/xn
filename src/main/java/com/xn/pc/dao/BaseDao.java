package com.xn.pc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xn.pc.entity.RecommendInfo;

@Repository 
public class BaseDao {  
    @Autowired
    private JdbcTemplate jdbcTemplate;  
      
    public void insertLoginLog(RecommendInfo recommendInfo) {  
        String sqlStr = "INSERT INTO  recommend_info (  RI_ID,  RII_ID,  RI_CATEGORY,  RI_CATEGORY_NAME,  RI_LOCATION,  RI_ON_CATEGORY,  RI_PERSONAL_OR_UNIT,"+
        		 " RI_NAME, RI_PHONE,  RI_UNIT_LOCATION,  CREATE_TIME, UPDATE_TIME,  DELETE_FLAG  ) " +
                 " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";  
        Object[] args = { 1,1,1,1,1,1,1,1,1,1,null,null,1};  
        jdbcTemplate.update(sqlStr, args);  
    }  
} 

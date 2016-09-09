package com.xn.service.imp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.xn.entity.LogServer;
import com.xn.service.ILogService;
import com.xn.util.logserverUtil;



/**
 * @ClassName: LogServiceImpl
 * @Description: 日志服务基础service接口实现类用
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author wyx
 * @date 2016-8-4 下午1:30:51
 */
@Service
public class LogServiceImpl implements ILogService {
    
	 // 记录日志信息对象
    private Logger log = LoggerFactory.getLogger(LogServiceImpl.class);
	
	@Autowired    
    protected MongoTemplate mongoTemplate;
	
	// 保存日志
	public void logSave(LogServer logServer,String collectionName){
		mongoTemplate.insert(logServer, collectionName);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: findByQuery</p>
	 * <p>mongodb查询 </p>
	 * @param query
	 * @param pageSize
	 * @param pageNo
	 * @param sysCode
	 * @return
	 * @see com.chinasofti.logserver.service.ILogService#findByQuery(org.springframework.data.mongodb.core.query.Query, java.lang.Integer, java.lang.Integer, java.lang.String)
	 */
	public List<LogServer> findByQuery(Query query,Integer pageSize,
			Integer pageNo,String sysCode){
		
		if (query != null) {
			int skip = 0;
			if (pageNo != null && pageNo >=0) {
				if (pageSize != null && pageSize > 0) {
					query.limit(pageSize);
					skip = (pageNo-1)*pageSize;
					query.skip(skip);
				}
			}
			return mongoTemplate.find(query, LogServer.class,"tb_log_"+sysCode);
		}
		return null;
	}
	
	public String countTotal(Query query,LogServer logServer,String sysCode){
		return String.valueOf(mongoTemplate.count(query, logServer.getClass(),"tb_log_"+sysCode));
	}
	

	/* (非 Javadoc)
	 * <p>Title: removeLog</p>
	 * <p>Description: </p>
	 * @see com.chinasofti.logserver.service.ILogService#removeLog()
	 */
	public void removeLog() {
		Date rmvLogDate= logserverUtil.getRmvLogDate();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		log.info(">>>>>>>获得mongodh中CollectionNames开始>>>>>");
		Set<String> collecNames = mongoTemplate.getCollectionNames();
		log.info(">>>>>>>获得mongodh中CollectionNames结束>结果为："+collecNames+">>>>>");
		Iterator<String> it = collecNames.iterator();  
		while (it.hasNext()) {
			String collenName  = it.next();
			if(collenName.startsWith("tb_log_")){
				Query query = new Query(Criteria.where("logTime").lt(rmvLogDate));
			    log.info(">>>>>>>查询"+df.format(rmvLogDate)+"天前日志开始>>>>>");
				List<LogServer> list =  (List<LogServer>) mongoTemplate.find(query,LogServer.class,collenName);
				log.info(">>>>>>>查询"+df.format(rmvLogDate)+"天前日志结束>>>>>");
				for(int j = 0;j<list.size();j++){
					String id = list.get(j).getId();
					Query rmvQuery = new Query(Criteria.where("_id").is(id)); 
					mongoTemplate.remove(rmvQuery,LogServer.class,collenName);
				}
			}
		}  
	}
}

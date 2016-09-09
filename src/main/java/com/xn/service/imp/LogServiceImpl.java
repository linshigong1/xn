package com.xn.service.imp;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xn.entity.LogServer;
import com.xn.service.ILogService;



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
  //  protected MongoTemplate mongoTemplate;
	
	// 保存日志
	public void logSave(LogServer logServer,String collectionName){
	}
	

	/* (非 Javadoc)
	 * <p>Title: removeLog</p>
	 * <p>Description: </p>
	 * @see com.chinasofti.logserver.service.ILogService#removeLog()
	 */
	public void removeLog() {
	}

	@Override
	public List<LogServer> findByQuery(Integer pageSize, Integer pageNo,
			String sysCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String countTotal(LogServer logServer, String sysCode) {
		// TODO Auto-generated method stub
		return null;
	}
}

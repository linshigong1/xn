package com.xn.service;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.xn.entity.LogServer;



/**
 * @ClassName: ILogService
 * @Description: 日志服务基础service
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author wyx
 * @date 2016-8-4 下午1:30:41
 */
public interface ILogService {
	
	/**
	 * @Title: logSave
	 * @Description: 保存日志
	 * @param logServer
	 * @param collectionName
	 * @author wyx
	 * @date 2016-8-17 上午10:23:13
	 * @update 2016-8-17 上午10:23:13 wyx
	 */
	public void logSave(LogServer logServer,String collectionName);
	
	//查询方法
	public List<LogServer> findByQuery(Query query,Integer pageSize,
			Integer pageNo,String sysCode);
	// 查询总数
	public String countTotal(Query query, LogServer logServer,String sysCode);
	
	
	/**
	 * @Title: removeLog
	 * @Description: 删除日志
	 * @author wyx
	 * @date 2016-8-17 上午10:22:49
	 * @update 2016-8-17 上午10:22:49 wyx
	 */
	public void removeLog();
}

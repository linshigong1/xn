package com.xn.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xn.service.ILogService;




/**
 * @ClassName: RemoveLogJob
 * @Description: 删除日志定时任务
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author wyx
 * @date 2016-8-17 上午10:15:05
 */
public class RemoveLogJob {

	 // 记录日志信息对象
    private Logger log = LoggerFactory.getLogger(RemoveLogJob.class);
    
    @Autowired
	private ILogService logService;
    
    
    /**
     * @Title: execute
     * @Description: 定时任务调用方法
     * @author wyx
     * @date 2016-8-17 上午10:22:22
     * @update 2016-8-17 上午10:22:22 wyx
     */
    public void execute(){
    	log.info(">>>>>>>>>>>>>>>>>>>删除日志开始");
    	logService.removeLog();
    	log.info(">>>>>>>>>>>>>>>>>>>删除日志结束");
    }
    
}

package com.xn.controller;



import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xn.entity.LogServer;
import com.xn.service.ILogService;
import com.xn.util.ResultMessage;




/**
 * @ClassName: CallLogController
 * @Description: 日志服务controller
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author wyx
 * @date 2016-8-4 下午2:30:55
 */
@Controller
@RequestMapping("/log")
public class LogServiceController extends BaseController {
	 // 记录日志信息对象
    private Logger log = LoggerFactory.getLogger(LogServiceController.class);
    
    
	@Autowired
	private ILogService logService;

	
	/**
	 * @Title: insertLog
	 * @Description: 保存日志
	 * @author wyx
	 * @date 2016-8-4 下午2:45:36
	 * @update 2016-8-4 下午2:45:36 wyx
	 */
	@RequestMapping(value="/logSave",method=RequestMethod.POST)
	@ResponseBody
	public String logSave(HttpServletRequest request, HttpServletResponse response){
		String logJson = request.getParameter("logJson");
		boolean success = false;
		String message = "保存成功";
		if (StringUtils.isNotBlank(logJson)) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				LogServer logServer = mapper.readValue(logJson, LogServer.class);
				String sysCode = logServer.getSysCode();
				if (StringUtils.isBlank(logServer.getId())) {
					message = new ResultMessage(ResultMessage.FAILURE, "id值为空，请赋值！").toString();
			    }else if (StringUtils.isBlank(sysCode)){
			    	message = new ResultMessage(ResultMessage.FAILURE, "sysCode值为空，请赋值！").toString();
			    }else if (StringUtils.isBlank(String.valueOf(logServer.getLogLevel()))){
			    	message = new ResultMessage(ResultMessage.FAILURE, "logLevel值为空，请赋值！").toString();
			    }else if (StringUtils.isBlank(logServer.getUserId())){
			    	message = new ResultMessage(ResultMessage.FAILURE, "userId值为空，请赋值！").toString();
			    }else if (StringUtils.isBlank(logServer.getUserName())){
			    	message = new ResultMessage(ResultMessage.FAILURE, "userName值为空，请赋值！").toString();
			    }else if (StringUtils.isBlank(logServer.getContent())){
			    	message = new ResultMessage(ResultMessage.FAILURE, "content值为空，请赋值！").toString();
			    }else if (logServer.getLogTime()==null){
			    	logServer.setLogTime(new Date());
			    }
				log.info("insert   tb_log_"+sysCode+" start>>>>>");
				// 保存日志并返回json字符串
				logService.logSave(logServer,"tb_log_"+sysCode);
				success = ResultMessage.SUCCESS;
				log.info("insert   tb_log_"+sysCode+" end>>>>>");
			} catch (JsonParseException e) {
				message = new ResultMessage(ResultMessage.FAILURE, "json字符串转换对象失败！").toString();
				log.info("json字符串转换对象失败！",e);
				e.printStackTrace();
			} catch (JsonMappingException e) {
				message = new ResultMessage(ResultMessage.FAILURE, "json字符串转换对象失败！").toString();
				e.printStackTrace();
				log.info("json字符串转换对象失败！",e);
			} catch (IOException e) {
				message= new ResultMessage(ResultMessage.FAILURE, "json字符串转换对象失败！").toString();
				e.printStackTrace();
				log.info("json字符串转换对象失败！",e);
			}
		}else{
			message = "json 字符串为空";
			log.info("json字符串为空");
		}
		return "{\"success\":"+success+",\"message\":"+message+"}";
	}
	
	/**
	 * 
	 * @Title: logSearch
	 * @Description: TODO(查询日志)
	 * @param request
	 * @param response
	 * @return
	 * @author zl
	 * @date 2016年8月24日 下午4:40:22
	 * @update 2016年8月24日 下午4:40:22 zl
	 */
	@RequestMapping(value="/logSearch",method=RequestMethod.POST)
	@ResponseBody
	public String logSearch(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		String pageNo = request.getParameter("pageNo");//当前页
		String pageSize = request.getParameter("pageSize");//页大小
		String sysCode = request.getParameter("sysCode");//系统编码
		String userName = request.getParameter("userName");//用户名
		String logType = request.getParameter("logType");//类型
		String logLevel = request.getParameter("logLevel");//等级
		String start_createTime = request.getParameter("start_createTime");//开始时间
		String end_createTime = request.getParameter("end_createTime");//结束时间
		Query query = new Query();    
	    Criteria criteria = new Criteria();
	    criteria.where("sysCode").is(sysCode);
	    if(logType!=null&&!"".equals(logType)){
	    	criteria.and("logType").is(Integer.parseInt(logType.trim()));
	    }
	    if(userName!=null&&!"".equals(userName)){
	    	criteria.and("userName").regex(userName);
	    }	
	    if(start_createTime!=null&&!"".equals(start_createTime)){
	    	criteria.and("createTime").gte(new Date(start_createTime));
	    }
	    if(end_createTime!=null&&!"".equals(end_createTime)){
	    	criteria.and("createTime").lte(new Date(end_createTime));
	    }
	    if(logLevel!=null&&!"".equals(logLevel)){
	    	criteria.and("logLevel").is(Integer.parseInt(logLevel));
	    }
	    query.addCriteria(criteria);  
	    log.info("====查询日志开始====");
	    List<LogServer> list = (List<LogServer>) logService.findByQuery(query, Integer.parseInt(pageSize.trim()), Integer.parseInt(pageNo.trim()),sysCode);
	    log.info("====查询日志结束====");
	    log.info("====查询日志总数开始====");
		String total = logService.countTotal(query,new LogServer(),sysCode);
		log.info("====查询日志总数结束====");
		map.put("total", String.valueOf(total));
		map.put("rows", list==null?"":list);
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(map);
			log.info("====转换结果json为："+json+"====");
		} catch (JsonProcessingException e) {
			log.info("====json转换异常====");
			e.printStackTrace();
		}
		return json;
	}

}

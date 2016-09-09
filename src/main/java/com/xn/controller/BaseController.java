package com.xn.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @ClassName: BaseController
 * @Description: 控制层基类：常量，异常处理映射，公共方法等
 * @Company chinasofti
 * @author Administrator
 * @date 2015年12月7日 上午9:24:21
 */
public class BaseController {
	
	protected Integer pageNo; //当前第几页
	protected Integer pageSize; //每页显示记录数
	protected Long total; //总记录数
	
	/**
	 * @Title: initParam
	 * @Description: 基础控制层初始化参数
	 * @param request HttpServletRequest对象
	 * @throws ServletRequestBindingException
	 * @author xhy
	 * @date 2015年12月7日 上午9:25:10
	 * @update 2015年12月7日 上午9:25:10 xhy
	 */
	@ModelAttribute
	public void initParam(HttpServletRequest request) throws ServletRequestBindingException{
		pageNo = ServletRequestUtils.getIntParameter(request, "page", 1);
		pageNo = (pageNo == null || pageNo == 0) ? 1 : pageNo;
		pageSize = ServletRequestUtils.getIntParameter(request, "rows",10);
		pageSize = (pageSize == null || pageSize == 0) ? 10 : pageSize;	
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
}

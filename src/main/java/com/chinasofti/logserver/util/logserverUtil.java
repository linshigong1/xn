/**   
 * @Title: WsdlParserUtils.java
 * @Package com.chinasofti.soaplatform.servicemanager.util
 * @Description: soa-console 解析wsdl工具类
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author  xhy
 * @date 2015年12月17日 下午6:10:04 
 */
package com.chinasofti.logserver.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


/**
 * @ClassName: logserverUtils
 * @Description: 日志服务工具类
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author wyx
 * @date 2016-8-17 上午10:29:48
 */
public class logserverUtil {
    // 读取配置文件
    public static Date getRmvLogDate() {
	    InputStream in = logserverUtil.class.getClassLoader().getResourceAsStream("/system-config.properties");
		 Properties property = new Properties();	
		 try {
			property.load(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String rmvLogDate = property.getProperty("rmv.log");
		Calendar c = Calendar.getInstance();  // 获得当前时间
		c.add(Calendar.DATE, - new Integer(rmvLogDate));  
		return c.getTime();
    }
    
}

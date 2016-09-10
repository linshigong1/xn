/**   
 * @Title: ResultMessage.java
 * @Package com.chinasofti.soaplatform.common
 * @Description: soa-common 返回前端页面信息封装类
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author  xhy
 * @date 2015年12月10日 下午5:15:43 
 */
package com.xn.pc.util;

/**
 * @ClassName: ResultMessage
 * @Description: 返回前端页面信息封装类
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author wyx
 * @date 2016-8-8 下午1:21:40
 */
public class ResultMessage {

	// 操作成功标志
	public static boolean SUCCESS=true;
	// 操作失败标志
	public static boolean FAILURE = false;
	
	// 是否操作成功
	public boolean success;
	// 操作提示信息
	public String message;
	
	
	/**
	 * <p>Title: ResultMessage(boolean isSuccess, String message)</p>
	 * <p>Description: 构造函数</p>
	 * @param isSuccess 是否操作成功
	 * @param message 操作信息
	 */
	public ResultMessage(boolean isSuccess, String message){
		this.success = isSuccess;
		this.message = message;
	}
	
	
	/* (非 Javadoc)
	 * <p>Title: toString</p>
	 * <p>Description: 重写toString方法</p>
	 * @return String json字符串
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"success\":"+success+",\"message\":\""+message+"\"}";
	}
	
}

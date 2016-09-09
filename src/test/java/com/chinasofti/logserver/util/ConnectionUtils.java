package com.chinasofti.logserver.util;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;


/**
 * @ClassName: ConnectionUtils
 * @Description: 获得mongodb连接
 * @Company 版权所属：中软国际 www.chinasofti.com
 * @author wyx
 * @date 2016-8-2 下午6:02:05
 */
public class ConnectionUtils {

	/**
	 * @Title: getMongoColl
	 * @Description: 获得mongodb连接 返回DBCollection对象
	 * @param 获得mongodb连接对象
	 * @return coll 
	 * @author wyx
	 * @date 2016-8-2 下午6:02:05
	 * @update 2016年1月13日 下午3:30:56 xhy
	 */
	public static DBCollection getMongoColl(){
		// 创建连接
		MongoClient mongoClient;
		DBCollection coll = null;
		try {
			mongoClient = new MongoClient(Arrays.asList(new ServerAddress("10.11.17.127", 27017)));
			//使用mydb数据库
			DB db = mongoClient.getDB("esblog");
			//获取特定Collection
			coll = db.getCollection("tb_calllog");
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coll;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBCollection coll= getMongoColl();
		///写入一个Document
		//BasicDBObject doc = new BasicDBObject("name", "MongoDB")
		//        .append("type", "database")
		//        .append("count", 1)
		//        .append("info", new BasicDBObject("x", 203).append("y", 102));
		//coll.insert(doc);
		DBObject oneUser = coll.findOne();
		//System.out.print("=============="+oneUser);
		//DBObject dbo = (DBObject) JSON.parse(user.toJson()); 
		//coll.insert(dbo);
		//System.out.print("=============="+doc);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Calendar c = Calendar.getInstance();  // 获得当前时间
		c.add(Calendar.DATE, - 11);  
		String logJson = "{\"id\":\""+UUID.randomUUID()+"\"," +
				"\"sysCode\":\"test2\"," +
				"\"sysName\":\"beijingserver1\"," + 
                "\"logLevel\":\"1\",\"logType\":\"1\"," +
                "\"userId\":\"1111111\"," +
                "\"userName\":\"test1\"," +
                "\"content\":\"1测试测试测试1\"," +
                "\"logTime\":\""+df.format(c.getTime())+"\"}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<?, ?> map = mapper.readValue(logJson, Map.class);
			String sysCode = map.get("sysCode").toString();
			//mongoTemplate.insert(map, sysCode);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//DBObject b = new BasicDBObject("_id", "1111111111111111");
		//mongoTemplate.insert(b, "tb_calllog5");
		System.out.print("====");
	}

}

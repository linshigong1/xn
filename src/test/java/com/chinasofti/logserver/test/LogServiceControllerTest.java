package com.chinasofti.logserver.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(value=SpringJUnit4ClassRunner.class)



@ContextHierarchy({
	@ContextConfiguration(locations={"classpath:application.xml"}),
	@ContextConfiguration(locations={"classpath:application-web.xml"})
})
public class LogServiceControllerTest {

	@Autowired
	ApplicationContext ctx;

	@Autowired
	MockHttpServletRequest request;
	@Autowired 
	MockHttpSession session;
	@Autowired 
	MockHttpServletResponse response;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogSave() {
		//LogServiceController lsc =(LogServiceController) ctx.getBean("logServiceController");

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
		session.setAttribute("logJson", logJson);
		//lsc.logSave(request,response);
		fail("Not yet implemented");
	}


}

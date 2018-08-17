package com.demo;

import demo.dao.BookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	//模拟mvc对象
	private MockMvc mockMvc;
	//web项目上下文
	@Autowired
	protected WebApplicationContext webApplicationContext;
	//业务数据接口
	@Autowired
	private BookRepository bookRepository;

	RequestBuilder build=null;
	@Before //所有方法执行之前执行该方法
	public void before() throws  Exception{
		//获取mvc对象实例,初始化
		mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	//测试index
	@Test
	public void testIndex() throws  Exception {
		MvcResult mvcResult = mockMvc.perform(get("/index").param("admin")).andReturn();
		int status = mvcResult.getResponse().getStatus();//MvcResult对象实例获取的MockHttpServletResponse对象从而才得到的Status状态码。
		String responseString = mvcResult.getResponse().getContentAsString();//同样也是使用MvcResult实例获取的MockHttpServletResponse对象从而得到的请求返回的字符串内容。

		Assert.assertEquals("请求错误", 200, status);//使用Junit内部验证类Assert判断返回的状态码是否正常为200
		Assert.assertEquals("返回结果不一致", "this is index pageadmin", responseString);//判断返回的字符串是否与我们预计的一样。
	}

	//测试TestController
	@Test
	public void testController() throws Exception{
		build = get("/book");
		String str = mockMvc.perform(build).toString();
		System.out.println(str);
	}


	//测试是否插入成功
	@Test
	public void testAddBook() throws Exception{
		build = post("/addBook")
				.param("id","10")
				.param("name","amao")
				.param("price","70.8");
		mockMvc.perform(build);

	}

	//测试修改一条记录
	@Test
	public void testUpdateBook() throws Exception{
		build = put("/updateBook/3")
				.param("name","amao")
				.param("price","80.6");
		mockMvc.perform(build);
	}

}

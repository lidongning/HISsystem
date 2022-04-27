package Baidu;

import org.testng.annotations.Test;

import BaseClass.GetProperty;

import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.AfterTest;

public class MyHttpClient<RestfulClient> {
	public static String result;

	@BeforeTest
	public void beforeTest() {
		// 读取execl文件的参数体
	}

	@Test(description = "get请求")
	public void atest() throws IOException {
		// 用来存放测试结果
		// 创建一个get实例，并指定请求url
		HttpGet get = new HttpGet("http://www.baidu.com");
		// 创建一个client对象，是用来执行get方法的
		CloseableHttpClient client = HttpClients.createDefault();
		// 用客户端执行get实例，并把响应结果保存在response对象中
		HttpResponse response = client.execute(get);
		// response.getEntity()用来获取整个响应的实例，即获取整个响应内容
		// EntityUtils对象是org.apache.http.util下的一个工具类，用官方的解释是为HttpEntity对象提供的静态帮助类
		// 把响应内容转成字符串，转换时使用编码为utf-8
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println("get请求返回结果是"+result);
	}

	@Test(description = "post请求——Form表单形式(数据格式)")
	public void btest() throws IOException, JSONException {
		String url = "https://api.apishop.net/communication/phone/getLocationByPhoneNum";	    
//用哈希图准备请求头部信息
		HashMap<String, String> hashHead = new HashMap<String, String>();
		hashHead.put("Content-Type", "application/x-www-form-urlencoded");
//用NameValuePair的list来添加请求主体参数
				List params = new ArrayList();
				params.add(new BasicNameValuePair("apiKey", "nMke6NK29c40b1d******b3eec8aa0808389b16c4"));
				params.add(new BasicNameValuePair("phoneNum", "1861196136"));
//传参发送post请求并接收反馈
		String str=(String) sendPost.sendPost(url,hashHead,params);
		System.out.println("post请求的返回结果是："+str);
		JSONObject jsonStr = new JSONObject(str);
		String jsonStr1 =jsonStr.getString("statusCode");  //取出json数组中的某一个属性
		System.out.println("取出json数组中的某一个属性是："+jsonStr1);
        JSONArray jsonArray = jsonStr.getJSONArray("result");
        System.out.println("post请求的返回的内容包含的数组是："+jsonArray);
        
	}

	@Test(description = "post请求——Json形式(数据格式)")
	public void ctest() throws IOException, JSONException {
		String url = "https://api.apishop.net/communication/phone/getLocationByPhoneNum";    		
//用哈希图准备请求头部信息
				HashMap<String, String> hashHead = new HashMap<String, String>();
				hashHead.put("Content-Type", "application/json");		
//添加请求主体参数
				JSONObject params = new JSONObject();
			    params.put( "wsf",GetProperty.getProperty("param01"));//参数化
			    params.put("TENANT_ID", "123");
			    params.put("NM", "张三");
			    params.put("BRTH_DT", "1983-01-20");
			    params.put("GND_CODE", "1");
			    JSONArray params2 = new JSONArray();
			    JSONObject param3 = new JSONObject();
			    param3.put("DOC_TP_CODE", "10100");
			    param3.put("DOC_NBR", "100200198301202210");
			    param3.put("DOC_CUST_NM", "test");
			    params2.put(param3);
			    params.put("DOCS", params2);
			    String json = params.toString();
			    System.out.println("json格式post请求的主体内容是:"+json);
//传参发送post请求并接收反馈
				String str=(String) sendPost.sendPost_json(url,hashHead, json);
				System.out.println("post请求的返回结果是:"+str);
			}

	@AfterTest
	public void afterTest() {

	}

}

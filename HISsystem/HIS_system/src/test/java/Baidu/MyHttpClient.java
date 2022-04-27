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
		// ��ȡexecl�ļ��Ĳ�����
	}

	@Test(description = "get����")
	public void atest() throws IOException {
		// ������Ų��Խ��
		// ����һ��getʵ������ָ������url
		HttpGet get = new HttpGet("http://www.baidu.com");
		// ����һ��client����������ִ��get������
		CloseableHttpClient client = HttpClients.createDefault();
		// �ÿͻ���ִ��getʵ����������Ӧ���������response������
		HttpResponse response = client.execute(get);
		// response.getEntity()������ȡ������Ӧ��ʵ��������ȡ������Ӧ����
		// EntityUtils������org.apache.http.util�µ�һ�������࣬�ùٷ��Ľ�����ΪHttpEntity�����ṩ�ľ�̬������
		// ����Ӧ����ת���ַ�����ת��ʱʹ�ñ���Ϊutf-8
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println("get���󷵻ؽ����"+result);
	}

	@Test(description = "post���󡪡�Form����ʽ(���ݸ�ʽ)")
	public void btest() throws IOException, JSONException {
		String url = "https://api.apishop.net/communication/phone/getLocationByPhoneNum";	    
//�ù�ϣͼ׼������ͷ����Ϣ
		HashMap<String, String> hashHead = new HashMap<String, String>();
		hashHead.put("Content-Type", "application/x-www-form-urlencoded");
//��NameValuePair��list����������������
				List params = new ArrayList();
				params.add(new BasicNameValuePair("apiKey", "nMke6NK29c40b1d******b3eec8aa0808389b16c4"));
				params.add(new BasicNameValuePair("phoneNum", "1861196136"));
//���η���post���󲢽��շ���
		String str=(String) sendPost.sendPost(url,hashHead,params);
		System.out.println("post����ķ��ؽ���ǣ�"+str);
		JSONObject jsonStr = new JSONObject(str);
		String jsonStr1 =jsonStr.getString("statusCode");  //ȡ��json�����е�ĳһ������
		System.out.println("ȡ��json�����е�ĳһ�������ǣ�"+jsonStr1);
        JSONArray jsonArray = jsonStr.getJSONArray("result");
        System.out.println("post����ķ��ص����ݰ����������ǣ�"+jsonArray);
        
	}

	@Test(description = "post���󡪡�Json��ʽ(���ݸ�ʽ)")
	public void ctest() throws IOException, JSONException {
		String url = "https://api.apishop.net/communication/phone/getLocationByPhoneNum";    		
//�ù�ϣͼ׼������ͷ����Ϣ
				HashMap<String, String> hashHead = new HashMap<String, String>();
				hashHead.put("Content-Type", "application/json");		
//��������������
				JSONObject params = new JSONObject();
			    params.put( "wsf",GetProperty.getProperty("param01"));//������
			    params.put("TENANT_ID", "123");
			    params.put("NM", "����");
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
			    System.out.println("json��ʽpost���������������:"+json);
//���η���post���󲢽��շ���
				String str=(String) sendPost.sendPost_json(url,hashHead, json);
				System.out.println("post����ķ��ؽ����:"+str);
			}

	@AfterTest
	public void afterTest() {

	}

}

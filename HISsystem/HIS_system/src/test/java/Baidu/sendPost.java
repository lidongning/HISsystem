package Baidu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.gargoylesoftware.htmlunit.javascript.host.Map;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;


//---------------------------�������ʽ��post����-----------------------------------
public class sendPost {
	    //��ȡpost����ķ���
    public static String sendPost(String url, HashMap<String, String> headers,List params) throws ClientProtocolException, IOException{
    	//����post�������    //NameValuePair ������ֵ�Խڵ����ͣ��������ദ����Java��url����Post�����ڷ���post����ʱ�ø�list����Ų���
        HttpPost post= new HttpPost(url);
        //����ͷ����Ϣ
        Set<String> set = headers.keySet();
        for(Iterator<String> iterator = set.iterator(); iterator.hasNext();){
            String key = iterator.next();
            String value = headers.get(key);
            post.addHeader(key, value);
        }
        //�������������ʽ
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpResponse  Response = (HttpResponse) client.execute(post);
        if (Response.getStatusLine().getStatusCode() == 200) {
	    	  HttpEntity entity = Response.getEntity();
		      String json = EntityUtils.toString(entity, "UTF-8");
		      return json;
	    	  }
        else {
        	  return null;
        }
    }
  //---------------------------����json��ʽ��post����-----------------------------------	
   public static String sendPost_json(String url,HashMap<String, String> headers,String strjson) throws ClientProtocolException, IOException{
	   //����post�������
	   HttpPost Post = new HttpPost(url);
	   //����ͷ����Ϣ
	   Set<String> set = headers.keySet();
       for(Iterator<String> iterator = set.iterator(); iterator.hasNext();){
           String key = iterator.next();
           String value = headers.get(key);
           Post.addHeader(key, value);
       }
       //������������json��ʽ
       StringEntity poststr=new StringEntity(strjson);
       Post.setEntity(poststr);
	   CloseableHttpClient client = HttpClients.createDefault();
	   HttpResponse  Response = (HttpResponse) client.execute(Post);
       if (Response.getStatusLine().getStatusCode() == 200) {
	    	  HttpEntity entity = Response.getEntity();
		      String json = EntityUtils.toString(entity, "UTF-8");
		      return json;
	    	  }
       else {
       	      return null;
       }
  }

}

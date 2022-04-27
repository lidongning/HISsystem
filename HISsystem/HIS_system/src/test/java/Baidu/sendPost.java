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


//---------------------------处理表单格式的post请求-----------------------------------
public class sendPost {
	    //获取post请求的反馈
    public static String sendPost(String url, HashMap<String, String> headers,List params) throws ClientProtocolException, IOException{
    	//创建post请求对象    //NameValuePair 简单名称值对节点类型：这个代码多处用于Java像url发送Post请求。在发送post请求时用该list来存放参数
        HttpPost post= new HttpPost(url);
        //设置头部信息
        Set<String> set = headers.keySet();
        for(Iterator<String> iterator = set.iterator(); iterator.hasNext();){
            String key = iterator.next();
            String value = headers.get(key);
            post.addHeader(key, value);
        }
        //设置请求主体格式
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
  //---------------------------处理json格式的post请求-----------------------------------	
   public static String sendPost_json(String url,HashMap<String, String> headers,String strjson) throws ClientProtocolException, IOException{
	   //创建post请求对象
	   HttpPost Post = new HttpPost(url);
	   //设置头部信息
	   Set<String> set = headers.keySet();
       for(Iterator<String> iterator = set.iterator(); iterator.hasNext();){
           String key = iterator.next();
           String value = headers.get(key);
           Post.addHeader(key, value);
       }
       //设置请求主体json格式
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

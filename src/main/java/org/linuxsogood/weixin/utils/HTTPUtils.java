/**
 * linuxsogood.org
 * Copyright (c) 2014-2024 GaoXin,Inc.All Rights Reserved.
 */
package org.linuxsogood.weixin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author gm100861, </br> gm100861@gmail.com
 * @see org.linuxsogood.weixin.utils.HTTPUtils
 * @version	V0.0.1-SNAPSHOT, 2015年6月10日 下午2:20:28
 * @description
 * 
 */
public class HTTPUtils {

	/**
	 * @description 用于发起HTTP请求
	 * @param url	要请求的URL
	 * @param params	请求的参数
	 * @param headers	请求要加的头信息
	 * @return	返回请求的结果
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String get(String url,Map<String,String> params,Map<String,String> headers) throws ClientProtocolException, IOException{
		HttpClient httpClient = new DefaultHttpClient();
		
		/**
		 * 处理params
		 */
		String par = "";
		if(params != null && params.size() != 0) {
			List param = new ArrayList<String>();
			for(Entry entry : params.entrySet()){
				param.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
			}
			par = URLEncodedUtils.format(param, "UTF-8");
		}
		HttpGet httpGet = par.equals("") ? new HttpGet(url) : new HttpGet(url + "?" + par);
		httpGet.addHeader(new BasicHeader("Content-type", "text/html; charset=utf-8"));
		/**
		 * 处理传过来的header
		 */
		if(headers != null && headers.size() != 0){
			for (Entry<String, String> entry : headers.entrySet()) {
				httpGet.addHeader(new BasicHeader(entry.getKey(),entry.getValue()));
			}
		}
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if(entity != null){
			return EntityUtils.toString(entity);
		}
		return null;
	}
	
	@Deprecated
	private static String convertStreamToString(InputStream is) {      
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
        StringBuilder sb = new StringBuilder();      
       
        String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {  
                sb.append(line + "\n");      
            }      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            try {      
                is.close();      
            } catch (IOException e) {      
               e.printStackTrace();      
            }      
        }      
        return sb.toString();      
    }
	
}

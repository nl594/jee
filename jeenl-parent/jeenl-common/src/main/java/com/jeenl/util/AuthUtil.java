package com.jeenl.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.jeenl.constant.Constants;
import com.jeenl.constant.WXConstants;

import net.sf.json.JSONObject;

public class AuthUtil {
	
	public static JSONObject doGetJson(String url) throws Exception{
		JSONObject jsonObject = null;
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if(null != entity){
			String result = EntityUtils.toString(entity,Constants.UTF8);
			jsonObject = JSONObject.fromObject(result);
		}
		httpGet.releaseConnection();
		return jsonObject;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(System.currentTimeMillis());
//		JSONObject obj = doGetJson(WXConstants.WX_GET_TOKEN_URL);
//		String accessToken = (String) obj.get("access_token");
//		System.out.println(doGetJson(WXConstants.WX_GET_IPS_URL+accessToken));
	}
}

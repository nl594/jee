package com.jeenl.constant;

public class WXConstants {
	//nl ->  md5
	public static final String TOKEN="a8831d56eca781bd564d82bee03f075f";
	//https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
	public static final String WX_AUTH_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?";
	
	//https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
	public static final String WX_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?";
	
	//https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	public static final String WX_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?";
	
	//https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
	public static final String WX_GET_IPS_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";
	
	//https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	public static final String WX_GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+WXConstants.APPID+"&secret="+WXConstants.APPSECRET;
	
	public static final String APPID = "wx77edd33cc21f5dd6";
	
	public static final String APPSECRET = "e901632afaea93d742b15bdbdf11ae3a";
	

}

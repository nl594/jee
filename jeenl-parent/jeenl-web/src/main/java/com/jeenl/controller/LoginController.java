package com.jeenl.controller;

import java.net.URLEncoder;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jeenl.constant.Constants;
import com.jeenl.constant.WXConstants;
import com.jeenl.service.UserService;
import com.jeenl.user.dto.User;
import com.jeenl.util.AuthUtil;

@Controller
public class LoginController {
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@RequestMapping(value="/wxlogin", method = RequestMethod.GET)
	public void wxlogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String urlCallBack = "http://jeenl.imwork.net/wxCallBack";//可以访问的公网地址
		String url = WXConstants.WX_AUTH_URL+"appid="+WXConstants.APPID
				+ "&redirect_uri="+URLEncoder.encode(urlCallBack,Constants.UTF8)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE"
				+ "#wechat_redirect";
		response.sendRedirect(url);
	}
	
	@RequestMapping(value="/wxCallBack", method = RequestMethod.GET)
	public void wxCallBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("code");
		String url = WXConstants.WX_TOKEN_URL+"appid="+WXConstants.APPID
				+"&secret="+WXConstants.APPSECRET
				+"&code="+code
				+"&grant_type=authorization_code";
		JSONObject jsonObject = AuthUtil.doGetJson(url);
		String openId = jsonObject.getString("openid");
		String accessToken = jsonObject.getString("access_token");
		String userinfoUrl = WXConstants.WX_USERINFO_URL
				+"access_token="+accessToken
				+ "&openid="+openId
				+ "&lang=zh_CN";
		JSONObject userInfo = AuthUtil.doGetJson(userinfoUrl);
		System.out.println(userInfo);
		request.setAttribute("info", userInfo);
		User user = new User();
		user.setOpenid(userInfo.getString("openid"));
		user.setUserName(userInfo.getString("nickname"));
		user.setBirthday(new Date());
		user.setPassword("111111");
		userService.doSaveOrUpdateUser(user);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
		
	}
	@RequestMapping(value="/wxTest", method = RequestMethod.GET)
	public void wxTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getRequestDispatcher("/success1.jsp").forward(request, response);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

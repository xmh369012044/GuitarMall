package cn.tarena.gm.controller;

import cn.tarena.gm.pojo.User;
import cn.tarena.gm.tool.WebUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(){
		return "/login/login";
	}
	
	@RequestMapping("/tologin")
	public String toLogin(String username, String password, String remname,
			String autologin, Model model, HttpSession httpSession,
			HttpServletResponse response){
		//用户名或密码为空时则为false
		boolean flag = true;
		if(WebUtil.check(username)){
			model.addAttribute("UerrorInfo", "用户名不能为空！");
			flag = false;
		}
		if(WebUtil.check(password)){
			model.addAttribute("PerrorInfo", "密码不能为空！");
			flag = false;
		}
		//flag为false时则返回登录页面
		if(!flag){
			return "/login/login";
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = 
				new UsernamePasswordToken(username, password);
		try {
			//登录成功
			subject.login(token);
			User user = (User) subject.getPrincipal();
//			subject.getSession().setAttribute("userSession", user);
			httpSession.setAttribute("userSession", user);
			if("true".equals(remname)){
				Cookie cookie = new Cookie("remname", username);
				cookie.setPath("/");
				cookie.setMaxAge(3600*24*30);
				response.addCookie(cookie);
			}
			if("true".equals(autologin)){
//				token.setRememberMe(true);
				Cookie cookie = new Cookie("autologin", username+":"+password);
				cookie.setPath("/");
				cookie.setMaxAge(3600*24*30);
				response.addCookie(cookie);
			}
			return "/index";
		} catch (AuthenticationException e) {
			//登录失败
			model.addAttribute("UerrorInfo", "用户名或密码错误");
			return "/login/login";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession){
		httpSession.removeAttribute("userSession");
		return "/login/login";
	}
}




















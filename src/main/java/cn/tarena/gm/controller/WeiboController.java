package cn.tarena.gm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Controller
public class WeiboController {
	
	@RequestMapping("/weibo")
	public void weibologin(HttpServletResponse response) throws IOException{
		Properties prop = new Properties();
		String path = WeiboController.class.getClassLoader().
				getResource("config.properties").getPath();

		prop.load(new FileInputStream(new File(path)));
		String url = prop.getProperty("redirect_URL");
		System.out.print(url);
		response.sendRedirect(url);
	}
	
	@RequestMapping("/index")
	public String tiao(){
		return "https://api.weibo.com/oauth2/authorize?client_id=123050457758183&redirect_uri=http://127.0.0.1:8090/index.jsp/response&resp";
	}
}

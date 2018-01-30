package cn.tarena.gm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	//home.action
	
	//转向欢迎页面
	@RequestMapping("/toindex")
	public String home(){
		return "index";
	}
	
	
}

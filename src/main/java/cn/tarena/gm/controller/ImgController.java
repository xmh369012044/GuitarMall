package cn.tarena.gm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImgController {
	@RequestMapping("/ProdImg")
	public String prodImg(String imgurl){
		
		return imgurl;
		
	}
}

package cn.tarena.gm.controller;


import cn.tarena.gm.exception.MsgException;
import cn.tarena.gm.pojo.User;
import cn.tarena.gm.service.UserService;
import cn.tarena.gm.tool.VerifyCode;
import cn.tarena.gm.tool.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
	@Autowired
	private UserService userService;


	@RequestMapping("/list")
	public String findAll(Model model){
		List<User> userList= userService.findAll();

		model.addAttribute("userList", userList);
		return "sysadmin/user/jUserList";
	}

	//跳转注册页面
	@RequestMapping("/regist")
	public String regist(Model model) {
		model.addAttribute("requestScope.", model);
		return "/login/regist";
	}
	@RequestMapping("/VerifyCode")
	public void verifyCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
		//1、声明并实例化VerifyCode类的对象
		VerifyCode vc = new VerifyCode();
		//2、绘制图片，生成验证码字符串
		vc.drawImage(response.getOutputStream());
		//3、获取验证码的字符串
		String code = vc.getCode();
		//将code保存到session中，以便注册的servlet中验证使用
		request.getSession().setAttribute("code", code);
		//model.addAttribute("code", code);

	}


	//用户名唯一性约束
	@RequestMapping("/CheckUserName")
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//1、接收参数
		String username = request.getParameter("username");
		//2、判断用户名在数据库中是否存在
		try {
			Object user = userService.findUserUniqueness(username);
			if(user!= null){
				response.getWriter().write((user="true")+"");
			}else{
				response.getWriter().write((user="false")+"");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("error");
		}
	}




	//保存用户信息
	@RequestMapping("/RegistServlet")
	public String saveRegist(User user,HttpServletRequest request,Model model) throws Exception, Exception{
		Object tk1Obj = request.getSession().getAttribute("token");
		//A2、从隐藏域中接收token
		String tk2 = request.getParameter("token");
		//A3、比较
		if(tk2==null||tk1Obj==null||!tk2.equals((String)tk1Obj)){
			//重复提交
			throw new RuntimeException("请不要重复提交");
			//request.setAttribute("valistr_msg","请不要重复提交");

		}else{//第一次提交
			//从session中删除令牌
			request.getSession().removeAttribute("token");
		}
		//2、接收参数
		String valistr=request.getParameter("valistr");
		//valistr的判断
		//B1.从session中获取验证码
		Object codeObj = request.getSession().getAttribute("code");
		//B2.判断输入框中的验证码是否为空
		if(WebUtil.check(valistr)){
			request.setAttribute("valistr_msg","验证码不能为空");
			model.addAttribute("valistr_msg","验证码不能为空");
			//return "redirect:/regist";
		}
		//B3、验证两个是否相同
		if(!(codeObj!=null&&valistr.equalsIgnoreCase((String)codeObj))){
			//request.setAttribute("valistr_msg", "验证码输入错误");
			model.addAttribute("valistr_msg","验证码输入错误");

			String username = user.getUsername();
			String password = user.getNickname();
			String nickname = user.getNickname();
			String email = user.getEmail();


			model.addAttribute("username", username);
			model.addAttribute("password", password);
			model.addAttribute("password2", password);
			model.addAttribute("nickname", nickname);
			model.addAttribute("email", email);

			return "/login/regist";
		}
		try {
			userService.saveRegist(user);
			String  username = user.getUsername();
			model.addAttribute("weishenxianguse", username);
			return "/login/login";
		}catch(MsgException me){
			request.setAttribute("msg", me.getMessage());
			model.addAttribute("msg", me.getMessage());
			return "redirect:/regist";

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "系统错误");
			//request.getRequestDispatcher("/regist.jsp").forward(request, response);

			model.addAttribute("msg", "系统错误");
			return "redirect:/regist";
		}

		//return "/index";

	}

}
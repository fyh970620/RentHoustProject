package com.yc.web.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yc.bean.JsonModel;
import com.yc.bean.Users;
import com.yc.biz.UserBiz;

/**
 * @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML        
 *　数据，需要注意的呢，在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
 * @author Administrator
 *
 */
@ResponseBody
@Controller
public class UserController {
	
	@Resource(name="userBizImpl")
	private UserBiz userBiz;
	
	/**
	 * logout
	 * @param user
	 * @return
	 */
	/*@RequestMapping("user/logout.action")
	public ModelAndView logout(HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		session.removeAttribute("users");
		mav.setViewName("login");
		return mav;
	}*/
	//重定向
	@RequestMapping("/user/logout.action")
	public void logout(HttpSession session,HttpServletResponse resp){
		session.removeAttribute("users");
		
		try {
			resp.sendRedirect("../index.jsp");
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	//注册
	@RequestMapping("User_register.action")
	public JsonModel register(Users user){
		JsonModel jm = new JsonModel();
		boolean result = userBiz.Register(user);
		if(result){
			jm.setCode(1);
		}else{
			jm.setCode(0);
		}
		return jm;
	}
	
	/**
	 * 登录
	 * 将后台返回的数据传递给View层，同时包含一个要访问的View层的URL地址
	 * 当控制器处理完请求后，通常控制器会将包含视图名称以及一些模型属性的ModelAndView对象返回给DispatcherServlet。因此，在控制器中会构造一个ModelAndView对象
	 * ModelAndView作用
	 * 设置转向地址
	 * 将底层获取的数据进行存储（或者封装）
	 * 最后将数据传递给View
	 */
	@RequestMapping("/User_login.action")
	public ModelAndView login(Users users ,HttpServletRequest request,HttpSession session){
		ModelAndView mav = new ModelAndView();
		String veryCode = request.getParameter("veryCode");
		String rand = session.getAttribute("rand").toString();
		if(!rand.equals(veryCode)){
			request.setAttribute("errmsg","验证码输入错误");
			mav.setViewName("login");
		}else{
			users = userBiz.login(users);
			if(users!=null){
				//查当前登录User的id
				Integer id = userBiz.getId(users.getUsername());
				
				session.setAttribute("id", id);
				session.setAttribute("users", users);
				System.out.println("**************************"+users);
				System.out.println("**************************"+id);
				//传递给list.jsp
				mav.setViewName("list");
				return mav;
			}else{
				request.setAttribute("errmsg", "输入的密码或者用户名有误");
			}
		}
		mav.setViewName("list");
		return mav;
		
	}
	
	
}

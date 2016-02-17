package com.wwj.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wwj.user.entity.User;
import com.wwj.user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User u,HttpServletRequest request){
		User resultUser=userService.login(u);
		if(resultUser==null){
			request.setAttribute("user", u);
			request.setAttribute("errorMsg", "不行的");
			return "index";
		}
		else{
			HttpSession  session = request.getSession();
			session.setAttribute("currentUser", resultUser);
			return "redirect:/success.jsp";
		}
		
	}
    
}

package com.rs.fer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rs.fer.entity.User;
import com.rs.fer.service.UserService;
import com.rs.fer.util.FERUtil;
import com.rs.fer.vo.AddExpenseVo;
import com.rs.fer.vo.LoginVo;
import com.rs.fer.vo.RegistrationVo;
import com.rs.fer.vo.ResetPasswordVo;
import com.rs.fer.vo.UpdateProfileVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;


	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcome() throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	@RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
	public ModelAndView displayRegistration() throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Registration");
		return mv;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute RegistrationVo registrationVo, BindingResult result) {
		
		ModelAndView mv = new ModelAndView();
		
		boolean isAdded=userService.saveUser(registrationVo);

		String nextPath="";
		
		if(isAdded) {
			
		mv.addObject("status", "User registration is succefull");
		
		nextPath="Login";
		
		}else {
			mv.addObject("status", "User registration is Unsuccefull");
			nextPath="Registration";
		}
		mv.setViewName(nextPath);
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute LoginVo loginVo, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		

		User user= userService.login(loginVo);
		
		String nextPath="";
		
		if(user !=null){
	
			HttpSession session= request.getSession();
			
			session.setAttribute("username", user.getUsername());
			
			session.setAttribute("userId", user.getId());
		
        		nextPath="Dashboard";
		
		}else {
			mv.addObject("status", "Invalid username/password.plz try again later");
		
			nextPath="Login";
		}
		mv.setViewName(nextPath);
		
		return mv;
	}
	
	@RequestMapping(value = "/nameInfo", method = RequestMethod.POST)
	public ModelAndView nameInfo(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("NameInfo");
		
		HttpSession session= request.getSession(); 

		UpdateProfileVo updateProfileVo= userService.nameInfo(session);
		
			session.setAttribute("updateProfileVo", updateProfileVo);
		
			mv.addObject("updateProfileVo", updateProfileVo);
		
			
		return mv;
	}

	@RequestMapping(value = { "/contactInfo" }, method = RequestMethod.POST)
	public ModelAndView contactInfo(@ModelAttribute UpdateProfileVo updateProfileVo, ModelAndView modelAndView,HttpServletRequest request) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		updateProfileVo=userService.contactInfo(updateProfileVo, session);
		
		session.setAttribute("updateProfileVo", updateProfileVo);
		
		mv.addObject("updateProfileVo",updateProfileVo);
		
		mv.setViewName("ContactInfo");
		
		return mv;
	}
	
	@RequestMapping(value = { "/addressInfo" }, method = RequestMethod.POST)
	public ModelAndView addressInfo(@ModelAttribute UpdateProfileVo updateProfileVo, ModelAndView modelAndView,HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		updateProfileVo=userService.adressInfo(updateProfileVo, session);
		
		session.setAttribute("updateProfileVo", updateProfileVo);
		
		mv.addObject("updateProfileVo",updateProfileVo);
				
		mv.setViewName("AddressInfo");
		return mv;
	}
	
	@RequestMapping(value = { "/review" }, method = RequestMethod.POST)
	public ModelAndView review(@ModelAttribute UpdateProfileVo updateProfileVo, ModelAndView modelAndView,HttpServletRequest request) throws IOException {
		
		HttpSession session= request.getSession();
		
		updateProfileVo=userService.review(updateProfileVo, session);
		
		session.setAttribute("updateProfileVo", updateProfileVo);
		
		modelAndView.addObject("updateProfileVo",updateProfileVo);
				
		modelAndView.setViewName("Review");
		
		return modelAndView;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		HttpSession session= request.getSession();
		
		boolean isUpdatedUser=userService.updateUser(session);

		if(isUpdatedUser) {
			
		mv.addObject("status", "User Updated  succefully");
		
		}else {
			mv.addObject("status", "User updation failed ");
		}
		mv.setViewName("Status");
		
		return mv;
	}

	@RequestMapping(value = "/displayResetPassword", method = RequestMethod.POST)
	public ModelAndView displayResetPassword() throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ResetPassword");
		return mv;
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute ResetPasswordVo resetPasswordVo, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		boolean isReset= userService.resetPassword(resetPasswordVo, request);
		
		if(isReset){
	
			mv.addObject("status", "Password Updated Succesfully");
		
		}else {
			mv.addObject("status", "Password Updated Failed");
		
		}
		mv.setViewName("Status");
		
		return mv;
	}
	

}

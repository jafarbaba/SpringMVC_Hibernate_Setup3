package com.rs.fer.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rs.fer.entity.User;
import com.rs.fer.vo.LoginVo;
import com.rs.fer.vo.RegistrationVo;
import com.rs.fer.vo.ResetPasswordVo;
import com.rs.fer.vo.UpdateProfileVo;

public interface UserService {

	public User getUserById(int id);

	public boolean saveUser(RegistrationVo registrationVo);

	User login(LoginVo loginVo);
	
	UpdateProfileVo nameInfo(HttpSession session);

	UpdateProfileVo contactInfo(UpdateProfileVo updateProfileVo, HttpSession session);
	
	UpdateProfileVo adressInfo(UpdateProfileVo updateProfileVo, HttpSession session);
	
	UpdateProfileVo review(UpdateProfileVo updateProfileVo, HttpSession session);
	
	boolean updateUser(HttpSession session);
	
	boolean resetPassword(ResetPasswordVo resetPasswordVo,HttpServletRequest request);
	
}
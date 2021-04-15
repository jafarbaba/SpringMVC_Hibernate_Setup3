package com.rs.fer.util;

import org.springframework.stereotype.Component;

import com.rs.fer.entity.User;
import com.rs.fer.vo.RegistrationVo;
import com.rs.fer.vo.ResetPasswordVo;
import com.rs.fer.vo.UpdateProfileVo;
@Component
public class UserUtilImpl implements UserUtil {

	@Override
	public User getUser(RegistrationVo registrationVo) {
		User user= new User();
		
		user.setFirstName(registrationVo.getFirstName());
		
		user.setMiddleName(registrationVo.getMiddleName());
		
		user.setLastName(registrationVo.getLastName());
		
		user.setEmail(registrationVo.getEmail());
		
		user.setUsername(registrationVo.getUsername());
		
		user.setPassword(registrationVo.getPassword());
		
		user.setMobile(registrationVo.getMobile());
		
		user.setCreated(DateUtil.getCurrentDate());
		
		return user;
	}

	@Override
	public UpdateProfileVo getUpdateProfileVo(User user) {

		UpdateProfileVo updateProfileVo=new UpdateProfileVo();
		
		updateProfileVo.setFirstName(user.getFirstName());
		
		updateProfileVo.setMiddleName(user.getMiddleName());
		
		updateProfileVo.setLastName(user.getLastName());
	
		updateProfileVo.setEmail(user.getEmail());
		
		updateProfileVo.setMobile(user.getMobile());


        if(user.getAddress() !=null) {
		
		updateProfileVo.setLine1(user.getAddress().getLine1());
		updateProfileVo.setLine2(user.getAddress().getLine2());
		updateProfileVo.setCity(user.getAddress().getCity());
		updateProfileVo.setState(user.getAddress().getState());
		updateProfileVo.setPinCode(user.getAddress().getPinCode());
		updateProfileVo.setCountry(user.getAddress().getCountry());
	}
		

		return updateProfileVo;
	}

	@Override
	public ResetPasswordVo getResetPasswordVo(User user) {

		ResetPasswordVo resetPasswordVo=new ResetPasswordVo();

		user.setPassword(resetPasswordVo.getCurrentpassword());
		
		user.setPassword(resetPasswordVo.getNewPassword());
		
		user.setPassword(resetPasswordVo.getReEnterNewPassword());
		
		return resetPasswordVo;
	}

	
}

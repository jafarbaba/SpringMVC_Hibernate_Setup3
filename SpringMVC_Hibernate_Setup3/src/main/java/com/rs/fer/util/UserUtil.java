package com.rs.fer.util;

import com.rs.fer.entity.User;
import com.rs.fer.vo.RegistrationVo;
import com.rs.fer.vo.ResetPasswordVo;
import com.rs.fer.vo.UpdateProfileVo;

public interface UserUtil {

	User getUser(RegistrationVo  registrationVo);
	
	UpdateProfileVo getUpdateProfileVo(User user);
	
	ResetPasswordVo getResetPasswordVo(User user);
}

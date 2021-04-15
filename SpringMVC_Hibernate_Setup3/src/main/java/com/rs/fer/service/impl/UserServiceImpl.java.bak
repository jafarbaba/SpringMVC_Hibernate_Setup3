package com.rs.fer.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.rs.fer.entity.Address;
import com.rs.fer.entity.User;
import com.rs.fer.repository.UserRepository;
import com.rs.fer.service.UserService;
import com.rs.fer.util.DateUtil;
import com.rs.fer.util.FERUtil;
import com.rs.fer.util.UserUtil;
import com.rs.fer.vo.LoginVo;
import com.rs.fer.vo.RegistrationVo;
import com.rs.fer.vo.ResetPasswordVo;
import com.rs.fer.vo.UpdateProfileVo;

@Service
public class UserServiceImpl implements UserService {

	    @Autowired
		private UserRepository repository;

	    @Autowired
		private UserUtil userUtil;

	@Transactional
	@Override
	public User getUserById(int id) {
		User user = repository.findById(id).get();
		return user;
	}
	@Transactional
	@Override
	public boolean saveUser(RegistrationVo  registrationVo) {
		
		User user= userUtil.getUser(registrationVo);
		try {
			repository.save(user);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	@Override
	public User login(LoginVo loginVo) {

		User user = new User();
		  
		List<User> users= repository.findByUsernameAndPassword(loginVo.getUsername(), loginVo.getPassword()); 
		
		if(!CollectionUtils.isEmpty(users)) {
			user =users.get(0);
		}
		return user;
	}
	@Override
	public UpdateProfileVo nameInfo(HttpSession session) {
		
		UpdateProfileVo updateProfileVo=null;

		int userId= FERUtil.getUserId(session);
		
		User user= repository.findById(userId).get();
		
		session.setAttribute("user", user);
		
		updateProfileVo= userUtil.getUpdateProfileVo(user);
		
		return updateProfileVo;
	}
	@Override
	public UpdateProfileVo contactInfo(UpdateProfileVo updateProfileVo, HttpSession session) {

		
		User user = (User)session.getAttribute("user");
		
		user.setFirstName(updateProfileVo.getFirstName());
		user.setMiddleName(updateProfileVo.getMiddleName());
		user.setLastName(updateProfileVo.getLastName());
		
		updateProfileVo.setEmail(user.getEmail());
		updateProfileVo.setMobile(user.getMobile());
		
		return updateProfileVo;
	}
	@Override
	public UpdateProfileVo adressInfo(UpdateProfileVo updateProfileVo, HttpSession session) {
         
		User user = (User)session.getAttribute("user");
		
		user.setEmail(updateProfileVo.getEmail());
		user.setMobile(updateProfileVo.getMobile());
		
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
	public UpdateProfileVo review(UpdateProfileVo updateProfileVo, HttpSession session) {
		 
		User user = (User)session.getAttribute("user");
		user.setUpdated(DateUtil.getCurrentDate());
            if(user.getAddress() == null) {
            	
            	user.setAddress(new Address());
            }
            
			Address address= user.getAddress();
			address.setLine1(updateProfileVo.getLine1());
			address.setLine2(updateProfileVo.getLine2());
			address.setCity(updateProfileVo.getCity());
			address.setState(updateProfileVo.getState());
			address.setPinCode(updateProfileVo.getPinCode());
			address.setCountry(updateProfileVo.getCountry());
			address.setUpdated(DateUtil.getCurrentDate());
			address.setCreated(DateUtil.getCurrentDate());
			
			updateProfileVo= userUtil.getUpdateProfileVo(user);
	
			return updateProfileVo;
	}
	@Override
	public boolean updateUser( HttpSession session) {

		User user = (User)session.getAttribute("user");
		
		try {
			repository.save(user);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}
	@Override
	public boolean resetPassword(ResetPasswordVo resetPasswordVo,HttpServletRequest request) {

		User user = new User();
		
		HttpSession session= request.getSession();
		
		int userId= FERUtil.getUserId(session);

		List<User> users= repository.findByIdAndPassword(userId, resetPasswordVo.getCurrentpassword());
		
		if(!CollectionUtils.isEmpty(users)) {
			user =users.get(0);
		}
		if(user != null) {
        	
        	user.setPassword(resetPasswordVo.getNewPassword());
        	
        	user.setCreated(DateUtil.getCurrentDate());
        }
        
		try {
			repository.save(user);
			return true;
		}catch(Exception ex) {
			return false;
		}
		
	}

}

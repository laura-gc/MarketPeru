package com.init.Markertper.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.init.Markertper.api.interfaces.IUser;
import com.init.Markertper.api.modelo.Authority;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	IUser userRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.init.Markertper.api.modelo.User appUser = userRepositorio.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
			
	  
	    List grantList = new ArrayList(); 
	    
	    for (Authority authority: appUser.getAuthority()) {


	        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
	            grantList.add(grantedAuthority); 
	    }
			
	    UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
	         return user;
	}
	
	

}

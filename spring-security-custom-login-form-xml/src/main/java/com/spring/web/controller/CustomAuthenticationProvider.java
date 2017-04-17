package com.spring.web.controller;

import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 String userName = authentication.getName().trim();
	        String password = authentication.getCredentials().toString().trim();
	        Authentication auth = null;
	    CustomLogin login = new CustomLogin();
	    //Authenticate the user based on your custom logic
	    String  role = login.getApplicationRole(userName, password, "ADMIN","DEVELOPER");
	        if (role != null)
	        {
	        Collection<GrantedAuthority> grantedAuths = new java.util.ArrayList<GrantedAuthority>();
	        grantedAuths.add(new SimpleGrantedAuthority(role.trim()));
	       
	        
	        ApplicationUser appUser = new ApplicationUser(userName,password, true, true, true, true,grantedAuths,"TestEmail");
	        auth = new UsernamePasswordAuthenticationToken(appUser, password, grantedAuths);
	            return auth;
	        }
	        else 
	        {
	          return null;
	        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}

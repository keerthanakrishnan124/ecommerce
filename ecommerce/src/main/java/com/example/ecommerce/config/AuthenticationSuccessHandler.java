package com.example.ecommerce.config;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import java.io.IOException;

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        boolean isAdmin = authentication.getAuthorities().stream()
//                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
    	boolean isAdmin = false;
    	for (GrantedAuthority authority : authentication.getAuthorities()) {
    	    if (authority.getAuthority().equals("ROLE_ADMIN")) {
    	        isAdmin = true;
    	        break;
    	    }
    	}

        if (isAdmin) {
        	response.sendRedirect("/admin/home");
        } else {
        	response.sendRedirect("/user/home");
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
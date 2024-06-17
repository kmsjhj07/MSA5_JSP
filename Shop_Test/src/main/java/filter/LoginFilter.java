package filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import shop.dto.PersistentLogin;
import shop.dao.UserRepository;

public class LoginFilter implements Filter {
	
	Cookie[] cookies;
	UserRepository userRepository;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		userRepository = new UserRepository();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		cookies = httpRequest.getCookies();
		
		String rememberMe = null;		
		String token = null;			
		
		if( cookies != null ) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String cookieName = cookie.getName();
				String cookieValue = URLDecoder.decode( cookie.getValue(), "UTF-8" );
				switch(cookieName) {
					case "rememberMe"	:  rememberMe = cookieValue; 	break;
					case "token"		:  token = cookieValue; 	break;
				}
			}
		}
		System.out.println("LoginFilter...");
		System.out.println("rememberMe : " + rememberMe);
		System.out.println("token : " + token);
		
		HttpSession session = httpRequest.getSession();
		if( rememberMe != null && token != null ) {
			PersistentLogin persistentLogins = userRepository.selectTokenByToken(token);
			if( persistentLogins != null ) {
				session.setAttribute("loginId", persistentLogins.getUserId());
			}
		}
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		
	}

	

}
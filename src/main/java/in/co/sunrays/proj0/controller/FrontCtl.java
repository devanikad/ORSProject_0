package in.co.sunrays.proj0.controller;

import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// TODO: Auto-generated Javadoc
/**
 * Main Controller performs session checking and logging operations before
 * calling any application controller. It prevents any user to access
 * application without login.
 * 
 * @author Facade
 * @version 1.0 Copyright (c) Facade
 */
public class FrontCtl extends HandlerInterceptorAdapter 
{
	
	/** The mess source. */
	@Autowired
   private MessageSource messSource; 
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
	  HttpSession session = request.getSession();
	  
	  if(session.getAttribute("user")==null)
	  {
		  Locale locale=null;
		  
		  String msg = messSource.getMessage("message.session", null, locale);
		  request.setAttribute("error", msg);
		  String string = request.getRequestURI();
		  request.setAttribute("uri", string);
		  RequestDispatcher rd = request.getRequestDispatcher("/Login");
          rd.forward(request, response);
          return false;
	  }
		return true;
	}
}


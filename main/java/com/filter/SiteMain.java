package com.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SiteMain implements Filter {
	public void init(FilterConfig filterConfig) {
		System.out.println("init");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		System.out.println("doFilter");
	}
	
	public void destory() {
		System.out.println("destory");
	}
}

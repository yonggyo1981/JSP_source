package com.core;

import static java.lang.Math.*;

/**
 * 페이지네이션 
 *
 */
public class Pagination {
	private int page; // 페이지 번호
	private int pageLinks; // 페이지 구간별 개수
	private int limit; //1페이지당 출력 개수
	private int startNo; // 구간별 시작 번호
	private int lastNo; // 구간별 종료 번호
	private int num; // 구간 번호
	
	public Pagination(int page, int total) {
		this.page = page;
		if (this.page <= 0) 
			this.page = 1;
		
		pageLinks = 5; // 페이지 구간별 개수
		limit = 15; // 1페이지당 출력 개수 
		
		num = (int)floor((this.page - 1)/pageLinks); // 페이지 구간 번호

		startNo = num * pageLinks + 1; // 구간별 시작 번호
		lastNo = startNo + pageLinks - 1; // 구간별 종료 번호
	}
	
	public String getPageHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<ul class='pagination'>");
		
		for (int i = startNo; i <= lastNo; i++) {
			sb.append("<li class='page'>");
			sb.append(i);
			sb.append("</li>");
		}
		
		sb.append("</ul>");
		
		return sb.toString();
	}
}





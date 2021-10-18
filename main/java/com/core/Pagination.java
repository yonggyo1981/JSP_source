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
	private int prevNo; // 이전 구간 시작 번호
	private int nextNo; // 다음 구간 시작 번호
	private int lastPageNo; // 마지막 페이지 번호
	
	public Pagination(int page, int total) {
		this.page = page;
		if (this.page <= 0) 
			this.page = 1;
		
		pageLinks = 5; // 페이지 구간별 개수
		limit = 15; // 1페이지당 출력 개수 
		
		num = (int)floor((this.page - 1)/pageLinks); // 페이지 구간 번호

		startNo = num * pageLinks + 1; // 구간별 시작 번호
		lastNo = startNo + pageLinks - 1; // 구간별 종료 번호
		
		// 마지막 페이지 번호
		lastPageNo = (int)ceil(total / limit);
		
		// 마지막 페이지 구간
		int lastNum = (int)floor((lastPageNo - 1) / pageLinks); 
		
		// 마지막 구간의 페이지 번호가 마지막 페이지 번호보다 크면 X
		if (lastNo > lastPageNo) {  
			lastNo = lastPageNo;
		}
		
		// 이전 구간 페이지 시작 번호
		if (num > 0) {
			prevNo = (num - 1) * pageLinks + 1;
		}
		
		// 다음 구간 페이지 시작 번호
		if (num < lastNum) { // 현재 페이지 구간이 마지막 페이지 구간보다 이전인 경우 
			nextNo = (num + 1) * pageLinks + 1;
		}
	}
	
	public String getPageHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<ul class='pagination'>");
		
		// 첫 페이지 
		sb.append("<li class='page'>");
		sb.append("<a href='#'>");
		sb.append(1);
		sb.append("</a>");
		sb.append("</li>");
		
		// 이전 페이지 링크 
		if (prevNo > 0) {
			sb.append("<li class='page'>");
			sb.append("<a href='#'>");
			sb.append(prevNo);
			sb.append("</a>");
			sb.append("</li>");
		}
		
		for (int i = startNo; i <= lastNo; i++) {
			sb.append("<li class='page'>");
			sb.append(i);
			sb.append("</li>");
		}
		
		// 다음 페이지
		if (nextNo > 0) {
			sb.append("<li class='page'>");
			sb.append("<a href='#'>");
			sb.append(nextNo);
			sb.append("</a>");
			sb.append("</li>");
			sb.append("</ul>");
		}
		
		// 마지막 페이지
		sb.append("<li class='page'>");
		sb.append("<a href='#'>");
		sb.append(lastPageNo);
		sb.append("</a>");
		sb.append("</li>");
		
		return sb.toString();
	}
}





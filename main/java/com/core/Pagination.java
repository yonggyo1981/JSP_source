package com.core;

/**
 * 페이지네이션 
 *
 */
public class Pagination {

	public Pagination(int page, int total) {
		int pageLinks = 5; // 페이지 구간별 개수
		int limit = 15; // 1페이지당 출력 개수 
		
		int num = (int)Math.floor((page - 1)/pageLinks); // 페이지 구간 번호
		
	}
}

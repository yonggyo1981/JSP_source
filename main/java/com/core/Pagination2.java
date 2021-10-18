package com.core;

import static java.lang.Math.*;

public class Pagination2 {
	public Pagination2(int page, int total) {
		/** 
		 * 페이지 구간 번호
		 * (구간별 페이지 개수)
		 */
		page = (page <= 0)?1:page;
		int pageLinks = 5;
		int num = (int)floor((page - 1) * pageLinks);
		System.out.printf("num = %d", num);
	}
}

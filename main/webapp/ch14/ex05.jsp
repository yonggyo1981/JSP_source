<%@ page contentType="text/html; charset=utf-8" %>
<%
	Cookie userId = new Cookie("userId", "admin");
	userId.setMaxAge(60 * 60); // 60초 * 60분 -> 1시간
	userId.setHttpOnly(true);
	response.addCookie(userId);
%>
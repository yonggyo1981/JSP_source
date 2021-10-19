<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.core.Pagination3" %>
<%
	Pagination3 pagination = new Pagination3(25, 1000, 10, 15);

	out.print(pagination.getPageHtml());
%>
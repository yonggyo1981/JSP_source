<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.core.Pagination" %>
<%
	Pagination pagination = new Pagination(13, 1000);
%>
<%=pagination.getPageHtml()%>
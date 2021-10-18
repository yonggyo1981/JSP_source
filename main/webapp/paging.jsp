<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.core.Pagination" %>
<%
	Pagination pagination = new Pagination(request, 1000);
%>
<%=pagination.getPageHtml()%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.core.Pagination2" %>
<%
	Pagination2 pagination = new Pagination2(66, 1000);
%>
<%=pagination.getPageHtml()%>
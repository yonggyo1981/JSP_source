<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.net.*" %>
<h1>param01.jsp</h1>
<jsp:forward page="param02.jsp">
	<jsp:param name="id" value="admin" />
	<jsp:param name="name" value='<%=URLEncoder.encode("관리자", "UTF-8")%>' />
</jsp:forward>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page isErrorPage="true" %>
<h1>에러 발생!</h1>
에러 메세지 : <%=exception.getMessage()%><br>
<% exception.printStackTrace(new java.io.PrintWriter(out)); %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.core.Logger" %>
<%
	Logger.init("dev", "D:\\logs");
	Logger.log("테스트 로그1");
	Logger.log("테스트 로그2");
	Logger.log("테스트 로그3");
%>
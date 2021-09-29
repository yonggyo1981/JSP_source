<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	//String hobby = request.getParameter("hobby");
	String[] hobbies = request.getParameterValues("hobby");
	
	Enumeration<String> names = request.getParameterNames();
	while(names.hasMoreElements()) {
		String param = names.nextElement();
		String value = null;
		if (param.equals("hobby")) {
			String[] hobbies2 = request.getParameterValues(param);
			StringBuilder sb = new StringBuilder();
			for (String hobby : hobbies) {
				sb.append(hobby);
				sb.append(" ");
			}
			
			value = sb.toString();
			
		} else {
			value = request.getParameter(param);
		}
		out.print(param + "=" + value + "<br>");
	}
	
%>
<br>
<c:set var="hobbies" value="<%=hobbies%>" />

<table border="1">
	<thead>
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>회원명</th>
		<th>취미</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td><%=id%></td>
		<td><%=password %></td>
		<td><%=name%></td>
		<td>
			<c:forEach var="hobby" items="${hobbies}">
				<c:out value="${hobby}" />	
			</c:forEach>
		</td>
	</tr>
	</tbody>
</table>




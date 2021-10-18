<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource var="dataSource"
	url="jdbc:mysql://localhost:3306/JSPBookDB"
	driver="com.mysql.cj.jdbc.Driver"
	user="root"
	password="aA!12345"
/>
<sql:query var="resultSet" dataSource="${dataSource}">

</sql:query>
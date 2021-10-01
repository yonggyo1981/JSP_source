<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%
String fileUploadPath = getServletContext().getRealPath("//upload");
ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

List<FileItem> items = upload.parseRequest(request);

Iterator<FileItem> params = items.iterator();
while(params.hasNext()) {
	FileItem fileitem = params.next();
	if (!fileitem.isFormField()) { // 일반 데이터가 아닌 경우 -> 파일 데이터
		String filename = fileitem.getName(); // 경로 포함 파일명
		out.print(filename);

	}
}


%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.yc.utils.*,java.util.*"%>
<%
	FileUploadUtils fu = new FileUploadUtils();
	Map<String, String> map = fu.uploadFiles(pageContext);
	//调出回调函数名: jsonp技术
	response.setContentType("text/html; charset=utf-8");
	
	//function show() 
	String callback = request.getParameter("CKEditorFuncNum");
	
	//将以上客户指定的函数形式，以javaScript代码写入客户端中
	out.println("<script type=\"text/javascript\">");
	out.println("window.parent.CKEDITOR.tools.callFunction("+ callback+",'"+map.get("upload_weburl")+"','')");
	out.println("</script>");
	out.flush();
%>
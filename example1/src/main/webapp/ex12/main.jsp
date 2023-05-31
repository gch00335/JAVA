<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("attr","hello world");
%>
<%= request.getAttribute("attr")%><br/>
${requestScope["attr"]}<br/>
${requestScope.attr}<br/>
${requestScope["attr2"]}<br/>
<%
Map<String, String> map = new HashMap<>();
map.put("one", "hello");
map.put("two", "World");
pageContext.setAttribute("map", map);
%>
${map.get("one")}, ${map["one"]}, ${map.one }

<%-- ${(10*10) ne 100 }<br/> --%>
${pageContext.request.contextPath }<br/>


<%-- <%
	Map<String,String>map = new HashMap<>();
	map.put("1","a");
	map.put("2","b");
	map.put("3","c");
	String a = map.get("1");
	pageContext.setAttribute("map",map);
%>
map[1] : <%= a %><br/>
${map["1"]}<br/>
${100%20}<br/>
${true&&false}<br/>  --%>
</body>
</html>
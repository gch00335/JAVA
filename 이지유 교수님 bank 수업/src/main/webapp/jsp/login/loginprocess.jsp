<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script>
	alert('${msg}')
	location.href = "${ pageContext.request.contextPath}";
</script>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>您的购物车商品如下：</h2>
	<%
	//1.先获得map
	Map<String, Integer> map=(Map<String, Integer>)session.getAttribute("cart");
	
	//2.遍历该map
	if(map!=null){
		for(String key:map.keySet()){
			int value=map.get(key);
			//key ：商品名称 value:商品数量
	   %>
			<h3> 名称：<%=key%> 数量：<%=value%> </h3><br>
		<%	
		}
	}
	
	%>
	
	<a href="ClearCartServlet"><h4>清空购物车</h4></a>
</body>
</html>
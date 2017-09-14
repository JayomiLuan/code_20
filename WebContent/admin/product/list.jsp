<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息列表</title>
<style>
	td>img {width:100px;}
</style>
</head>
<body>

	<table border="1" width="600" align="center">
		<tr>
			<th><input type="checkbox" id="checkAll"></th>
			<th>图片</th>
			<th>名称</th>
			<th>分类</th>
			<th>价格</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach var="p" items="${allProduct }">
		<tr>
			<td><input type="checkbox" name="id" value="${p.id }"></td>
			<td><img src="${pageContext.request.contextPath}${p.img_path }"></td>
			<td>${p.name }</td>
			<!-- 设置一个临时变量，值为分类的ID,以此值为Key取得Map中对应的名字 -->
			<c:set var="t" value="${p.category_id }"/>
			<td>${categoryMap[t] }</td>
			<td>${p.price }</td>
			<td>${p.description }</td>
			<td>
				<a href="${pageContext.request.contextPath}/productServlet?method=delete&id=${p.id}">删除</a>
				<a href="${pageContext.request.contextPath}/productServlet?method=modifyUI&id=${p.id}">修改</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	<!-- 发送请求到Servlet，转跳到添加商品信息的页面 -->
	<input type="button" value="添加" onclick="goAdd();" />

</body>
</html>
<script>
	function goAdd(){
		location.href = '${pageContext.request.contextPath}/productServlet?method=addUI';
	}


</script>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单管理</title>

	<%--静态包含 base标签，css样式，jQuery文件--%>
	<%@include file="/pages/common/head.jsp"%>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">订单管理系统</span>

		<%--静态包含 manager管理模块的菜单--%>
		<%@include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>详情</td>
				<td>发货</td>
				
			</tr>
			<c:forEach items="${requestScope.orders}" var="orders">
			<tr>
				<td>${orders.createTime}</td>
				<td>${orders.price}</td>
				<td><a href="OrderServlet?action=showOrderDetail&orderId=${orders.orderId}">查看详情</a></td>

				<c:if test="${orders.status==0}">
					<td><a href="OrderServlet?action=sendOrder&orderId=${orders.orderId}&status=1">未发货</a></td>
				</c:if>

				<c:if test="${orders.status==1}">
					<td><a href="OrderServlet?action=sendOrder&orderId=${orders.orderId}&status=2">已发货</a></td>
				</c:if>

				<c:if test="${orders.status==2}">
					<td><a href="OrderServlet?action=sendOrder&orderId=${orders.orderId}&status=0">以签收</a></td>
				</c:if>

			</tr>	
			</c:forEach>

		</table>
	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>

</body>
</html>
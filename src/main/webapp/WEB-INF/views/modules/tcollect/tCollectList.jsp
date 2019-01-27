<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户收藏管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
	<style type="text/css">
		.wid100{width: 100px}
	</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">用户收藏列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="tCollect" action="${ctx}/tcollect/tCollect/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns">商品名称：<form:input cssClass="wid100" path="goodsname"/></li>
			<li class="btns">用户昵称：<form:input cssClass="wid100" path="nickname"/></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="130px">商品图片</th>
				<th width="180px">商品名称</th>
				<th width="160px">用户昵称</th>
				<th>收藏时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="t">
			<tr>
				<td><img alt="" style="width: 120px;height: 70px" src="${t.image }"></td>
				<td>${t.goodsname }</td>
				<td>${t.nickname }</td>
				<td>
					<fmt:formatDate type="both" value="${t.createtime }"/>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
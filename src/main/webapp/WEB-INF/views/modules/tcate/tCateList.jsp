<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>类目管理</title>
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
		function toadd(){
			location.href='/curtain/a/tcate/tCate/toadd';
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/tcate/tCate/">类目列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="tCate" action="${ctx}/tcate/tCate/" method="post" class="breadcrumb form-search">
		<input id="btnAdd" class="btn btn-primary" type="button" value="添加类目" onclick="toadd()" />
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="150px">类目名称</th>
				<th width="100px">排序</th>
				<th width="100px">状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="t">
			<tr>
				<td>${t.catename}</td>
				<td>${t.sort}</td>
				<td>
					<c:if test="${t.state==1 }">显示</c:if>
					<c:if test="${t.state==0 }">隐藏</c:if>
				</td>
				<td>
    				<a href="${ctx}/tcate/tCate/form?cateid=${t.cateid}">修改</a>
    				<a href="${ctx}/tcate/tCate/updateState?cateid=${t.cateid}&state=2" onclick="return confirmx('确认要删除该类目吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
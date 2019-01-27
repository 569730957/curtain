<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>字典管理管理</title>
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
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/tdic/tDic/">属性管理</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="tDic" action="${ctx}/tdic/tDic/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns">
				属性类型：
				<form:select path="dictype">
					<form:option value="style">风格分类</form:option>
					<form:option value="color">颜色分类</form:option>
					<form:option value="fabric">面料分类</form:option>
					<form:option value="technology">工艺分类</form:option>
				</form:select>
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="150px">属性类型名称</th>
				<th width="150px">属性值名称</th>
				<th width="100px">属性值</th>
				<th width="100px">排序</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="t">
			<tr>
				<td>${t.remark }</td>
				<td>${t.dicname }</td>
				<td>${t.dicvalue }</td>
				<td>${t.sort }</td>
				<td>
    				<a href="${ctx}/tdic/tDic/form?id=${t.dicid}">修改</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
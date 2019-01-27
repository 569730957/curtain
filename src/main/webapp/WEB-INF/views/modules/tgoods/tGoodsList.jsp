<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品管理管理</title>
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
			location.href='/curtain/a/tgoods/tGoods/toadd';
		}
		
	</script>
	<style type="text/css">
		.wid80{width:100px}
	</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/tgoods/tGoods/">商品列表</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="tGoods" action="${ctx}/tgoods/tGoods/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns">商品名称：<form:input cssClass="wid80" path="goodsname"/></li>
			<li class="btns">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
				<input id="btnAdd" class="btn btn-primary" type="button" value="添加商品" onclick="toadd()" />
			</li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th width="120px">缩略图</th>
				<th width="130px">商品名称</th>
				<th width="100px">面料</th>
				<th width="70px">风格</th>
				<th width="70px">颜色</th>
				<th width="70px">工艺</th>
				<th width="70px">排序</th>
				<th width="70px">状态</th>
				<th width="120px">创建时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tGoods">
			<tr>
				<td><img alt="" style="width: 110px;height: 70px" src="${tGoods.image }"> </td>
				<td>${tGoods.goodsname }</td>
				<td>${tGoods.fabric }</td>
				<td>${tGoods.style }</td>
				<td>${tGoods.color }</td>
				<td>${tGoods.technology }</td>
				<td>${tGoods.sort }</td>
				<td>
					<c:if test="${tGoods.state=='1' }">上架中</c:if>
					<c:if test="${tGoods.state=='2' }">已下架</c:if>
				</td>
				<td><fmt:formatDate value="${tGoods.createtime }" type="both" /> </td>
				<td>
					<c:if test="${tGoods.state=='1' }">
						<a href="${ctx}/tgoods/tGoods/updateState?goodsid=${tGoods.goodsid}&state=2">下架</a>
					</c:if>
					<c:if test="${tGoods.state=='2' }">
						<a href="${ctx}/tgoods/tGoods/updateState?goodsid=${tGoods.goodsid}&state=1">上架</a>
					</c:if>
				
    				<a href="${ctx}/tgoods/tGoods/form?goodsid=${tGoods.goodsid}">修改</a>
					<a href="${ctx}/tgoods/tGoods/updateState?goodsid=${tGoods.goodsid}&state=3" onclick="return confirmx('确认要删除该商品吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
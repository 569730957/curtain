<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>商品管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript" charset="utf-8" src="${ctxStatic }/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctxStatic }/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${ctxStatic }/ueditor/lang/zh-cn/zh-cn.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
	<style type="text/css">
		.wid80{width: 100px}
	</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="#">商品修改</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tGoods" action="${ctx}/tgoods/tGoods/save" method="post" class="form-horizontal">
		<form:hidden path="goodsid"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">商品名称：</label>
			<div class="controls">
				<form:input path="goodsname" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">商品大图：</label>
			<div class="controls">
				<input type="hidden" id="image" name="image" value="${tGoods.image}"/>
				<sys:ckfinder input="image" type="thumb" uploadPath="/myimg" selectMultiple="false"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">面料：</label>
			<div class="controls">
				<select name="fabric" class="wid80">
					<c:forEach items="${listFabric }" var="f">
						<option value="${f.dicvalue }" <c:if test="${f.dicvalue==tGoods.fabric }">selected</c:if> >${f.dicname}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">风格：</label>
			<div class="controls">
				<select name="style" class="wid80">
					<c:forEach items="${listStyle }" var="f">
						<option value="${f.dicvalue }" <c:if test="${f.dicvalue==tGoods.style }">selected</c:if>>${f.dicname}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">颜色：</label>
			<div class="controls">
				<select name="color" class="wid80">
					<c:forEach items="${listColor }" var="f">
						<option value="${f.dicvalue }" <c:if test="${f.dicvalue==tGoods.color }">selected</c:if>>${f.dicname}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工艺：</label>
			<div class="controls">
				<select name="technology" class="wid80">
					<c:forEach items="${listTechnology }" var="f">
						<option value="${f.dicvalue }" <c:if test="${f.dicvalue==tGoods.technology }">selected</c:if>>${f.dicname}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属类目：</label>
			<div class="controls">
				${str }
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图文详情：</label>
			<div class="controls">
				<script id="editor" type="text/plain"></script>
				<input type="hidden" id="goodsdetail" name="goodsdetail" value="${tGoods.goodsdetail }" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序：</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" cssClass="wid80" maxlength="3" class="input-xlarge number"/>
				(数字越小，商品显示越靠前)
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="button" onclick="sub()" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
	
	<script type="text/javascript">
		$(document).ready(function(){
	    	var ue = UE.getEditor('editor',{
	    		initialFrameWidth: 690,
	            initialFrameHeight:350
	    	});
	    	//文本编辑器页面加载内容初始化
	    	setTimeout(function(){
	    		var html=$("#goodsdetail").val();
	    		UE.getEditor('editor').setContent(html);
	    	},800);
	    	
		});
		function sub(){
			//获取文本编辑器的内容，设置到hidden
			var html=UE.getEditor('editor').getContent();
			$("#goodsdetail").val(html);
			$("#inputForm").submit();
		}
	</script>
	
</body>
</html>
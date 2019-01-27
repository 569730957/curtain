<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>字典管理管理</title>
	<meta name="decorator" content="default"/>
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
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/tdic/tDic/form?id=${tDic.dicid}">属性${not empty tDic.id?'修改':'添加'}</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="tDic" action="${ctx}/tdic/tDic/save" method="post" class="form-horizontal">
		<form:hidden path="dicid"/>
		<sys:message content="${message}"/>		
		
		<div class="control-group">
			<label class="control-label">属性类型：</label>
			<div class="controls">
				<form:select path="dictype">
					<form:option value="style">风格分类</form:option>
					<form:option value="color">颜色分类</form:option>
					<form:option value="fabric">面料分类</form:option>
					<form:option value="technology">工艺分类</form:option>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">属性值名称：</label>
			<div class="controls">
				<form:input path="dicname" htmlEscape="false" maxlength="20" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">属性值：</label>
			<div class="controls">
				<form:input path="dicvalue" htmlEscape="false" maxlength="2" class="input-xlarge number"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序：</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" maxlength="2" class="input-xlarge number"/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
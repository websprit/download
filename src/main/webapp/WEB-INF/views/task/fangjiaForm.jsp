<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>学费计算</title>
	
	<script>
		$(document).ready(function() {

		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/task/${action}" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>学费计算</small></legend>
			<div class="control-group">
				<label for="task_title" class="control-label">幼儿园:</label>
					<div class="controls">
					<input type="text" id="task_title" name="youeryuan"  value="${youeryuan}" class="input-large required" minlength="3"/>年
				</div>
			
				<label for="task_title" class="control-label">小学:</label>
				<div class="controls">
					<input type="text" id="task_title" name="xiaoxue"  value="${xiaoxue}" class="input-large required" minlength="3"/>年
				</div>
				<label for="task_title" class="control-label">中学:</label>
				<div class="controls">
					<input type="text" id="task_title" name="zhongxue"  value="${zhongxue}" class="input-large required" minlength="3"/>%
				</div>
				
					</div>
				<label for="task_title" class="control-label">高中:</label>
				<div class="controls">
					<input type="text" id="task_title" name="gaozhong"  value="${gaozhong}" class="input-large required" minlength="3"/>%
				</div>
					</div>
				<label for="task_title" class="control-label">大学:</label>
				<div class="controls">
					<input type="text" id="task_title" name="daxue"  value="${daxue}" class="input-large required" minlength="3"/>%
				</div>
			</div>	
			<div class="control-group">
			</div>	
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>曲线图</title>
	
	<script type="text/javascript">
			$(function(){
				var data = [
				<c:forEach items="${datas}" var="data">
				{name : '${data.name}',value : ${data.value},color:'${data.color}'},
				</c:forEach>
		        	];
	        	
				new iChart.Bar2D({
					render : 'canvasDiv',
					background_color : 'white',
					data: data,
					title : '中国经济风险变化表',
					subtitle : false,
					footnote : '数据来源：中国经济',
					width : 1024,
					height : 600,
					coordinate:{
						width:800,
						height:360,
						axis:{
							width:[0,0,1,1]
						},
						scale:[{
							 position:'bottom',	
							 start_scale:0,
							 end_scale:1,
							 scale_space:6
						}]
					},
					animation:true,
					rectangle:{
						listeners:{
							drawText:function(r,t){
								return t+"%";
							}
						}
					},
					legend:{enable:false}
				}).draw();
			});
		</script>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div id='canvasDiv'></div>
</body>
</html>

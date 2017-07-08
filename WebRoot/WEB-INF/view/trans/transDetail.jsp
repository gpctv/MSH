<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resource/css/reset.css" rel="stylesheet" type="text/css" />
<link href="resource/css/metro/blue/jtable.min.css" rel="stylesheet" type="text/css" />
<link href="resource/css/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/bootstrap.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/bootstrap-theme.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/font-awesome.min.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/bootstrap-datepicker.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
var CONTEXT_PATH='${pageContext.request.contextPath}';
</script>
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script type="text/javascript" src="resource/js/jquery-ui-1.10.4.custom.js"></script><script type="text/javascript" src="resource/js/jquery.jtable.js"></script>
<script type="text/javascript" src="resource/js/jquery.jtable.min.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resource/js/jquery.jtable.zh-CN.js"></script>
<script type="text/javascript" src="resource/js/comma.js"></script>
<script type="text/javascript" src="resource/js/trans/transDetail.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>交易明細</title>
</head>
<body>
<div class="container">
		
		<div class="row" style="width: 70%; margin: 0 auto;">
			<div id="PersonTableContainer"></div>
			<div id="sum"></div>
		</div>
		
	</div>
	
	<div style="display:none" id="id"><s:property value="%{#parameters.id}" /></div>

</body>
</html>
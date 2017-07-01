<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="resource/js/trans/trans.js"></script>
<script type="text/javascript" src="resource/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="resource/js/locales/bootstrap-datepicker.zh-TW.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>交易紀錄查詢</title>
</head>
<body>
<form action="" method="post">
<div class="container">
<div class="row" style="width: 50%; margin: 0 auto;">
			<table class=" table">
				<tr>
					<td>查詢</td>
					<td><div class="input-daterange input-group" id="datepicker">
							<input id="sDate" type="text" class="input-sm form-control inputDate" name="startDate" />
							<span class="input-group-addon">to</span> <input type="text"
								class="input-sm form-control inputDate" name="endDate" id="eDate" />
						</div></td>
				</tr>
				<tr>
					<td><button id="search" type="button" class="btn btn-primary">查詢</button></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<br>
		<div class="row">交易金額:</div>
 <div class="row" style="width: 70% ; margin:0 auto;"  >
 <div id="PersonTableContainer"></div>
</div>
</div>
</form>
</body>
</html>
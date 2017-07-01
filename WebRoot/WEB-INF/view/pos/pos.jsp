<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resource/css/reset.css" rel="stylesheet" type="text/css" />
<link href="resource/css/bootstrap.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/bootstrap-theme.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/pos/pos.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css"></link>
<link href="resource/css/font-awesome.min.css" rel="stylesheet" type="text/css"></link>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
var CONTEXT_PATH='${pageContext.request.contextPath}';
</script>
 <title>POS DEMO</title>
<script type="text/javascript" src="resource/js/jquery.js"></script>
<script type="text/javascript" src="resource/js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="resource/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resource/js/jqPaginator.js"></script>
<script type="text/javascript" src="resource/js/jGridView.js"></script>
<script type="text/javascript" src="resource/js/comma.js"></script>
<script type="text/javascript" src="resource/js/pos/pos.js"></script>

<title>MSH</title>
</head>
<body>
<div class="container">
	<div class="row" id="postMessage" style="display:none">
    <div id="messageStyle" class="col-md-12 alert alert-success text-center"> <strong id="message">Success!</strong> </div>    
    </div>
    <div class="row" id="postMessage2" style="display:none">
    <div id="messageStyle" class="col-md-12 alert alert-danger text-center"> <strong id="message">error!</strong> </div>    
    </div>
<div class="row">
<div class="col-md-4"> 
    <table id="list" class="table table-hover table-bordered table table-striped">
    <thead>
      <tr>
        <th>品項</th> 
        <th>金額</th>
      </tr>
    </thead>
    <tbody> 
    </tbody>
    </table>
</div>
<div class="col-md-8">
    <p  id="calMessage" style="word-wrap: break-word;"><b id="itemMessage3"></b></p>  
    <br><p  id="calMessage" style="word-wrap: break-word;"><b>總額:</b><b id="itemMessage"></b></p>
    <br><p  id="calMessage" style="word-wrap: break-word;"><b id="itemMessage2"></b></p>
    <!-- pos key food -->
    <table class="table table-striped">
    <s:iterator value="itemKeys" var="item1" status="num">
    	<s:if test="#num.first">
    	<tr>
    	</s:if>
    	<td>
        <button itemId="<s:property value="#item1.idItem"/>"  keyId="item<s:property value="#item1.idItem"/>" value="<s:property value="#item1.amountItem"/>" class="posKey btn btn-default">
			<s:property value="#item1.nameItem"/>
        </button>
         </td>
         <s:if test="%{((#num.index+1) % 6) == 0}">
         <tr> 
    	</s:if>
        <s:if test="#num.last">
        </tr>
        </s:if> 
    </s:iterator>
    <!-- pos key discount -->
    <s:iterator value="discountKeys" var="discount" status="num">
    <s:if test="#num.first">
    	<tr>
    	</s:if>
    	<td>
    	<button disName="" disId="<s:property value="#discount.idDiscount"/>"  keyId="discount<s:property value="#discount.idDiscount"/>" value="<s:property value="#discount.amountDiscount"/>" name="discount" class="posKey3 btn btn-default">
			<s:property value="#discount.nameDiscount"/>
        </button>
         </td>
         <s:if test="%{((#num.index+1) % 6) == 0}">
         <tr> 
    	</s:if>
        <s:if test="#num.last">
        </tr>
        </s:if> 
    </s:iterator>
    <tr>
        <td><button value="disappear" name="disappear" class="posKey3 btn btn-default">消除</button></td>
        <td><button value="result" name="result" class="posKey3 btn btn-default">結帳</button></td>
        <td><button value="clearAll" name="clearAll"class="posKey3 btn btn-default">clear All</button></td> 
    </tr> 
    </table>
    <div style="width:70%">
    <table class="table table-striped" >
    <tr>	
        <td ><button value='1' class="posKey2 btn btn-default">1</button></td>
        <td><button value='2' class="posKey2 btn btn-default">2</button>
        <td><button value='3' class="posKey2 btn btn-default">3</button> 
        <td><button value="less" name="less" class="posKey2 btn btn-default">－(減金額)</button></td> 
    </tr> 
    <tr>
        <td ><button value='4' class="posKey2 btn btn-default">4</button></td>
        <td><button value='5' class="posKey2 btn btn-default">5</button>
        <td><button value='6' class="posKey2 btn btn-default">6</button>
        <td><button value="mulipt" name="mulipt" class="posKey2 btn btn-default">數量</button></td>   
    </tr> 
    <tr>
        <td ><button value='7' class="posKey2 btn btn-default">7</button></td>
        <td><button value='8' class="posKey2 btn btn-default">8</button>
        <td><button value='9' class="posKey2 btn btn-default">9</button>
        <td><button value="ce" name="ce" class="posKey2 btn btn-default">CE</button></td>   
    </tr> 
    <tr>
        <td><button value='0' class="posKey2 btn btn-default">0</button></td> 
        <td colspan="3"><button value='sure' name='sure' class="posKey2 btn btn-default">確定</button>  
    </tr> 
    </table> 
    </div>
</div>	
<div style="visibility:hidden" id="disNum" disId="0" disname="無">
1
</div>

</div>
</div>
</body>
</html>
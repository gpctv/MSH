$(document).ready(function(){
	//數字鍵盤disable
	 //功能鍵盤 disable
	permissionGroup(true, false, false);
	posKey(); 
});


function posKey(){ 
	var total=0;//總金額   
	var numKey='';//數字鍵 
	var posKey3='';//posKey3
	var keyId='';//FOOD 鍵
	var selectItem='';//選擇
	$('#itemMessage').text(0);
	$('.posKey').click(function(i){
		$('#itemMessage3').text('');
		permissionGroup(true, false, true);
		permission(true, true, false, false, true, true,false);
		
		$('#itemMessage2').text($(this).text());
		posType='posKey'; 
		var repeat=0;
		keyId=$(this).attr('keyId');  
		
		//相同ID等於相同品項，REPEAT+1
		$('#list tbody > tr').each(function(e,tr){
			 if($(tr).attr('id')== keyId){
				 repeat=repeat+1;
			 }
		});
		//品項和金額SHOW 至LIST
		//大於零表示有相同品項 
		if(repeat>0){//重複分類
			var num=parseInt($('#'+$(this).attr('keyId')).attr('num'))+1;
			var amount=0;//小計總金額
			
			$('#'+$(this).attr('keyId')).attr('num',num);//設定數量
			amount=$(this).val()*num;
			$('#'+$(this).attr('keyId')).attr('amount',amount);//設定小記金額
			$('#'+$(this).attr('keyId')).html('<td>'+$(this).text()+'</td><td>'
					+'$'+$(this).val()+'('+num+')='+amount+'</td>');//設定文字amount
			
		}else{//未重複新增
			$('#list tbody').append('<tr itemId="'+$(this).attr('itemId')+'" class="listItem" id="'+$(this).attr('keyId')+'" num="1" amount="'+$(this).val()+'"><td>'
					+$(this).text()+'</td><td>'
					+'$'+$(this).val()+''
					+'</td></tr>');
		}
		//計算總金額
		total=reCal();//parseFloat($(this).val())+parseFloat(total);
		//把累加品項和總金額顯示MESSAGE
		$('#itemMessage').text(total);
	});
	 
	$('.posKey3').click(function(){ 
		//折扣鍵
		if($(this).attr('name')=='discount'){ 

			$('.listItem').removeAttr('style');//listItem 移掉
			 $('[list="listItem"]').removeAttr('style')//減項移掉
			 
			var tempAmount=0;
			var cAmount=0; 
			$('#list tbody > tr').each(function(e,tr){
				 tempAmount=tempAmount+ parseFloat($(tr).attr('amount'));
			 });
			$('#itemMessage2').text('');
			if($(this).hasClass('btn-info')){
				 $(this).removeClass("btn-info");
				$('#itemMessage3').text('');//設定顯示計算式
				 $('#itemMessage').text(tempAmount);//設定顯示TOTAL
				 total=tempAmount;//將計算結果 給全域變數
				 posKey3='';
				 //折扣乘1
				 $('#disNum').text('1');
				 $('#disNum').attr('disId','');
				 $('#disNum').attr('disName','');
				 permissionGroup(true,false, true);
				 permission(true, false, false, false, true, true, false);
				
			}else{
				 $('[name="discount"]').removeClass('btn-info');
				 $(this).addClass("btn-info");
				
				 var di=parseFloat($(this).val());//抓折扣值
				 var di2=1-di;//要顯示的折扣值
				 cAmount=Math.round(tempAmount*(1-di));//計算折扣後金額
				 $('#itemMessage3').text(tempAmount+'x'+di2+'='+cAmount);//設定顯示計算式
				 $('#itemMessage').text(cAmount);//設定顯示TOTAL
				 total=cAmount;//將計算結果 給全域變數
				 //減鍵結帳全部清除開其餘關
				 permissionGroup(false,false, true);
				 permission(false, false, false, false, true, true, false);
				 $('#disNum').text(di2);
				 $('#disNum').attr('disId',$(this).attr('disId'));
				 $('#disNum').attr('disName',$(this).text());
				 posKey3='discount';
			}
			
			
		}
		//消除鍵 
		if($(this).attr('name')=='disappear'){
			if($(this).hasClass('btn-info')){
				$(this).removeClass("btn-info");
				posKey3='';
				//數字鍵盤 disable
				//計算鍵盤ENABLE
				//確定鍵DISABLE
				permissionGroup(true,false, true);
				permission(true, false, false, false, true, true,false);
				$('#'+selectItem).removeAttr('style');
				$('#itemMessage2').text('');//ITEM 顯示消除
				
			}else{
			$(this).addClass("btn-info");
			posKey3='disappear';
			$('#itemMessage2').text($('#'+selectItem).find("td:eq(0)").text()+'-');
			permissionGroup(true,true, false);
			permission(false, false, true, true, false, false, false); 
			
		}
		}
		//結帳
		if($(this).attr('name')=='result'){
			$('.listItem').removeAttr('style');//listItem 移掉
			 $('[list="listItem"]').removeAttr('style')//減項移掉
			 
			if($(this).hasClass('btn-info')){
				permissionGroup(true,false,true);
				permission(true,true, false, false, true, true, false);
				$(this).removeClass("btn-info");
				posKey3='';
				numKey='';
				$('#itemMessage2').text('');
			}else{
				$(this).addClass("btn-info");
				permissionGroup(false,true,false);
				permission(false,false, true, false, true, false, true);
				posKey3='result';
				$('#itemMessage2').text('客人給:');
			}
			
		}
		//CLEAR ALL
		if($(this).attr('name')=='clearAll'){ 
			 total=0;//總金額   
			 numKey='';//數字鍵 
			 posKey3='';//posKey3
			 keyId='';//FOOD 鍵
			 selectItem='';//選擇
			 permissionGroup(true,false, false);
			 $('#list tbody').empty();
			 $('#itemMessage3').text('');
			 $('#itemMessage2').text(''); 
			 $('#itemMessage').text(reCal());
			 $('#postMessage').css('visibility','hidden');
			 $('[name="discount"]').removeClass('btn-info');
			 $('#disNum').text('1');//折扣預設為1
				$('.listItem').removeAttr('style');//listItem 移掉
				 $('[list="listItem"]').removeAttr('style')//減項移掉
				 
		}
	 
	});
	//數字鍵盤
	$('.posKey2').click(function(){
		
		 switch($(this).val()){
		 case '1':
			 
			 numKey=numKey+1;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+1);
				 permission(false, true, false, false, false, false, true); 
				 
			 }

			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+1);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+1);
				 permission(false, false, true, true, false, false, true); 
				  
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+1 );
			 }
			 
			  break;
		 case '2':
			 numKey=numKey+2;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+2);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+2);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+2);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+2 );
			 }
			 break;
		 case '3':
			 numKey=numKey+3;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+3);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+3);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+3);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+3 );
			 }
			 break;
		 case '4':
			 numKey=numKey+4;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+4);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+4);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+4);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+4 );
			 }
			 break;
		 case '5':
			 numKey=numKey+5;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+5);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+5);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+5);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+5 );
			 }
			 break;
		 case '6':
			 numKey=numKey+6;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+6);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+6);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+6);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+6 );
			 }
			 break;
		 case '7':
			 numKey=numKey+7;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+7);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+7);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+71);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+7 );
			 }
			 break;
		 case '8':
			 numKey=numKey+8;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+8);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+8);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+8);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+8 );
			 }
			 break;
		 case '9':
			 numKey=numKey+9;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+9);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+9);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+9);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+9 );
			 }
			 break;
		 case '0':
			 numKey=numKey+0;
			 if(posKey3=='mulipt'){
				 $('#itemMessage2').text($('#itemMessage2').text()+0);
				 permission(false, true, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='less'){
				 $('#itemMessage').text($('#itemMessage').text()+0);
				 permission(true, false, false, false, false, false, true); 
				 
			 }
			 if(posKey3=='disappear'){
				 $('#itemMessage2').text($('#itemMessage2').text()+0);
				 permission(false, false, true, true, false, false, true); 
				 
			 }
			 if(posKey3=='result'){
				 $('#itemMessage2').text($('#itemMessage2').text()+0 );
			 }
			 break;
		 case 'ce':
			 numKey='';
			 var foodName=$('#'+keyId).find("td:eq(0)").text();
			 if(posKey3=='mulipt'){
				 posKey3='';
				 $('[name="mulipt"]').removeClass("btn-info");
				 $('#itemMessage2').text(foodName);
			 }
			 if(posKey3=='disappear'){
				 posKey3='';
				 $('[name="disappear"]').removeClass("btn-info");
				 $('#itemMessage2').text(foodName);
				 $('#'+selectItem).removeAttr('style');
			 }
			 if(posKey3=='less'){
				 posKey3='';
				 $('[name="less"]').removeClass("btn-info");
				 $('#itemMessage').text(total);
			 }
			 if(posKey3=='result'){
				 posKey3='';
				 $('[name="result"]').removeClass("btn-info");
				 $('#itemMessage2').text('');
			 }
			 permissionGroup(true, false, true);
			 permission(true, true, false, false, true, true, false);
			 
			 break;
		 case 'less': 
			 if($(this).hasClass('btn-info')){
				 permissionGroup(true, false, true);
				 permission(true, true, true, false, true, true, false);
				 $(this).removeClass("btn-info");
				 posKey3='';
				 numKey='';
				 $('#itemMessage').text(total);
			 }else{
				 permissionGroup(true, true, false);
				 permission(true, false, true, false, false, false, false);
				
				 $(this).addClass("btn-info");
				 posKey3='less';
				 $('#itemMessage').text(total+'-');
			 }
			     
				 break;
		 case 'mulipt':
			 if($(this).hasClass('btn-info')){
				 permissionGroup(true, false, false);
				 permission(true, true, true, false, true, true, false);
				 
				 $(this).removeClass("btn-info");
				 posKey3='';
				 numKey='';
				 var foodName=$('#'+keyId).find("td:eq(0)").text();
				 $('#itemMessage2').text(foodName);
			 }else{
				 permissionGroup(true, true, false);
				 permission(true, true, true, false, false, false, false);
				
				 $(this).addClass("btn-info");
				 posKey3='mulipt';
				 var foodName=$('#'+keyId).find("td:eq(0)").text();
				 $('#itemMessage2').text(foodName+'x');
			 }
			
			  break;
		 case 'sure':
			 //LIST顏色移除
			 $('.listItem').removeAttr('style');//listItem 移掉
			 $('[list="listItem"]').removeAttr('style')//減項移掉
			 if(posKey3=='less'){
				 $('[name="less"]').removeClass('btn-info');//取消反白
				 total=total-parseInt(numKey); 
				 $('#itemMessage').text(total);
				 $('#list tbody').append('<tr id="less1" class="text-danger" num="1" list="listItem" amount="-'+numKey+'"><td>'
							+'減'+'</td><td>'
							 +'$-'+numKey
							+'</td></tr>'); 
				 numKey='';//計算結果後歸零
				 
				 permissionGroup(true, false, true);
				 permission(true, false, false, false, true, true, false);
				
			 }
			 if(posKey3=='mulipt'){
				 $('[name="mulipt"]').removeClass('btn-info');//取消反白
				var num=numKey;
				num=parseInt($('#'+keyId).attr('num'))+(parseInt(num)-1);//原本數量+X的數量
				var amount=$('[keyid="'+keyId+'"]').val()*parseInt(num);//數量*單價
				$('#'+keyId).attr('amount',amount);//設定小記金額
				
				$('#'+keyId).attr('num',num);
				$('#'+keyId).html('<td>'+$('#'+keyId).find("td:eq(0)").text()+'</td><td>'
						+'$'+$('[keyId="'+keyId+'"]').val()+'('+num+')='+amount+'</td>');//設定文字amount
				numKey='';//計算結果後歸零
				 //重新計算總TOTAL
				total=reCal();
				$('#itemMessage').text(total);
				$('#itemMessage2').text('');
				 permissionGroup(true, false, true);
				 permission(true, false, false, false, true, true, false);
				 
			 }
			 if(posKey3=='disappear'){
				 $('[name="disappear"]').removeClass('btn-info');
				 var num=numKey;
				 num= parseInt($('#'+selectItem).attr('num'))-parseInt(num);//原本數量減要減數量
				 var amount=0;
				 
				 if(num<1){
					 amount=0;
					 $('#'+selectItem).remove();
					 
				 }else{
					 amount=$('[keyid="'+selectItem+'"]').val()*parseInt(num);//數量*單價
					 $('#'+selectItem).attr('amount',amount);//設定小記金額
						
						$('#'+selectItem).attr('num',num);
						$('#'+selectItem).html('<td>'+$('#'+keyId).find("td:eq(0)").text()+'</td><td>'
								+'$'+$('[keyId="'+keyId+'"]').val()+'('+num+')='+amount+'</td>');//設定文字amount				
				 }
				 numKey='';//計算結果後歸零
				 total=reCal();
				 $('#itemMessage').text(total);
					$('#itemMessage2').text('');
					permissionGroup(true, false, true);
					 permission(true, false, false, false, true, true, false);
				//當LIST都沒有按一下CLEAR ALL鍵
			   if(reRow()==0){
				$('[name="clearAll"]').click();	
				}
			   
			 }
			 if(posKey3=='result'){
				 $('[name="result"]').removeClass('btn-info');
				 var num=numKey; //客人給的金額 
				 var totalAmount=parseFloat($('#itemMessage').text());//消費金額
				 var extraDollar=num-totalAmount;
				 if(sendToServer()){
					 $('#itemMessage2').text('資料上傳成功');
					 $('#postMessage').removeAttr('style');
				 }
				 if(extraDollar<=0){
				  $('#itemMessage3').html('<p style="color:red;">'+extraDollar+'</p>');
				 }else{
				 $('#itemMessage3').text('應找'+extraDollar+'元');
				 } 
				 permissionGroup(false,false,false);
				 permission(false,false,false,false,false,true,false);
			 }
			  posKey3="";
			 break;
		 }
	}) ; 
	//點選LIST ITEM時
	$('#list').on("click", "tr", function(e) {
		if(posKey3=='result'||posKey3=='discount'||posKey3=='less'||posKey3=='mulipt'||posKey3=='disappear' ){
			//$('#list').prop('disabled',true);
		}else{
		 if(jQuery.isEmptyObject($(this).attr('style'))){
			 $('[name="disappear"]').prop('disabled',false);
			 $('.listItem').removeAttr('style');//listItem 移掉
			 $('[list="listItem"]').removeAttr('style')//減項移掉
			 $(this).attr('style','background-color:#b0c4de;'); 
			 selectItem=$(this).attr('id');
		 }else{
			 $('[name="disappear"]').prop('disabled',true);
			 $(this).removeAttr('style');
			 selectItem='';
		 }
		}
 
	});
	 
}
/**
 * 計算總額
 * @returns {Number}
 */
function reCal(){
	
	var tempTotal=0;
	var discount=parseFloat($('#disNum').text());
	$('#list tbody > tr').each(function(e,tr){
		 
		var amount=$(tr).attr('amount'); 
		tempTotal=tempTotal+parseInt(amount);
	});
	return Math.round(tempTotal*discount);
	
}

function reRow(){
	var rowNum=$('#list > tbody > tr').length;
	return rowNum;
	
}
/**
 * 傳至SERVER
 * @returns {Boolean}
 */
function sendToServer(){
	var items=calResult();
	var less=calLess();
	var discount=[];
	discount.push({
			nameSalesdiscount:$('#disNum').attr('disname'),
			amountSalesdiscount:$('#disNum').text(),
			idSalesdiscount:$('#disNum').attr('disid'),
			receiptnoSalesdiscount:''
	});
 
	console.log(items);
	console.log(less);
	console.log(discount);
	var ob={salesItemList:items,discountList:discount,lessList:less};
	console.log(JSON.stringify(ob ));
	$.ajax({
	    url: CONTEXT_PATH+"/posRest",
	    data:  JSON.stringify(ob ),
	    contentType: "application/json; charset=utf-8",
	    type: 'POST',
	    dataType: 'json',
	    success: function (res) {
	         console.log('success');
	    }
	});
	return true;
}

/**
 * 設定可以按的權限
 * @param posKey2
 * @param posKey3
 * @param less
 * @param mulipt
 * @param ce
 * @param disappear
 * @param result
 * @param clearAll
 */
function permission(less,mulipt,ce,disappear,result,clearAll,sure){
	$('[name="less"]').prop('disabled',!less);
	$('[name="mulipt"]').prop('disabled',!mulipt);
	$('[name="ce"]').prop('disabled',!ce);
	$('[name="disappear"]').prop('disabled',!disappear);
	$('[name="result"]').prop('disabled',!result);
	$('[name="clearAll"]').prop('disabled',!clearAll); 
	$('[name="sure"]').prop('disabled',!sure);
}
/**
 * 全組鍵PERMISSION
 * @param posKey
 * @param posKey2
 * @param posKey3
 */

function permissionGroup(posKey,posKey2,poskey3){
	$('.posKey').prop('disabled',!posKey);//food鍵盤disable
	$('.posKey2').prop('disabled',!posKey2);//數字鍵盤disable
	$('.posKey3').prop('disabled',!poskey3);//功能鍵盤 disable
	
}
 /**
  * 抓取本筆結帳資料
  */
function calResult(){
	var items=[]; 
	
	$('#list  tbody > tr').each(function(e,tr){
		 if($(tr).attr('id').includes('item')){
			items.push({
				idSalesitem:$(tr).attr('itemid'),
				itemSalesitem:$(tr).find('td:eq(0)').text(),
				countSalesitem:$(tr).attr('num'),
				amountSalesitem:$(tr).attr('amount'),
				receiptnoSalesitem:''
			});
		}
		
	});
	 
	return items;
}
/**
 * 計算折讓
 * @returns {___anonymous19684_19692}
 */
function calLess(){
	var less=[];
	$('#list  tbody > tr').each(function(e,tr){
		console.log($(tr).attr('amount'));
		if($(tr).attr('id').includes('less')){
			less.push({
				idSalesdiscount:'0',
				amountSalesdiscount:$(tr).attr('amount'),
				nameSalesdiscount:'折讓',
				receiptnoSalesdiscount:''
			});
		}
		
	});
	return less;
}
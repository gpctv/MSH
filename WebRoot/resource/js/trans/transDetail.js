/**
 * 
 */
$(document).ready(function () {
	$('#PersonTableContainer').jtable({
		title:'transaction',
		selecting:true,
		actions:{
			listAction:function (postData, jtParams) {
				 return $.Deferred(function ($dfd) {
				
				$.ajax({
		            url: CONTEXT_PATH+'/transDetailRest?receiptNo='+$('#id').text(),
		            type: 'POST',
		            dataType: 'json',
		            success: function (data) {
		                $dfd.resolve(data);
		                $('#sum').html('<b>交易總金額:'+data.Sum+'</b>');
		            },
		            error: function () {
		                $dfd.reject();
		            }
		        });
				 });	 
			}
			},
		fields:{
			id:{
				title:'ID',
				key:true,
				list:false
			},
			receipt:{
				title:'發票',
				width:'30%'
			},
			name:{
				title:'品項',
				width:'30%'
			},
			amount:{
				title:'金額',
				width:'40%',
				display:function(data){
					var result=data.record.amount;
					return comma(result);
				}
			}  ,
			tranDate:{
				title:'日期',
				width:'40%'
			} 
		}
			
	});
	$('#PersonTableContainer').jtable('load');
});
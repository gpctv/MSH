/**
 * 
 */

$(document).ready(function () {
	$('.input-daterange').datepicker({
		language:"zh-TW",
		format: "yyyymmdd",
		todayBtn: true,
	    clearBtn: true,
	    todayHighlight: true,
	    endDate:"0d"
	    
	});
	clickSearch();
	$('#PersonTableContainer').jtable({
		title:'transaction',
		selecting:true,
		actions:{
			listAction:function (postData, jtParams) {
			    return $.Deferred(function ($dfd) {
			        $.ajax({
			            url: CONTEXT_PATH+"/transRest?sDate="+$('#sDate').val()+'&eDate='+$('#eDate').val(),
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
			receiptnoTrans:{
				title:'ID',
				key:true,
				list:true,
				display:function(d){
					return '<a href="'+CONTEXT_PATH+'/transDetail?id='+d.record.receiptnoTrans+'" target="_blank">'+d.record.receiptnoTrans+'</a>';
				}
			},
			dateTrans:{
				title:'日期',
				width:'30%'
			},
			amountTrans:{
				title:'金額',
				width:'40%',
				display:function(data){
					var result=data.record.amountTrans;
					return comma(result); 
				}
			} 
		}
			
	});
	$('#PersonTableContainer').jtable('load');
});


function getToday(){
	var d = new Date();

	var month = d.getMonth()+1;
	var day = d.getDate();

	var output = d.getFullYear() + '/' +
	(month<10 ? '0' : '') + month + '/' +
	(day<10 ? '0' : '') + day;
	return output;
}

function clickSearch(){
	$('#search').click(function(){
		$('#PersonTableContainer').jtable('load');
	});
}
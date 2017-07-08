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
	$('#sDate').val( getToday() );
	$('#eDate').val( getToday() );
	clickSearch();
	
	 $('#PersonTableContainer').jtable({
		title:'銷售品項統計',
		actions:{
			listAction:function (postData, jtParams) {
			    return $.Deferred(function ($dfd) {
			        $.ajax({
			            url: CONTEXT_PATH+"/salesItemRest?sDate="+$('#sDate').val()+'&eDate='+$('#eDate').val(),
			            type: 'POST',
			            dataType: 'json',
			            success: function (data) {
			                $dfd.resolve(data);
			                 
			            },
			            error: function () {
			                $dfd.reject();
			            }
			        });
			    });
			}
		},
		fields:{
			row:{
				 key: true,
                 list: false
			 },
			 idSales:{
				 title:'品項編號',
				 width:'40%'
			 },
			 nameItem:{
				title:'品項',
				width:'40%'
			},
			num:{
				title:'數量',
				width:'20%'
			}
		}
		 
		 
	 });
	
	 $('#PersonTableContainer').jtable('load');
});


function getToday(){
	var d = new Date();

	var month = d.getMonth()+1;
	var day = d.getDate();

	var output = d.getFullYear()  +
	(month<10 ? '0' : '') + month  +
	(day<10 ? '0' : '') + day;
	return output;
}
function clickSearch(){
	$('#search').click(function(){
		$('#PersonTableContainer').jtable('load');
	});
}
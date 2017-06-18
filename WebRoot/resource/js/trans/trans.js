/**
 * 
 */

$(document).ready(function () {
	$('.input-daterange').datepicker({
		language:"zh-TW",
		format: "yyyy/mm/dd",
		todayBtn: true,
	    clearBtn: true,
	    todayHighlight: true,
	    endDate:"0d"
	    
	});
	
	$('#PersonTableContainer').jtable({
		title:'transaction',
		selecting:true,
		actions:{
			listAction:CONTEXT_PATH+'/transRest'
		},
		fields:{
			id:{
				title:'ID',
				key:true,
				list:true,
				display:function(d){
					return '<a href="/Struts2Test/transDetail?id='+d.record.id+'" target="_blank">'+d.record.id+'</a>'
				}
			},
			date:{
				title:'日期',
				width:'30%'
			},
			amount:{
				title:'金額',
				width:'40%',
				display:function(data){
					var result=data.record.amount;
					return comma(result); 
				}
			} 
		}
			
	});
	$('#PersonTableContainer').jtable('load');
});
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
		title:'Daily sales ',
		actions:{
			listAction:CONTEXT_PATH+'/dailySalesRest'
		},
		fields:{
			 id:{
				 key: true,
                 list: false
			 },
			itemName:{
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
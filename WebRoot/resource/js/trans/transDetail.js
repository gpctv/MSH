/**
 * 
 */
$(document).ready(function () {
	$('#PersonTableContainer').jtable({
		title:'transaction',
		selecting:true,
		actions:{
			listAction:CONTEXT_PATH+'/transDetailRest?id='+$('#id').text()
		},
		fields:{
			id:{
				title:'ID',
				key:true,
				list:true,
				 
			},
			item:{
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
			date:{
				title:'日期',
				width:'40%'
			} 
		}
			
	});
	$('#PersonTableContainer').jtable('load');
});
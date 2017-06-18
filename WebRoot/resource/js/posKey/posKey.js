/**
 * 
 */

$(document).ready(function () {
	
	$('#PersonTableContainer').jtable({
		title:'MSH Poskey set',
		 //selecting: true, //Enable selecting
        //multiselect: true, //Allow multiple selecting
        selectingCheckboxes: true, //Show checkboxes on first column
		
        actions:{
			listAction:CONTEXT_PATH+"/poskeyQueryRest",
			createAction:CONTEXT_PATH+"/poskeyInsertRest",
			deleteAction:CONTEXT_PATH+"/poskeyDeleteRest"
		},
		fields:{
			 id:{
				 key: true,
                 list: false
			 },
			 title:{
				title:'名稱',
				width:'30%',
				 
			 
			},
			type:{
				title:'種類',
				width:'10%',
				options: { 'poskey':'food', 'poskey3':'discount' }
			},
			sales:{
				title:'銷售金額',
				width:'20%',
				display:function(data){
					var result=data.record.sales;
					return comma(result);
				}
			},
			discount:{
				title:'折扣比例',
				width:'20%'
			},
			enable:{
				type: 'checkbox',
				values: {'false': '目前disabled','true': '目前enable'   },
				title:'作用',
				width:'10%',
				display:function(data){
					var view;
					if(data.record.isEnable){
						view='<p>v</p>';
					}else{
						view='';
					}
					return view;
				}
			},
			selfId:{
				title:'自己的ID',
				list: false,
				edit:false,
				create:false
			},
			demo:{
				edit: false,
				create: false,
				title:'按鍵畫面',
				width:'20%',
				display:function(data){
					var disable='disable';
					if(data.record.isEnable){
						disable='';
					}else{
						disable='disabled';
					}
					var button=$('<button '+disable+'>'+data.record.title+'</button>');
					return button;
				}
			
			}
			
			
		},
		formCreated:function(e,data){
			keyNumOnly(data.form.find('input[name="sales"]'));
			keyNumOnly(data.form.find('input[name="discount"]'));
			data.form.find('input[name="sales"]').prop('disabled',false);
			data.form.find('input[name="discount"]').prop('disabled',true);
			 //data.form.find('input[name="enable"]').prop('checked',true);
			 data.form.find('input[name="enable"]').click();
			 
			 data.form.find('select[name="type"]').on('change',function(){
				if($(this).val()=='poskey') {
					data.form.find('input[name="sales"]').prop('disabled',false);
					data.form.find('input[name="discount"]').prop('disabled',true);
					data.form.find('input[name="discount"]').val('');
				}else{
					data.form.find('input[name="sales"]').prop('disabled',true);
					data.form.find('input[name="discount"]').prop('disabled',false);
					data.form.find('input[name="sales"]').val('');
				}
				 
			 });
		 
			
		},
		formSubmitting:function(e,data){ 
			
			var title=data.form.find('input[name="title"]') ;
			var sales=data.form.find('input[name="sales"]') ;
			var discount=data.form.find('input[name="discount"]') ;
			if(title.val()==''){
				alert('名稱未輸入');
			return false;
			}
			if(sales.is(':disabled')&&discount.val().trim()==''){
				alert('折扣比例未輸入');
				return false;
			}
			if(discount.is(':disabled')&&sales.val().trim()==''){
				alert('金額未輸入');
				return false;
			}
			return true;
		}
		
		 
		 
	 });
	
	 $('#PersonTableContainer').jtable('load');
	 
	
});

function keyNumOnly(id){
	id.on("keydown",function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A, Command+A
            (e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) || 
             // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        } 
	});
}
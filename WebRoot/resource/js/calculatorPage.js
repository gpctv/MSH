/**
 * 
 */
$(function(){ 
$('#calc').calculator({
			movable: true,
			resizable: true, 
			defaultOpen: false,
			width:200,
			height:350,
			buttonPressed:function(calc,button){
				console.log(calc);
				console.log(button);
			}
		});
$('#calc').show();
});
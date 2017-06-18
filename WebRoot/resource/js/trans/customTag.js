$(document).ready(function () {
	
	$.ajax({
   	 url: CONTEXT_PATH+"/posKeyRest",
         
        type:"POST",
        dataType:'json',

        success: function(msg){
       	  console.log(msg);
       	  createCustonSelect(msg);
        },

         error:function(){ 
            alert('customTag Error');  
         }
   }); 
	/**
	 * 新增自訂TAG 這裡以SELECT 為示範
	 * 
	 * @param data AJAX呼叫並帶入回傳值
	 * @returns
	 */
	function createCustonSelect(data){
		var CustomSelect = Object.create(HTMLElement.prototype);
		CustomSelect.createdCallback = function() { 
			
			var fdmClass=this.getAttribute('fdm-class');//抓屬性
			
			this.innerHTML="<select>"+
     	    "<option value="+data.Result+">"+data.Result+"</option>"
     	    +"<select>";
		}
		
		register(CustomSelect);
	}
	/**
	 * 註冊自訂物件 
	 * @param CustomSelect
	 * @returns
	 */
	function register(CustomSelect){
		if('registerElement' in document){
			var XProduct = document.registerElement('custom-select', {
			    prototype: CustomSelect
			});
		}else{
			console.log('error! no registerElement object');
		}
	// Register the new element.
	
	
	}
});
$("#getReceiver").click(function(){
	var text=$("#receiverNIC").val();
    $.post("get_customer",
    	    {
    	      nic:text
    	    },
    	    function(data){
    	     $("#receiver").html(data);
    	    });
  });
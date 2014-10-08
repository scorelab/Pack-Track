$("#getReceiver").click(function(){
	var text=$("#receiverNIC").val();
    $.post("get_receiver",
    	    {
    			receiver_nic:text
    	    },
    	    function(data){
    	     $("#receiver").html(data);
    	    });
  });
$("#getSender").click(function(){
	var text=$("#senderNIC").val();
    $.post("get_sender",
    	    {
    	      sender_nic:text
    	    },
    	    function(data){
    	     $("#sender").html(data);
    	    });
  });

function getSender(){
	var text=$("#senderNIC").val();
	if(text===""){
		return
	}
    $.post("get_sender",
    	    {
    	      sender_nic:text
    	    },
    	    function(data){
    	     $("#sender").html(data);
    	    });
}
function getReceiver(){
	var text=$("#receiverNIC").val();
	if(text===""){
		return
	}
    $.post("get_receiver",
    	    {
    	receiver_nic:text
    	    },
    	    function(data){
    	     $("#receiver").html(data);
    	    });
}
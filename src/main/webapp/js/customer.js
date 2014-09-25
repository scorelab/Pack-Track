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
$(document).ready(function() {

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
$(document).ready(function() {

});
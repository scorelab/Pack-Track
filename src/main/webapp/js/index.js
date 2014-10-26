$("#track").click(function(){
	var nic=$("#nic").val();
	var id=$("#id").val();
    $.post("track-parcel",
    	    {
    	      nic:nic,
    	      id:id
    	    },
    	    function(data){
    	     $("#track-result").html(data);
    	    });
  });
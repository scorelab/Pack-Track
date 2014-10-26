$("#select").click(function(event){
    event.preventDefault();
    var searchIDs = $("input:checkbox:checked").map(function(){
      return $(this).attr('id');
    }).get();
    if(searchIDs.length===0){
    	$("#errorMsg").css('display', 'auto');
    	return
    }
    var myJsonString = JSON.stringify(searchIDs);
    var train=$("#train").val();
    $.post("select-train",
    	    {
    			train:train,
    			parcels:myJsonString
    	    },
    	    function(data){
    	    	window.location.replace("select-train");
    	    });
    
});

// $("input:checkbox").check(function(event){
// alert("train");
// });


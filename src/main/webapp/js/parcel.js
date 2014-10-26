$("#btn").click(function(){
	var text=$("#searchText").val();
    $.post("parcel-search",
    	    {
    	      searchText:text
    	    },
    	    function(data){
    	     $("#result").html(data);
    	    });
  });

$("#searchText").keyup(function(event){
    if(event.keyCode == 13){
        $("#btn").click();
    }
});
$("#btn").click(function(){
	alert("sdfsd");
    $.post("parcel-search",
    	    {
    	      name:"Donald Duckpoo",
    	      city:"Duckburg"
    	    },
    	    function(data){
    	     $("#result").html("Data: " + data);
    	    });
  });
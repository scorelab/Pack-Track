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

function change() {
	var weight= document.getElementById("weight").value;
	var start= document.getElementById("start").value;
	var finish= document.getElementById("destination").value;
	var category= document.getElementById("categoryq").value;
	var express= document.getElementById("express").value;
	if(isNaN(parseFloat(weight))){   
		$("#cost").html("input error");
		return true;  
	} 
	if(weight===""){
		el2.html("0.0")
		return true;  
	}
	$.post("calculate-cost",
    	    {
    	      weight:weight,
    	      start:start,
    	      finish:finish,
    	      category:category,
    	      express:express
    	    },
    	    function(data){
    	     	$("#cost").html("<b>cost : "+data.cost+"</b>");
  });
}
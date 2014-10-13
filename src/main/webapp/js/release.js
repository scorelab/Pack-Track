$("#btn").click(function(){
	var text=$("#searchText").val();
    $.post("release-search",
    	    {
    	      searchText:text
    	    },
    	    function(data){
    	     $("#result").html(data);
    	    });
  });

$(document).on('click','.release',function() {
	var id = $(this).attr("name");
	var text='Are sure want to release '+id+' ?';
	$('<div title="Are you sure?"/>').html(text).dialog({
		buttons : {
			'Release' : function() {
				var form = $('<form action="release" method="post">'
						+ '<input type="text" name="id" value="' + id
						+ '" />' + '</form>');
				form.appendTo("body").submit();
				$(this).dialog('close');
			},
			'Cancel' : function() {
				$(this).dialog('close');
			}
		}
	});
});

$("#searchText").keyup(function(event){
    if(event.keyCode == 13){
        $("#btn").click();
    }
});
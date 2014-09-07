$(document).ready(function() {

	(function($) {

		$('#filter').keyup(function() {

			var rex = new RegExp($(this).val(), 'i');
			$('.searchable tr').hide();
			$('.searchable tr').filter(function() {
				return rex.test($(this).text());
			}).show();

		})

	}(jQuery));

});

$(".btn").mouseup(function() {
	$(this).blur();
});

$('.change').click(
		function() {
			var id = $(this).attr("name");
			var form = $('<form action="change_user" method="post">'
					+ '<input type="text" name="userName" value="' + id
					+ '" />' + '</form>');
			$(form).submit();
		});

$('.deletes').click(function() {
	alert("sdds");
	var id = $(this).attr("name");
	var text='Are sure want to delete '+id+' ?';
	$('<div title="Are you sure?"/>').html(text).dialog({
		buttons : {
			'Delete' : function() {
				$.ajax({
	                url: 'delete_user',
	                type: 'POST',
	                data: {'id':id}
	            });  
				$(this).dialog('close');
			},
			'Cancel' : function() {
				$(this).dialog('close');
			}
		}
	});
});
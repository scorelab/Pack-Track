$(document).ready(function() {

	(function($) {

		$('#filter').keyup(function() {

			var rex = new RegExp($(this).val(), 'i');
			$('.searchable tr').hide();
			$('.searchable tr').filter(function() {
				return rex.test($(this).text());
			}).show();

		});

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
			form.appendTo("body").submit();
		});

$('.deletes').click(function() {
	var id = $(this).attr("name");
	var text='Are sure want to delete '+id+' ?';
	$('<div title="Are you sure?"/>').html(text).dialog({
		buttons : {
			'Delete' : function() {
				var form = $('<form action="delete_user" method="post">'
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

$('.change_st').click(
		function() {
			var id = $(this).attr("name");
			var form = $('<form action="change_station" method="post">'
					+ '<input type="text" name="id" value="' + id
					+ '" />' + '</form>');
			form.appendTo("body").submit();
		});

$('.deletes_st').click(function() {
	var id = $(this).attr("name");
	var text='Are sure want to delete this station ?';
	$('<div title="Are you sure?"/>').html(text).dialog({
		buttons : {
			'Delete' : function() {
				var form = $('<form action="delete_station" method="post">'
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

$('.change_ca').click(
		function() {
			var id = $(this).attr("name");
			var form = $('<form action="change_category" method="post">'
					+ '<input type="text" name="id" value="' + id
					+ '" />' + '</form>');
			form.appendTo("body").submit();
		});

$('.deletes_ca').click(function() {
	var id = $(this).attr("name");
	var text='Are sure want to delete this Category ?';
	$('<div title="Are you sure?"/>').html(text).dialog({
		buttons : {
			'Delete' : function() {
				var form = $('<form action="delete_category" method="post">'
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

$('.change_di').click(
		function() {
			var id = $(this).attr("name");
			var form = $('<form action="change_device" method="post">'
					+ '<input type="text" name="id" value="' + id
					+ '" />' + '</form>');
			form.appendTo("body").submit();
		});

$('.deletes_di').click(function() {
	var id = $(this).attr("name");
	var text='Are sure want to delete this Device ?';
	$('<div title="Are you sure?"/>').html(text).dialog({
		buttons : {
			'Delete' : function() {
				var form = $('<form action="delete_device" method="post">'
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

$('.change_tr').click(
		function() {
			var id = $(this).attr("name");
			var form = $('<form action="change_train" method="post">'
					+ '<input type="text" name="id" value="' + id
					+ '" />' + '</form>');
			form.appendTo("body").submit();
		});

$('.deletes_tr').click(function() {
	var id = $(this).attr("name");
	var text='Are sure want to delete this Device ?';
	$('<div title="Are you sure?"/>').html(text).dialog({
		buttons : {
			'Delete' : function() {
				var form = $('<form action="delete_train" method="post">'
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
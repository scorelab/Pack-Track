$(document).ready(function () {

    (function ($) {

        $('#filter').keyup(function () {

            var rex = new RegExp($(this).val(), 'i');
            $('.searchable tr').hide();
            $('.searchable tr').filter(function () {
                return rex.test($(this).text());
            }).show();

        })

    }(jQuery));

});

$(".btn").mouseup(function(){
    $(this).blur();
});

$('.change').click(function() { 
	var id=$(this).attr("name");
	var form = $('<form action="change_user" method="post">' +
			  '<input type="text" name="userName" value="' + id + '" />' +
			  '</form>');
			$(form).submit();
});
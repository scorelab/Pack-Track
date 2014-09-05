/*!
 * Bootstrap v3.2.0 (http://getbootstrap.com)
 * Copyright 2011-2014 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */
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

$('#add').click(function (e) {
	e.preventDefault();
  
	var href = $(this).attr("data-url");
  	var url = this.hash;
  	var pane = $(this);
	
	// ajax load from data-url
	$(href).load(url,function(result){      
	    pane.tab('show');
	});
});
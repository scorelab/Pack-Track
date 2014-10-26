$("#btn").click(function() {
	var text = $("#searchText").val();
	$.post("parcel-search", {
		searchText : text
	}, function(data) {
		$("#result").html(data);
	});
});
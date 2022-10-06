let moveForm = $("#moveForm");

$(".move").on("click", function(e){
    e.preventDefault();
    moveForm.empty();
    moveForm.append("<input type='hidden' id='disposableBno' name='bno' values='"+$(this).attr(href)+"'>");
    moveForm.attr("action", "/board/get");
    moveForm.submit();
});

$(window).bind("pageshow", function (event) {
	if(event.originalEvent.persisted){
		$('#disposableBno').remove();
	}
});

$(".pageInfo_btn a").on("click",function(e){
	e.preventDefault();
    moveForm.find("input[name='pageNum']").val($(this).attr(href));
    moveForm.attr("action", "/board/list");
    moveForm.submit();
});
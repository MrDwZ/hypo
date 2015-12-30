function getPage(pageName) {
    $.post("../load_page.jsp", {
        page_name : pageName
    }, function(result) {
        $("#content").html(result);
    });
}


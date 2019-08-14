$(document).on('mouseover', '.menubar a', function () {
    $('.smallmenu').slideDown(200);
});
$(document).on('mouseleave', 'div', function () {
    if (!$(this).hasClass('menubar')) {
        $('.smallmenu').slideUp(200);
    }
});

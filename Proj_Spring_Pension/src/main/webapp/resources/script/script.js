$(function(){
	
	/* GNB 풀다운 메뉴 시작 */
    $("#mainMenu>li").mouseover(function () {
        $(this).children("ul.subMenu").stop().fadeIn(200);
    });
    $("#mainMenu>li").mouseout(function () {
        $(this).children("ul.subMenu").stop().fadeOut(200);
    });
	/* GNB 풀다운 메뉴 끝 */
	
});
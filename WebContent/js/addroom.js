/**
 * 
 */

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

$("#add").click(function () {
    addroom();
});

function addroom(){
	//room_id
	var room_id = $("#room_id").val();
	$.post(
			"QueryRoomExist",
			{
				room_id:room_id,
			},
			function(data){
				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
				if(data == "FAIL"){
					
					$.post(
							"AddRoom",
							{
								room_id:room_id,
							},
							function(data){
								data = data.replace(/^\s*/, "").replace(/\s*$/, "");
								if(data == "SUCCESS"){
									setAlertText("<strong>提示：</strong>添加寝室信息成功.");
								}
								else {
									setAlertText("<strong>提示：</strong>添加寝室信息失败.");
								}
								
							}
					);
					
				}
				else {
					setAlertText("<strong>提示：</strong>寝室信息已经存在.");
				}
			}
			);
}

function setAlertText(text) {
    var html_text = text;
    var login_alert = $("div[id='alert_login']");
    login_alert.fadeOut(0);
    login_alert.empty();
    login_alert.html(html_text);
    login_alert.fadeIn(1500);
    login_alert.fadeOut(1000);
}
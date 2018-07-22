/**
 * Created by CallMeDad on 2018/4/26.
 */

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

$("#ato").click(function () {
    addinformation();
});



function addinformation() {
    var room_id = $("#room_id").val();
    var info_text = $("#info_text").val();
    if(room_id.length == 0){
        //alert("寝室号为空");
        setAlertText("<strong>提示：</strong>寝室号为空.");
    }
    else if(info_text.length == 0){
        //alert("描述为空");
        setAlertText("<strong>提示：</strong>描述为空.");
    }
    else{
    	//alert(11);
    	$.post(
				"QueryRoomExist",
				{
					room_id:room_id,
				},
				function(data){
					//alert(122);
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
	                if(data == "SUCCESS"){
	                	 $.post(
	                	          "AddRoomAttendance",
	                	            {
	                	                room_id:room_id,
	                	                room_attendance:info_text,
	                	            },
	                	            function (data) {
	                	                data = data.replace(/^\s*/, "").replace(/\s*$/, "");
	                	                if(data == "SUCCESS"){
	                	                    //alert("插入成功");
	                	                    setAlertText("<strong>提示：</strong>插入成功.");
	                	                    refresh();
	                	                }
	                	                else{
	                	                    //alert("插入失败");
	                	                    setAlertText("<strong>提示：</strong>插入失败.");
	                	                }
	                	            }
	                	        );
	                }
	                else setAlertText("<strong>提示：</strong>寝室不存在.");
				}
				);
    	
    }
}

$("#tto").click(function () {
    addtask();
});

function addtask() {
    var room_id = $("#room_id").val();
    var info_text = $("#info_text").val();
    //alert(room_id+" "+info_text);
    if(room_id.length == 0){
    	setAlertText("<strong>提示：</strong>寝室号为空.");
    }
    else if(info_text.length == 0){
    	setAlertText("<strong>提示：</strong>描述为空.");
    }
    else{
    	//alert(22);
    	$.post(
				"QueryRoomExist",
				{
					room_id:room_id,
				},
				function(data){
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					if(data == "SUCCESS"){
						$.post(
					            "AddTask",
					            {
					                room_id:room_id,
					                apart_task:info_text,
					            },
					            function (data) {
					                data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					                if(data == "SUCCESS"){
					                	setAlertText("<strong>提示：</strong>插入成功.");
					                    refresh();
					                }
					                else{
					                	setAlertText("<strong>提示：</strong>插入失败.");
					                }
					            }
					        );
					}
					else setAlertText("<strong>提示：</strong>寝室不存在.");
				}
				);
        refresh();
    }
}

function refresh(){
	$("#room_id").val("");
	$("#info_text").val("");
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


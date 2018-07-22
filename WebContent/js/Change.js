/**
 * Created by CallMeDad on 2018/4/26.

 */

var account = Cookies.get('account');
query();

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

$("#to").click(function () {
    add();
});

function query(){
	$.post(
			"QueryStudent",
			{
				stu_id:account,
			},
			function(data){
            	$("#id").val(data.stu_id);
            	$("#name").val(data.stu_name);
			},
			'json'
	);
}

function  add() {;
    var room = $("#room").val();
    var id = $("#id").val();
    var name = $("#name").val();
    var reason = $("#reason").val();
    if(room.length == 0){
        //alert("寝室号为空");
        setAlertText("<strong>提示：</strong>寝室号为空.");
    }
    else if(reason.length ==0){
        alert("理由为空");
        setAlertText("<strong>提示：</strong>理由为空.");
    }
    else{
    	
    	$.post(
    			"QueryRoomExist",
    			{
    				room_id:room,
    			},
    			function(data){
    				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
    				if(data == "SUCCESS"){
    			    	$.post(
    			    			"QueryFull",
    			    			{
    			    				room_id:room,
    			    			},
    			    			function(data){
    			    				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
    			    				if(data == "SUCCESS"){
    			    					$.post(
    			    				            "Addchange",
    			    				            {
    			    				                apart_room_id:room,
    			    				                apart_stu_id:id,
    			    				                apart_stu_name:name,
    			    				                apart_reason:reason,
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
    			    				else{
    			    					//alert("该宿舍已经满了");
    			    					setAlertText("<strong>提示：</strong>该宿舍已经满了.");
    			    				}
    			    			}
    			    	);
    				}
    				else{
    					//alert("此宿舍不存在");
    					setAlertText("<strong>提示：</strong>此宿舍不存在.");
    				}
    			}
    			);
    }
}

function refresh(){
	$("#room").val("");
	$("#reason").val("");
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
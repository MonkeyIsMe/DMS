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
				$("#repair_room").val(data.stu_room_id);
            	$("#id").val(data.stu_id);
            	$("#name").val(data.stu_name);
			},
			'json'
	);
}

function add() {
	

    var room = $("#repair_room").val();
    var id = $("#id").val();
    var name = $("#name").val();
    var reason = $("#reason").val();

    if(room.length == 0){
       // alert("寝室号为空");
        setAlertText("<strong>提示：</strong>寝室号为空.");
    }
    else if(id.length == 0){
        //alert("学号为空");
        setAlertText("<strong>提示：</strong>学号为空.");
    }
    else if(name.length == 0){
        //alert("名字为空");
        setAlertText("<strong>提示：</strong>名字为空.");
    }
    else if(reason.length ==0){
        //alert("理由为空");
        setAlertText("<strong>提示：</strong>理由为空.");
    }
    else{
    	
    	
        $.post(
            "AddFix",
            {
                fix_cnt:room,
                fix_stu_id:id,
                fix_stu_name:name,
                fix_reason:reason,
            },
            function (data) {
                data = data.replace(/^\s*/, "").replace(/\s*$/, "");
                if(data == "SUCCESS"){
                   // alert("插入成功");
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
}

function refresh(){
	$("#repair_room").val("");
	$("#id").val("");
	$("#name").val("");
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
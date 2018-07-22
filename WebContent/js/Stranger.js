/**
 * Created by CallMeDad on 2018/4/26.
 */

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});


$("#to").click(function () {
    add();
});

function add() {
    var m_name = $("#st_name").val();
    var m_id = $("#st_id").val();
    var m_to_room = $("#st_to_room").val();
    var m_to_name = $("#st_to_name").val();
    var m_telephone = $("#st_telephone").val();
    var m_date = $("#st_date").val();
    var m_people_num = $("#st_people_num").val();
    var m_reason = $("#st_reason").val();
    //alert(m_name+" "+m_id+" "+m_to_room+" "+m_to_name+" "+m_telephone+" "+m_date+" "+m_people_num+" "+m_reason);
    if(m_id.length == 0){
        //alert("请输入身份证号");
        setAlertText("<strong>提示：</strong>请输入身份证号.");
    }
    else{
        $.post(
            "AddStranger",
            {
                st_name:m_name,
                st_id:m_id,
                st_to_room:m_to_room,
                st_to_name:m_to_name,
                st_telephone:m_telephone,
                st_date:m_date,
                st_people_num:m_people_num,
                st_reason:m_reason,
            },
            function(data){
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
}
function refresh(){
	$("#st_name").val("");
	$("#st_id").val("");
	$("#st_to_room").val("");
	$("#st_to_name").val("");
	$("#st_telephone").val("");
	$("#st_date").val("");
	$("#st_people_num").val("");
	$("#st_reason").val("");
}

var i = 1;

$("#checkst").click(function () {
    if(i%2==0){
    	reset();
    }
    i++;
    check_stranger();
});

function check_stranger() {

    var m_id = $("#st_id").val();
    if(m_id.length == 0){
        alert("请输入身份证号");
    }
    else{
        $.post(
            "QueryStranger",
            {
                st_id:m_id,
            },
            function(data){
                //alert(data.st_name);
            	
            	$("#id").prepend(data.st_id);
            	$("#name").prepend(data.st_name);
            	$("#room").prepend(data.st_to_room);
            	$("#to_name").prepend(data.st_to_name);
            	$("#tele").prepend(data.st_telephone);
            	$("#date").prepend(data.st_date);
            	$("#num").prepend(data.st_people_num);
            	$("#reason").prepend(data.st_reason);
            },
            'json'
        );
    }
}

function reset(){
	$("#id").empty();
	$("#name").empty();
	$("#room").empty();
	$("#to_name").empty();
	$("#tele").empty();
	$("#date").empty();
	$("#num").empty();
	$("#reason").empty();
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
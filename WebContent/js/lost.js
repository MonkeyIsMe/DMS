/**
 * Created by CallMeDad on 2018/4/29.
 */

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

$("#lost_thing").click(function () {
    add();
});


function add() {
    var tittle =$("#info_tittle").val();
    var text = $("#info_text").val();
    var flag = "lostthing";
    if(tittle.length == 0){
        //alert("需要填标题");
        setAlertText("<strong>提示：</strong>需要填标题.");
    }
    else if(text.length == 0){
        //alert("需要填写内容");
        setAlertText("<strong>提示：</strong>需要填写内容.");
    }
    else{
    	//alert(tittle+" "+text+" "+flag);
        $.post(
            "AddInformation",
            {
                infor_name:tittle,
                infor_description:text,
                infor_flag:flag,
            },
            function (data) {
            	//alert(data);
                data = data.replace(/^\s*/, "").replace(/\s*$/, "");
                if(data == "SUCCESS"){
                    //alert("成功");
                    setAlertText("<strong>提示：</strong>成功.");
                    refresh();
                }
                else {
                    //alert("失败");
                    setAlertText("<strong>提示：</strong>失败.");
                    refresh();
                }
            }
        );
    }

}

function refresh(){
	$("#info_tittle").val("");
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
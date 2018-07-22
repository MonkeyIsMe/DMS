/**
 * Created by CallMeDad on 2018/4/29.
 */

	

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

var account = Cookies.get('account');

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

$("#updateinfo").click(function () {
    updatemyinfo();
});




function updatemyinfo(){
    //alert(11);
    var tele = $("#stu_tele_up_num").val();
    var password = $("#stu_up_password").val();
    var email = $("#stu_up_email").val();
    if(password.length < 6 || password.length >16){
        setAlertText("<strong>提示：</strong>密码长度为8~16位.");
    }
    else if(email.length != 0 && isEmail(email) == false){
        setAlertText("<strong>提示：</strong>邮箱格式错误.");
    }
    else{
        $.post(
            "Updateinfor",
            {
                account:account,
                email:email,
                new_password:password,
                stu_tele_num:tele,
            },
            function (data) {
                data = data.replace(/^\s*/, "").replace(/\s*$/, "");
                if(data == "SUCCESS"){
                    setAlertText("<strong>正确：</strong>更新学生信息成功...");
                }
                else if(data == "FAIL"){
                    setAlertText("<strong>错误：</strong>更新学生信息失败...");
                }
                else if(data == "NOTHING"){
                    setAlertText("<strong>正确：</strong>什么都没更新...");
                }
            }
        );
    }
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

function isEmail(strEmail) {
    if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
        return true;
    else
        return false;
}
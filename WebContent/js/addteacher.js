/**
 * 
 */

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

$("#add").click(function () {
    addteacher();
});

function addteacher(){
	var tea_account = $("#tea_account").val();
	var tea_password = $("#tea_password").val();
	var tea_name = $("#tea_name").val();
	var tea_yard = $("#tea_yard").val();
	var tea_tele = $("#tea_tele").val();
	var tea_email = $("#tea_email").val();
	if(tea_email.length != 0 && isEmail(tea_email) == false){
        setAlertText("<strong>提示：</strong>邮箱格式错误.");
	}
	else{
		//alert(111);
		$.post(
				"QueryTeacher",
				{
					tea_id:tea_account,
				},
				function(data){
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					//alert(data);
					if(data == "FAIL"){
						$.post(
								"AddTeacher",
								{
									tea_account:tea_account,
									tea_password:tea_password,
									tea_name:tea_name,
									tea_yard:tea_yard,
									tea_tele:tea_tele,
									tea_email:tea_email,
								},
								function(data){
									data = data.replace(/^\s*/, "").replace(/\s*$/, "");
									if(data == "SUCCESS"){
										setAlertText("<strong>提示：</strong>添加成功.");
									}
									else{
										setAlertText("<strong>提示：</strong>添加失败.");
									}
								}
						);
					}
					else{
						setAlertText("<strong>提示：</strong>此账号已经存在.");
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
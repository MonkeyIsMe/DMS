/**
 * 
 */

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

$("#to").click(function () {
    send();
});

function send(){
	var id = $("#id").val();
	var identity = $('#wrap input[name="identity"]:checked ').val();
	
	 if(identity == "学生") user_information = "student";
	    else if(identity == "管理者") user_information = "teacher";
	if(id.length == 0){
		setAlertText("<strong>提示：</strong>请先输入您的账号.");
	}
	else {
		if(user_information == "teacher"){
			$.post(
					"QueryTeacher",
					{
						tea_id:id,
					},
					function(data){
						//data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						if(data != null){
							$.post(
									"SendCodeT",
									{
										tea_id:id,
									},
									function(data){
										//alert(11);
										data = data.replace(/^\s*/, "").replace(/\s*$/, "");
										if(data == "FAIL"){
											setAlertText("<strong>提示：</strong>没有设置您的邮箱，请和管理处联系.");
										}
										else setAlertText("<strong>提示：</strong>邮件已发至邮箱.");
									}
							);
						}
						else {
							setAlertText("<strong>提示：</strong>账号不存在.");
							
						}
					}
			);
		}
		else{
			
			$.post(
					"QueryStudent",
					{
						stu_id:id,
					},
					function(data){
						//data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						//alert(data);
						if(data != null){
							//setAlertText("<strong>提示：</strong>账号不存在.");
							$.post(
									"SendCode",
									{
										stu_id:id,
									},
									function(data){
										data = data.replace(/^\s*/, "").replace(/\s*$/, "");
										if(data == "FAIL"){
											setAlertText("<strong>提示：</strong>没有设置您的邮箱，请和管理处联系.");
										}
										else setAlertText("<strong>提示：</strong>邮件已发至邮箱.");
									}
							);
						}
						else {
							setAlertText("<strong>提示：</strong>账号不存在.");
						}
					}
			);
			
		}
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
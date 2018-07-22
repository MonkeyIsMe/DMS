/**
 * 
 */


$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});


$("#code-img").click(function () {
    resetCode();
});

function resetCode() {
    var date = new Date();
    $("#code-img").attr("src", "CodeServlet?" + date.toString());
}

$("#submit-btn").click(function () {
	login();
});

function login() {

	var user_account = $("#account").val();
	var user_password = $("#password").val();
	var inputcode = $("#login-code").val();
    var identity = $('#wrap input[name="identity"]:checked ').val();

    var user_information = "";
    if(identity == "学生") user_information = "student";
    else if(identity == "管理者") user_information = "teacher";
    // alert(information);
	if(user_account.length == 0){
		setAlertText("<strong>提示：</strong>请输入您的账号.");
    }
    else if(user_password.length == 0){
    	setAlertText("<strong>提示：</strong>请输入您的密码.");
    }
    else if(inputcode.length == 0){
    	setAlertText("<strong>提示：</strong>请输入验证码.");
    }
    else{
        $.post(
            "Login",
        {
            account : user_account,
            password : user_password,
            code:inputcode,
            information : user_information,
        },
            function (data) {
        	//alert(data.flag);
        	if(data.flag == "SUCCESS" && data.identity == "teacher"){
        		//管理者登录成功
        		//alert("管理者登录成功");
        		window.location.href = "man-main.html";
        	}
        	else if(data.flag == "SUCCESS" && data.identity == "student"){
        		//学生登录成功
        		//alert("学生登录成功"); 
                Cookies.set("account", user_account, {expires: 7});
                Cookies.set("information", user_information, {expires: 7});
        		window.location.href = "stu-main.html";
        	}
        	else if(data.flag == "FAIL" && data.identity == "NULL"){
        		//密码错误
        		//alert("密码错误");
        		setAlertText("<strong>提示：</strong>密码错误.");
        	}
        	else if(data.flag == "NULL" && data.identity == "NULL"){
        		//账号不存在
        		//alert("账号不存在");
        		setAlertText("<strong>提示：</strong>账号不存在.");
        	}
        	else if(data.flag == "Wrong" && data.identity == "NULL"){
        		setAlertText("<strong>提示：</strong>验证码错误.");
        	}
            },
            'json'
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


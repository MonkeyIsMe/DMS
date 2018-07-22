

/**
 * Created by CallMeDad on 2018/4/26.
 */
sercet();

function sercet(){
	//alert(111);
	$.post(
			"SecretPassword",
			function(data){
				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
				//alert(data);
			}
	);
}

$("#to").click(function () {
    add();
});

$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});

function add() {
    var name = $("#stu_name").val();
    var id = $("#stu_id").val();
    var pwd = $("#stu_password").val();
    var tele_num = $("#stu_tele_num").val();
    var in_time = $("#stu_in_time").val();
    var yard = $("#stu_yard").val();
    var marjor_in = $("#stu_marjor_in").val();
    var class_id = $("#stu_class_id").val();
    //alert(name+" "+id+" "+pwd+" "+in_time+" "+tele_num+" "+yard+" "+" "+marjor_in+" "+class_id);
    if(id.length == 0){
        //alert("请输入学号号");
        setAlertText("<strong>提示：</strong>请输入学号.");
    }
    else{
    	$.post(
    			"QueryStudent",
    			{
    				stu_id:id,
    			},
    			function(data){
    				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
    				if(data == "FAIL"){
    			        $.post(
    			                "AddStudent",
    			                {
    			                    account:id,
    			                    stu_password:pwd,
    			                    stu_name:name,
    			                    stu_yard:yard,
    			                    stu_marjor_in:marjor_in,
    			                    stu_class_id:class_id,
    			                    stu_in_time:in_time,
    			                    stu_tele_num:tele_num,
    			                },
    			                function(data){

    			                    data = data.replace(/^\s*/, "").replace(/\s*$/, "");
    			                    if(data == "SUCCESS"){
    			                    	setAlertText("<strong>提示：</strong>插入成功.");
    			                        //alert("插入成功");
    			                    }
    			                    else{
    			                    	setAlertText("<strong>提示：</strong>插入失败.");
    			                        //alert("插入失败");
    			                    }
    			                }
    			            );
    				}
    				else {
    					setAlertText("<strong>提示：</strong>该学生信息已经存在.");
    				}
    			}
    	); 	
    	
    }
}

$("#updateto").click(function () {
    update();
});

function update() {
    var id = $("#stu_id").val();
    var pwd = $("#stu_password").val();
    var tele_num = $("#stu_tele_num").val();
    var yard = $("#stu_yard").val();
    var marjor_in = $("#stu_marjor_in").val();
    var class_id = $("#stu_class").val();

    if(id.length == 0){
        //alert("请输入学号");
        setAlertText("<strong>提示：</strong>请输入学号.");
    }
    else{
        $.post(
            "UpdateStudent",
            {
                account:id,
                stu_password:pwd,
                stu_name:name,
                stu_yard:yard,
                stu_marjor_in:marjor_in,
                stu_class_id:class_id,
                stu_tele_num:tele_num,
            },
            function(data){

                data = data.replace(/^\s*/, "").replace(/\s*$/, "");
                if(data == "SUCCESS"){
                    //alert("更新学生信息成功");
                    setAlertText("<strong>提示：</strong>更新学生信息成功.");
                }
                else{
                    //alert("更新学生信息失败");
                    setAlertText("<strong>提示：</strong>更新学生信息失败.");
                }
            }
        );
    }
}


$("#checkstu").click(function () {
    check_student();
});

function check_student() {

    var m_id = $("#stu_id").val();
    if(m_id.length == 0){
        //alert("请输入身份证号");
        setAlertText("<strong>提示：</strong>请输入身份证号.");
    }
    else{
        $.post(
            "QueryStudent",
            {
                stu_id:m_id,
            },
            function(data){
                //alert(data.stu_name);
            	$("#id").prepend(data.stu_id);
            	$("#name").prepend(data.stu_name);
            	$("#room").prepend(data.stu_room_id);
            	$("#yard").prepend(data.stu_yard);
            	$("#marjor").prepend(data.stu_marjor_in);
            	$("#banji").prepend(data.stu_class_id);
            	$("#tele").prepend(data.stu_tele_num);
            	$("#email").prepend(data.stu_email);
            },
            'json'
        );
    }
}


$("#delete").click(function () {
    delete_student();
});


function delete_student(){
	var id = $("#stu_id").val();
	if(id.length == 0){
		alert("请输出学生的入学年份");
		//setAlertText("<strong>提示：</strong>请输出学生的入学年份.");
	}
	else{
		
		$.post(
				"UpdateRoom",
				{
					stu_id:id,
				}
		);
		
		$.post(
				"DeleteStu",
				{
					stu_id:id,
				},
				function(data){
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
	                if(data == "SUCCESS"){
	                    //alert("删除离校学生信息成功");
	                    setAlertText("<strong>提示：</strong>删除离校学生信息成功.");
	                }
	                else{
	                    //alert("删除离校学生信息失败");
	                    setAlertText("<strong>提示：</strong>删除离校学生信息失败.");
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
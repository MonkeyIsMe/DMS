/**
 * Created by CallMeDad on 2018/5/8.
 */
$("document").ready(function () {
    $("#alert_login").fadeOut(0);
});


$("#addpay").click(function () {
	//alert(111);
	add();
});

function add(){
	var pay_description = $("#pay_description").val();
	var pay_money = $("#pay_money").val();
	var pay_room_id = $("#pay_room_id").val();
	var pay_body = $("#pay_body").val();
	
	if(pay_description.length == 0){
		alert("描述不能为空");
	}
	else if(pay_money.length == 0){
		alert("付费金额不能为空");
	}
	else if(pay_room_id.length == 0){
		alert("付费寝室不能为空");
	}
	else{
		
		$.post(
				"QueryRoomExist",
				{
					room_id:pay_room_id,
				},
				function(data){
					data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					if(data == "SUCCESS"){
						$.post(
								"QueryPay",
								{
									room_id:pay_room_id,
								},
								function(data){
									if(data.pay_money !=null){
										$.post(
												"UpdatePayment",
												{
													money:pay_money,
													room_id:pay_room_id,
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
									                    refresh();
									                }
												}
										);
									}
									else{
										$.post(
												"AddPayment",
												{
													room_id:pay_room_id,
													description:pay_description,
													money:pay_money,
													body:pay_body,
												},
												function (data){
													data = data.replace(/^\s*/, "").replace(/\s*$/, "");
									                if(data == "SUCCESS"){
									                	setAlertText("<strong>提示：</strong>插入成功.");
									                	refresh();
									                }
									                else{
									                	setAlertText("<strong>提示：</strong>插入失败.");
									                	refresh();
									                }
												}
										);
									}
								},
								'json'
								
						);
					}
					else {
						 setAlertText("<strong>提示：</strong>寝室不存在.");
						 refresh();
					}
				}
				);
		
	}
}


function refresh(){
	$("#pay_description").val("");
	$("#pay_money").val("");
	$("#pay_room_id").val("");
	$("#pay_body").val("");
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
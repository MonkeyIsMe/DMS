/**
 * Created by CallMeDad on 2018/5/8.
 */

var account = Cookies.get('account');



window.onload = function(){ 
	query();
}

function  query() {
    var id = account;
    //alert(id);
    $.post(
        "QueryStudent",
        {
            stu_id:id,
        },
        function (data) {
        	var stu_room = data.stu_room_id;
        	$.post(
        			"QueryPay",
        			{
        				room_id:stu_room,
        			},
        			function(data){
        				$("#pay_id").val(data.pay_cnt);
        				$("#pay_description").val(data.pay_description);
        				$("#pay_money").val(data.pay_money);
        				$("#pay_body").val(data.pay_body);
        			},
        			'json'
        	);
            
        },
        'json'
    );
}


//check();
//
//
//function check(){
//	var pay_id = $("#pay_id").val();
//	var pay_description = $("#pay_description").val();
//	var pay_money = $("#pay_money").val();
//	var pay_body = $("#pay_body").val();
//	
//	$.post(
//			"Test",
//			{
//				out_trade_no:pay_id,
//				total_amount:pay_money,
//				subject:pay_description,
//				body:pay_body,
//			}
//	);
//	
//}
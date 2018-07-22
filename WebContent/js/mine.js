/**
 * Created by CallMeDad on 2018/4/28.
 */

var account = Cookies.get('account');



query();
checktask();
checkinfor();

function  query() {
    var id = account;
    $.post(
        "QueryStudent",
        {
            stu_id:id,
        },
        function (data) {
            //alert(data.stu_id+" "+data.stu_name+" "+data.stu_room_id+" "+data.stu_yard+" "+data.stu_marjor_in+" "+data.stu_class_id);
            $("#id").prepend(data.stu_id);
            $("#name").prepend(data.stu_name);
            $("#room").prepend(data.stu_room_id);
            $("#yard").prepend(data.stu_yard);
            $("#marjor").prepend(data.stu_marjor_in);
            $("#banji").prepend(data.stu_class_id);
        },
        'json'
    );
}

function  checktask() {
	var id = account;
	$.post(
			"QueryRoomTask",
			{
				stu_id:id,
			},
			function(data){
				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
				//alert(data);
				$("#task").prepend(data);
			}
	);
}


function  checkinfor() {
	var id = account;
	$.post(
			"QueryRoomInfor",
			{
				stu_id:id,
			},
			function(data){
				data = data.replace(/^\s*/, "").replace(/\s*$/, "");
				//alert(data);
				$("#infor").prepend(data);
			}
	);
}
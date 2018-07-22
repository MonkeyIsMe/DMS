/**
 * 
 */


var account = Cookies.get('account');

function choose(index){
	//alert(account);
	var room =index;
	var id = account;
	//alert(account);
	//alert(index);
	//alert(room+" "+id);
	 var id = account;
	 var room;
	    $.post(
	        "QueryStudent",
	        {
	            stu_id:id,
	        },
	        function (data) {
	        	rooms = data.stu_room_id;
	        },
	        'json'
	    );
	if(rooms != null){
		//alert(room);
		alert("你已经有宿舍了");
	}
	else {
		
		$.post(
				"QueryFull",
				{
					room_id:room,
				},
				function(data){
					 data = data.replace(/^\s*/, "").replace(/\s*$/, "");
					if(data == "SUCCESS"){
						$.post(
								"ChooseRoom",
								{
									account:id,
									room_id:room,
								},
								function(data){
									 data = data.replace(/^\s*/, "").replace(/\s*$/, "");
						                if(data == "SUCCESS"){
						                    alert("选择成功");
						                    $('#checkchange').attr('src','QueryRoom');
						                }
						                else{
						                    alert("选择成功失败");
						                }
								}
						);
					}
					else {
						alert("该宿舍已经满了");
					}
				}
		);
	}
}
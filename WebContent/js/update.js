/**
 * 
 */



function update(index){
	//alert("success");
	var id = index;
    $.post(
            "DeleteFix",
            {
            	fix_id:id,
            }
        );
}




function agree(index){
	//alert(index)
	var id = index;
	
	$.post(
			"UpdateChange",
			{
				apart_id:id,
			},
			function(data){
				//alert(data);
				//alert(data.room+" "+data.stu_id);
				
				$.post(
						"AgreeChange",
						{
							account:data.stu_id,
							room_id:data.room,
						},
						function(data){
							data = data.replace(/^\s*/, "").replace(/\s*$/, "");
							if(data == "SUCCESS"){
								alert("更新成功");
							}
							else alert("更新失败");
						}
						);
				
			},
			'json'
	);
	
	
	$.post(
	"DeleteChange",
	{
		apart_id:id,
	}
);

}

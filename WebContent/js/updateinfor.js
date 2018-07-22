/**
 * 
 */

function update(index){
	//alert("success");
	var id = index;
    $.post(
            "DeleteInfor",
            {
            	inf_id:id,
            }
        );
    
}
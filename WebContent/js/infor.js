/**
 * 
 */

var account = Cookies.get('account');

query();

function  query() {
    var id = account;
    $.post(
        "QueryStudent",
        {
            stu_id:id,
        },
        function (data) {
            //alert(data.stu_id+" "+data.stu_name+" "+data.stu_room_id+" "+data.stu_yard+" "+data.stu_marjor_in+" "+data.stu_class_id);
            $("#stu_id").prepend(data.stu_id); //
            $("#name").prepend(data.stu_name); //
            if(data.stu_room_id == "nothing"){
            	$("#room").prepend("请先选择宿舍");
            }
            else $("#room").prepend(data.stu_room_id); 
            
            $("#yard").prepend(data.stu_yard); //
            $("#marjor").prepend(data.stu_marjor_in); //
            $("#banji").prepend(data.stu_class_id); //
        },
        'json'
    );
}
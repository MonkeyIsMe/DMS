/**
 * Created by CallMeDad on 2018/3/1.
 */


function MenuDisplay_1() {

    var obj = document.getElementById("table_1");

    if(obj.style.display=="none"){
        obj.style.display="block";
    }
    else
        obj.style.display="none";
}

function MenuDisplay_2() {

    var obj = document.getElementById("table_2");

    if(obj.style.display=="none"){
        obj.style.display="block";
    }
    else
        obj.style.display="none";
}

function MenuDisplay_3() {

    var obj = document.getElementById("table_3");

    if(obj.style.display=="none"){
        obj.style.display="block";
    }
    else
        obj.style.display="none";
}

function MenuDisplay_4() {

    var obj = document.getElementById("table_4");

    if(obj.style.display=="none"){
        obj.style.display="block";
    }
    else
        obj.style.display="none";
}

function add_migrant()
{
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(migrant.style.display=="none")
    {
        migrant.style.display = "block";
    }
    else
    {
        migrant.style.display = "none";
    }
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    information.style.display="none";
    pay.style.display="none";
    checkstranger.style.display="none";
    checkstudent.style.display="none";
    checkfix.style.display="none";
    checkchange.style.display="none";
    updatestudent.style.display="none";
    updateinfor.style.display="none";
    deletestu.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
}

function add_stu()
{
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(stu.style.display=="none")
    {
        stu.style.display = "block";
    }
    else
    {
        stu.style.display = "none";
    }

    migrant.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    information.style.display="none";
    pay.style.display="none";
    checkstranger.style.display="none";
    checkstudent.style.display="none";
    checkfix.style.display="none";
    checkchange.style.display="none";
    updatestudent.style.display="none";
    updateinfor.style.display="none";
    deletestu.style.display="none";
    addroom.style.display="none";
    addmanager.style.display="none";
}

function add_information()
{
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(infor.style.display=="none")
    {
        infor.style.display = "block";
    }
    else
    {
        infor.style.display = "none";
    }

    migrant.style.display="none";
    stu.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    information.style.display="none";
    pay.style.display="none";
    checkstranger.style.display="none";
    checkstudent.style.display="none";
    checkfix.style.display="none";
    checkchange.style.display="none";
    updatestudent.style.display="none";
    deletestu.style.display="none";
    updateinfor.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
}

function add_lost()
{
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(lost.style.display=="none")
    {
        lost.style.display = "block";
    }
    else
    {
        lost.style.display = "none";
    }

    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    task.style.display="none";
    information.style.display="none";
    pay.style.display="none";
    checkstranger.style.display="none";
    checkstudent.style.display="none";
    checkfix.style.display="none";
    checkchange.style.display="none";
    updatestudent.style.display="none";
    deletestu.style.display="none";
    updateinfor.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
}

function add_task() {
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(task.style.display == "none"){
        task.style.display = "block"
    }
    else{
        task.style.display = "none"
    }
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    information.style.display="none";
    pay.style.display="none";
    checkstranger.style.display="none";
    checkstudent.style.display="none";
    checkfix.style.display="none";
    checkchange.style.display="none";
    updatestudent.style.display="none";
    updateinfor.style.display="none";
    deletestu.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
}

function add_attendance() {
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(information.style.display == "none"){
        information.style.display = "block"
    }
    else{
        information.style.display = "none"
    }
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    pay.style.display="none";
    checkstranger.style.display="none";
    checkstudent.style.display="none";
    checkfix.style.display="none";
    checkchange.style.display="none";
    updatestudent.style.display="none";
    updateinfor.style.display="none";
    deletestu.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";

}

function check_fix() {

    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(checkfix.style.display == "none"){
        checkfix.style.display = "block"
    }
    else{
        checkfix.style.display = "none"
    }
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    information.style.display="none";
    checkstranger.style.display="none";
    checkstudent.style.display="none";
    checkchange.style.display="none";
    updatestudent.style.display="none";
    updateinfor.style.display="none";
    pay.style.display="none";
    deletestu.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
    $('#checkfix').attr('src','QueryFix');
    
}

function check_change() {
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(checkchange.style.display == "none"){
        checkchange.style.display = "block"
    }
    else{
        checkchange.style.display = "none"
    }
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    information.style.display="none";
    checkstranger.style.display="none";
    checkstudent.style.display="none";
    checkfix.style.display="none";
    updatestudent.style.display="none";
    updateinfor.style.display="none";
    pay.style.display="none";
    deletestu.style.display="none";
    addroom.style.display="none";
    addmanager.style.display="none";
    $('#QueryChange').attr('src','QueryChange');
}

function check_student() {
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(checkstudent.style.display == "none"){
        checkstudent.style.display = "block"
    }
    else{
        checkstudent.style.display = "none"
    }
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    information.style.display="none";
    checkstranger.style.display="none";
    checkfix.style.display="none";
    checkchange.style.display="none";
    updatestudent.style.display="none";
    updateinfor.style.display="none";
    pay.style.display="none";
    deletestu.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
}

function check_stranger() {
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(checkstranger.style.display == "none"){
        checkstranger.style.display = "block"
    }
    else{
        checkstranger.style.display = "none"
    }
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    pay.style.display="none";
    information.style.display="none";
    checkchange.style.display="none";
    checkstudent.style.display="none";
    checkfix.style.display="none";
    updatestudent.style.display="none";
    deletestu.style.display="none";
    updateinfor.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
    $('#checkstranger').attr('src','QueryAllStranger');
}

function update_student() {
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(updatestudent.style.display == "none"){
        updatestudent.style.display = "block"
    }
    else{
        updatestudent.style.display = "none"
    }

    information.style.display="none";
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    pay.style.display="none";
    checkchange.style.display="none";
    checkfix.style.display="none";
    checkstudent.style.display="none";
    checkstranger.style.display="none";
    updateinfor.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
    deletestu.style.display="none";

}

function add_pay() {

    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(pay.style.display == "none"){
        pay.style.display = "block";
    }
    else pay.style.display = "none";

    information.style.display="none";
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    updatestudent.style.display="none";
    checkchange.style.display="none";
    checkfix.style.display="none";
    checkstudent.style.display="none";
    checkstranger.style.display="none";
    updateinfor.style.display="none";
    deletestu.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
}

function  check_infor() {

    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(updateinfor.style.display == "none"){
        updateinfor.style.display = "block";
    }
    else updateinfor.style.display = "none";

    information.style.display="none";
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    updatestudent.style.display="none";
    checkchange.style.display="none";
    checkfix.style.display="none";
    checkstudent.style.display="none";
    checkstranger.style.display="none";
    pay.style.display="none";
    deletestu.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
    
    $('#updateinfor').attr('src','ManQueryInfor');
}

function  delete_stu() {
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(deletestu.style.display == "none"){
        deletestu.style.display = "block";
    }
    else deletestu.style.display = "none";

    information.style.display="none";
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    updatestudent.style.display="none";
    checkchange.style.display="none";
    checkfix.style.display="none";
    checkstudent.style.display="none";
    checkstranger.style.display="none";
    pay.style.display="none";
    updateinfor.style.display="none";
    addmanager.style.display="none";
    addroom.style.display="none";
}

function add_man(){
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(addmanager.style.display == "none"){
        addmanager.style.display = "block";
    }
    else addmanager.style.display = "none";

    information.style.display="none";
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    updatestudent.style.display="none";
    checkchange.style.display="none";
    checkfix.style.display="none";
    checkstudent.style.display="none";
    checkstranger.style.display="none";
    pay.style.display="none";
    updateinfor.style.display="none";
    deletestu.style.display="none";
    addroom.style.display="none";
}

function  add_room() {
    var stu = document.getElementById("stu_count");
    var migrant = document.getElementById("migrant_count");
    var infor = document.getElementById("information_notice");
    var lost = document.getElementById("lost_thing");
    var task = document.getElementById("task");
    var information = document.getElementById("information");
    var pay = document.getElementById("addpay");
    var checkstranger = document.getElementById("checkstranger");
    var checkstudent = document.getElementById("checkstudent");
    var checkfix = document.getElementById("checkfix");
    var checkchange = document.getElementById("checkchange");
    var updatestudent = document.getElementById("updatestudent");
    var updateinfor = document.getElementById("updateinfor");
    var deletestu = document.getElementById("deletestudent");
    var addmanager = document.getElementById("addmanager");
    var addroom = document.getElementById("addroom");

    if(addroom.style.display == "none"){
        addroom.style.display = "block";
    }
    else addroom.style.display = "none";

    information.style.display="none";
    migrant.style.display="none";
    stu.style.display="none";
    infor.style.display="none";
    lost.style.display="none";
    task.style.display="none";
    updatestudent.style.display="none";
    checkchange.style.display="none";
    checkfix.style.display="none";
    checkstudent.style.display="none";
    checkstranger.style.display="none";
    pay.style.display="none";
    updateinfor.style.display="none";
    deletestu.style.display="none";
    addmanager.style.display="none";
}
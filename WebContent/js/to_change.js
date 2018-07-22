/**
 * Created by CallMeDad on 2018/2/27.
 */
function testDisplay_1()
{
    var divD_1 = document.getElementById("html_1");
    var divD_2 = document.getElementById("html_2");
    if(divD_1.style.display=="none")
    {
        divD_1.style.display = "block";
    }
    else
    {
        divD_1.style.display = "none";
    }
    divD_2.style.display = "none";
}

function testDisplay_2()
{
    var divD_1 = document.getElementById("html_1");
    var divD_2 = document.getElementById("html_2");
    if(divD_2.style.display=="none")
    {
        divD_2.style.display = "block";
    }
    else
    {
        divD_2.style.display = "none";
    }
    divD_1.style.display = "none";
}
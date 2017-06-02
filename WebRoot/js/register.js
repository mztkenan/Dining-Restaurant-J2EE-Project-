// JavaScript Document// JavaScript Document

function $(id) {
    return document.getElementById(id);
}

function shurutishi(kind)
{
	$(kind+"p").className="testp";
	$(kind+"inputspan").className="inputspan click";
	$(kind+"span").style.display="inline-block";
	$(kind+"errorspan").style.display="none";
	$(kind+"okspan").style.display="none";
}

function changebutton(obj,flag)
{
	if (flag == 1)
	{
		obj.className="buttonb";
	}
	else
	{
		obj.className="buttona";
	}
}
var tongyiflag=true;
function checktongyi(obj,id)
{
	if (!obj.checked)
	{
		$(id).style.display="inline-block";
		tongyiflag=false;
	}
	else
	{
		$(id).style.display="none";
		tongyiflag=true;
	}
	
}

function chushihua()
{
	$("txtemail").value="";
	$("txtpass").value="";
	$("txtyanma").value="";
	$("txtemail").focus();
}


String.prototype.trim=function(){return this.replace(/(\s*$)|(^\s*)/g, '');};


var emailflag=false;
var passflag=false;
var erpassflag=false;
var yanmaflag=false;

function itemcheck(kind)
{
	$(kind+"p").className="";
	$(kind+"inputspan").className="inputspan";
	$(kind+"span").style.display="none";
	
	var neirong=$("txt"+kind).value.trim();


	if (kind == "email") {
	    /*非空验证*/
	    if (neirong == '') {
	        $(kind + "errorspan").innerHTML = "请填写常用Email作为唯一标识！";
	        $(kind + "errorspan").style.display = "inline-block";
	        emailflag = false;
	        return false;
	    }
	    /*格式验证*/
	    if (neirong.length > 40 || !/^[.\-_a-zA-Z0-9]+@[\-_a-zA-Z0-9]+\.[a-zA-Z0-9]/.test(neirong)) {
	        $(kind + "errorspan").innerHTML = "格式错误或超过40个字符！";
	        $(kind + "errorspan").style.display = "inline-block";
	        emailflag = false;
	        return false;
	    }
	    /*通过ajax进行唯一性验证*/
	    var xmlHttp = new XMLHttpRequest();
	    //配置XMLHttpRequest对象
	    xmlHttp.open("get", "CheckUserEmail.aspx?useremail=" + neirong + "&time=" + new Date().getTime());
	    //设置回调函数
	    xmlHttp.onreadystatechange = function () {
	        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
	            var result = parseInt(xmlHttp.responseText);
	            if (result == 0) {

	                $(kind + "errorspan").innerHTML = "此邮箱已被注册过，请更换！";
	                $(kind + "errorspan").style.display = "inline-block";
	                $("txtemail").value = "";

	                emailflag = false;
	                return false;

	            } else {
	                emailflag = true;
	                $(kind + "okspan").style.display = "inline-block";
	                return true;
	            }
	        }
	    }

	    //发送请求
	    xmlHttp.send(null);

	}
	else if (kind == "pass") {
	    /*非空验证*/
	    if (neirong == '') {
	        $(kind + "errorspan").innerHTML = "请输入密码！";
	        $(kind + "errorspan").style.display = "inline-block";
	        passflag = false;
	        return false;
	    }
	    /*长度验证*/
	    if (neirong.length < 6 || neirong.length > 20) {
	        $(kind + "errorspan").innerHTML = "很抱歉，密码长度不对！";
	        $(kind + "errorspan").style.display = "inline-block";
	        passflag = false;
	        return false;
	    }

	    passflag = true;
	}
	else if (kind == "erpass") {
	    /*非空验证*/
	    if (neirong == '') {
	        $(kind + "errorspan").innerHTML = "请输入确认密码！";
	        $(kind + "errorspan").style.display = "inline-block";
	        erpassflag = false;
	        return false;
	    }
	    /*验证两次密码是否一致*/
	    if ($("txtpass").value.trim() != neirong) {
	        $("txterpass").value = "";

	        $(kind + "errorspan").innerHTML = "很抱歉，两次密码不一致！";
	        $(kind + "errorspan").style.display = "inline-block";
	        erpassflag = false;
	        return false;
	    }

	    erpassflag = true;
	}
	else {
	    /*非空验证*/
	    if (neirong == '') {
	        $(kind + "errorspan").innerHTML = "请输入下面图片运算结果！";
	        $(kind + "errorspan").style.display = "inline-block";
	        yanmaflag = false;
	        return false;
	    }
	    /*通过ajax进行验证码验证*/

	

	    //发送请求
	    xmlHttp.send(null);

	}

	
	
}

function checkall()
{
	if(!(tongyiflag && emailflag && passflag && erpassflag && yanmaflag))
	{
		alert("请将注册信息填写完整并确保同意当当条款！");
		return false;
	}
	
	/*再次检查两次密码是否一致*/
	if ($("txtpass").value.trim() != $("txterpass").value.trim())
	{
		$("erpassokspan").style.display="none";
		$("txterpass").value="";
		$("erpasserrorspan").innerHTML="很抱歉，两次密码不一致！";
		$("erpasserrorspan").style.display="inline-block";
		return false;
	}
	/*通过全部验证*/
	
    var username = $("txtemail").value.trim();
    var userpass = "haha" + $("txtpass").value.trim();


    location.href = "RegisterUser.aspx?username=" + username + "&userpass=" + userpass;
	
}
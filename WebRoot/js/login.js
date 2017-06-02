function  tiaozhuan()
{
	window.location="register.html";
}

function $(id) {
    return document.getElementById(id);
}

function shubiaoclick(kind,flag)
{
	if (flag ==1)
	{
		$(kind+"input").className="danji";
		$(kind+"helpspan").style.display="inline-block";
		$(kind+"warnspan").style.display="none";
	}
	else
	{
		$(kind+"input").className="";
		$(kind+"helpspan").style.display="none";
	}
}




function check()
{
	/*非空验证*/
	var name=$("nameinput").value.trim();
	if ( name == '')
	{
		$("namewarnspan").style.display="inline-block";
		return false;
	}
	var pass=$("passinput").value.trim();
	if ( pass == '')
	{
		$("passwarnspan").style.display="inline-block";
		return false;
	}

	
	
}
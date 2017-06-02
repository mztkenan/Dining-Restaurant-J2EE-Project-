function $(id)
{
	return document.getElementById(id);
}

var curindex=1;

function zidong()
{
	for(var i=1;i<=3;i++)
	{
		$("img"+i).style.display ="none"; //三个连接都不显示
		$("a"+i).className="";  //将三个小方框变成灰色，
	}
	$("img"+curindex).style.display="block";
	$("a"+curindex).className="dangqian";
	
	curindex=curindex+1;
	if(curindex > 3)
	{
		curindex=1;
	}
}

var zidongid=window.setInterval("zidong()",1000);

function ting(index)
{
	window.clearInterval(zidongid);
	curindex=index;
	for(var i=1;i<=3;i++)
	{
		$("img"+i).style.display ="none"; //三个连接都不显示
		$("a"+i).className="";  //将三个小方框变成灰色，
	}
	$("img"+curindex).style.display="block";
	$("a"+curindex).className="dangqian";
}

function zou()
{
	curindex=curindex+1;
	if(curindex>3)
	{
		curindex=1;
	}
	zidongid=window.setInterval("zidong()",1000);
}
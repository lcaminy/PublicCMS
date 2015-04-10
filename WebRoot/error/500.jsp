<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%!String exceptionMsgForInner(Throwable e) {
		String ls_ErrMsg = e.getLocalizedMessage();
		if (ls_ErrMsg == null)
			ls_ErrMsg = "";
		ls_ErrMsg += "\r\n";
		Throwable eCause = e.getCause();
		if (eCause == null) {
			for (int ii = 0; ii < e.getStackTrace().length; ii++) {
				ls_ErrMsg += e.getStackTrace()[ii].toString() + "\r\n";
			}
		} else {
			ls_ErrMsg += exceptionMsgForInner(eCause);
		}
		return ls_ErrMsg.trim();
	}%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>散乱 - 服务器错误</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" type="text/css" href="/resource/css/common.css" />
<link rel="stylesheet" type="text/css" href="/resource/css/layout.css" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/resource/js/html5.js"></script>
<script type="text/javascript" src="/resource/js/respond.min.js"></script>
<![endif]-->
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script src="/resource/js/support.js"></script>
</head>
<script language="JavaScript">
<!--
	function dokeydown() {
		var obj = document.getElementById("divexception");
		if (obj.style.display.toLowerCase() == "none") {
			obj.style.display = "block";
		} else {
			obj.style.display = "none";
		}
		return false;
	}
//-->
</script>
</head>
<body>
	<div align=center>
		<div style="background-color:#eee;width:240px;" onclick="dokeydown()">服务器错误</div>
		<div style="width:240px;">系统发出错误,请返回重试或查看其他内容!<br /><br /><a href="${base}/">返回首页</a></div>
		<div style="display: none;" id=divexception>
			<textarea name="" rows="40" cols="100">
<%
	Exception ex;
	try{
		ex = (Exception) request.getAttribute("javax.servlet.error.exception");
	}catch(Exception e){
		ex = e;
	}
	out.println(exceptionMsgForInner(ex));
%>
			</textarea>
		<div>
	</div>
</body>
</html>

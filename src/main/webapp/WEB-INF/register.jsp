<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String ctxPath = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ctxPath+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>LaS-VPE-Platform-Web</title>
  <link rel="stylesheet" href="stylesheets/base.css" type="text/css" media="screen" />
  <link rel="stylesheet" id="current-theme" href="stylesheets/themes/default/style.css" type="text/css" media="screen" />
  <script type="text/javascript" charset="utf-8" src="javascripts/jquery-1.3.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="javascripts/jquery.scrollTo.js"></script>
  <script type="text/javascript" charset="utf-8" src="javascripts/jquery.localscroll.js"></script>
  <script type="text/javascript" charset="utf-8">
    // <![CDATA[
    function clean(){
    	 $("input").attr("value","");
    }
    var Theme = {
      activate: function(name) {
        window.location.hash = 'themes/' + name
        Theme.loadCurrent();
      },

      loadCurrent: function() {
        var hash = window.location.hash;
        if (hash.length > 0) {
          matches = hash.match(/^#themes\/([a-z0-9\-_]+)$/);
          if (matches && matches.length > 1) {
            $('#current-theme').attr('href', 'stylesheets/themes/' + matches[1] + '/style.css');
          } else {
            alert('theme not valid');
          }
        }
      }
    }

    $(document).ready(function() {
    	//$("#user").val("fuck");
      Theme.loadCurrent();
      $.localScroll();
      $('.table :checkbox.toggle').each(function(i, toggle) {
        $(toggle).change(function(e) {
          $(toggle).parents('table:first').find(':checkbox:not(.toggle)').each(function(j, checkbox) {
            checkbox.checked = !checkbox.checked;
          })
        });
      });
    });
    // ]]>
  </script>
</head>
<body>
  <div id="container">
    <div id="wrapper" class="wat-cf">
   	 <div id="box">
      <div class="block" id="block-signup">
        <h2>注册</h2>
        <div class="content">
            <c:if test="${!empty message}">
          		<div class="flash">
	            	<div class="message ${messagetype}">
	              	<p>${message}</p>
	            	</div>
	          	</div>
          	</c:if>
          	<c:if test="${empty message}">
          		<br />
          	</c:if>
          <form action="regist" method="post" class="form">
            <div class="group wat-cf">
              <div class="left">
                <label class="label">用户名</label>
              </div>
              <div class="right">
                <input type="text" style="width:300px" class="text_field" name="name"  placeholder ="Your Username for Login" value="${name}"/>   
                    <br/>                 
                <span class="description">提示: 一旦注册不可修改，请认真填写</span>
              </div>
            </div>
            <div class="group wat-cf">
              <div class="left">
                <label class="label">性别</label>
              </div>
              <div class="right">
                 <select name="gender">
                	<option value="0" <c:if test="${'1' eq gender}">selected="selected"</c:if>>男</option>
                	<option value="1" <c:if test="${'2' eq gender}">selected="selected"</c:if>>女</option>
               	</select>
               	<br />
                <span class="description">提示：</span>
              </div>
            </div>
            
           <div class="group wat-cf">
              <div class="left">
                <label class="label">密码</label>
              </div>
              <div class="right">
                <input type="password" style="width:300px" class="text_field" name="password" placeholder ="Password" />
                <br/>
                <span class="description">提示：请输入密码</span>
              </div>
           </div>
            
           <div class="group wat-cf">
              <div class="left">
                <label class="label">确认</label>
              </div>
              <div class="right">
                <input type="password" style="width:300px" class="text_field" name="repassword" placeholder ="Retype Password" />
                <br/>
                <span class="description">提示：请确认密码</span>
              </div>
           </div>
           <div class="group wat-cf">
              <div class="left">
                <label class="label">电话</label>
              </div>
              <div class="right">
                <input type="text" style="width:300px" class="text_field" name="phone" placeholder ="Important for Password Recovery" value="${phone}"/>
                <br/>
                <span class="description">提示：请输入电话号码</span>
              </div>
            </div>
                       
           <div class="group wat-cf">
              <div class="left">
                <label class="label">邮箱</label>
              </div>
              <div class="right">
                <input type="text" style="width:300px" class="text_field" name="email" placeholder ="We'll contact you when we can" value="${email}"/>
                <br/>
                <span class="description">提示: 请输入常用邮箱地址</span>
              </div>
            </div>
            <div class="group wat-cf">
              <div class="left">
                <label class="label">类型</label>
              </div>
              <div class="right">
                 <select name="type">
                	<option value="0" <c:if test="${'1' eq type}">selected="selected"</c:if>>1</option>
                	<option value="1" <c:if test="${'0' eq type}">selected="selected"</c:if>>0</option>
               	</select>
               	<br />
                <span class="description">提示：</span>
              </div>
            </div>
            <div class="group navform wat-cf">
              <button class="button" type="submit">
              	<img src="images/icons/tick.png" alt="Regist" /> 注册
              </button>
              <span class="text_button_padding">or</span>
              <a class="text_button_padding link_button" href="login.jsp">取消</a>
            </div>            
          </form>
        </div>
      </div>
    </div>
   </div>
  </div>
</body>
</html>


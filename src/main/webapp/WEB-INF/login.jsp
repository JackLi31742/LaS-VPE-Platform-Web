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
    <div id="box">
      <h1>LaS-VPE-Platform-Web</h1>
      <div class="block" id="block-login">
        <h2>登录</h2>
        <div class="content login">
        	<c:if test="${!empty message}">
          		<div class="flash">
	            	<div class="message ${messagetype}">
	              	<p>${message}</p>
	            	</div>
	          	</div>
          	</c:if>
          <form action="Login" class="form login" method="post">
            <div class="group wat-cf">
              <div class="left">
                <label class="label right">用户名</label>
              </div>
              <div class="right">
                <input name="name" type="text" class="text_field" />
              </div>
            </div>
            <div class="group wat-cf">
              <div class="left">
                <label class="label right">密码</label>
              </div>
              <div class="right">
                <input id="password" name="password" type="password" class="text_field" />
              </div>
            </div>
            <div class="group navform wat-cf">
              <div class="right">
                <button class="button" type="submit">
                  <img src="images/icons/key.png" alt="Save" /> 登录
                </button>
                <span class="text_button_padding">or</span>
              <a class="text_button_padding link_button" href="register">注册</a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
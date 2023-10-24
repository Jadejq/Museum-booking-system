<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ajax</title>
</head>
<body>
<script type="text/javascript">
    var text;
    function jump() {
        alert("jump");
        if(text=="登录成功"){
            window.location.href="http://http://localhost:8080/ajax_demo_war/ajax5.html";

        }
    }
    // window.onload=function (){
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("btn").onclick=function () {
            //1.发送Ajax post 请求
            var xhr = new XMLHttpRequest();
            //2.注册回调函数，这个函数在XMLHttpRequest对象的readyState状态值发生改变的时候调用
            xhr.onreadystatechange = function (){
                //这里的回调函数被调用多次
                console.log(xhr.readyState);
                if(xhr.readyState == 4){
                    if(this.status == 404){
                        alert("对不起，你访问的资源不存在，请检查路径")
                    }else if(this.status == 500){
                        alert("服务器发生了严重的内部错误");

                    }else if(this.status == 200){
                        // alert("完美，响应成功");
                        text=this.responseText;
                        //通过XMLHTTPrequest对象获取响应信息
                        // alert(text);
                        if(text=="登录成功"){
                            window.location.href="http://localhost:8080/ajax_demo_war/ajax5.html";

                        }
                        document.getElementById("mydiv").innerHTML = this.responseText;
                    }else{
                        alert("报错"+this.status);
                    }
                }
            }
            //3.开启通道
            // var usercode = document.getElementById("usercode").value;
            // var username = document.getElementById("username").value;


            xhr.open("Post","http://localhost:8080/ajax_demo_war/ajaxrequest3",true);
            //4.发送请求
            //怎么模拟Ajax提交form表单？设置请求头的内容类型（这个代码非常关键）
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            //放到send()这个函数的小括号当中的数据，会自动在请求体中提交数据
            //使用js代码获取用户填写的信息
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;

            xhr.send("username="+username+"&password="+password);

        }
    });

</script>
<h1>博物馆订票系统</h1>
<br>
username <input type="text" id="username"></br>
password <input type="password" id="password"></br>
<br>

<%--<button id="btn" οnclick=javascript:jump()>登录</button>--%>
<input type="button" id="btn" value="登录">
<!--<input type="button"value="hello ajax" id="helloBtn">-->
<!--ajax接受相应的数据之后在div里进行渲染-->
<div id="mydiv"></div>
</body>
</html>
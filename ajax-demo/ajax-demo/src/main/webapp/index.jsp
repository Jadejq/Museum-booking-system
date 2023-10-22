<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>观众信息</title>
</head>
<body>
<script type="text/javascript">
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
                        var visitorList = JSON.parse(this.responseText);//是一个数组，并且在数组中有多个观众的数据
                        var html="";
                        for(var i=0;i<visitorList.length;i++){
                            var visitor = visitorList[i];
                            html +="<tr>"
                            html +="<td>"+i+"</td>"
                            html +="<td>"+visitor.name+"</td>"
                            html +="<td>"+visitor.type+"</td>"
                            html +="<td>"+visitor.idnum+"</td>"
                            html +="</tr>"

                        }

                        document.getElementById("visitorbody").innerHTML = html;
                    }else{
                        alert("报错"+this.status);
                    }
                }
            }
            //3.开启通道

            xhr.open("Post","http://localhost:8080/ajax_demo_war/ajaxrequest5",true);
            //4.发送请求
            xhr.send();
        }
    });
</script>


<input type="button" value="显示观众列表" id="btn">
<table width="50%" border="1px">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>证件类型</th>
        <th>证件号</th>

    </tr>
    <tbody id="visitorbody"></tbody>
</table>

</body>
</html>
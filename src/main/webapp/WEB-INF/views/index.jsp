<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>안녕~~</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
    <main class="container my-5">
        <h1>안녕~~!</h1>
        <a class="btn btn-outline-danger m-3" href="${contextPath}/member">멤버전체보기</a><br>
        <form action="${contextPath}/member/new" method="post">
            <h3>멤버추가</h3>
            <input type="text" name="id">
            <input type="password" name="password">
            <input type="submit" class="btn btn-outline-primary" value="확인">
        </form>

        <h3>아이디 중복 확인</h3>
        <input type="text" id="id">
        <input type="button" class="btn btn-outline-success" id="btn" value="확인">
        <span class="result"></span>

    </main>
    <script>
        window.addEventListener("load",function () {
            const btn = document.querySelector("#btn");
            btn.onclick = function () {
                const id = document.querySelector("#id").value;
                const xhr = new XMLHttpRequest();
                xhr.onreadystatechange = function () {
                    if(this.readyState === 4){
                        if(this.status === 200){
                            const msg = this.responseText;
                            console.log(msg);
                            if(msg === "1")
                                document.querySelector(".result").textContent = '중복된 아이디입니다.';
                            else
                                document.querySelector(".result").textContent = '사용가능한 아이디입니다.';
                        }
                    }
                }
                xhr.open('GET','/member/' + id ,true);
                xhr.send();
            }
        })
    </script>
</body>
</html>

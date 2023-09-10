<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sylwia
  Date: 10/09/2023
  Time: 00:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <c:import url="head.jsp"></c:import>
</head>
<body class="container-fluid">
<c:import url="header-in.jsp"></c:import>
<main class="my-custom-bg" style="height: 100%; overflow: hidden;">
    <div class="bg-image p-5 text-center shadow-1-strong rounded mb-5 text-light"
         style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/68.jpg');
          background-size: 1000px;
          background-repeat: no-repeat;
          background-position: bottom;
          position: relative;
          background-attachment: fixed;
          padding: 20px;
         width: 100%;
         min-height: 100%;">

            <h1 class="py-5">A bientôt !</h1>
        </div>
    </section>
</main>
<c:import url="footer.jsp"></c:import>
</body>
</html>

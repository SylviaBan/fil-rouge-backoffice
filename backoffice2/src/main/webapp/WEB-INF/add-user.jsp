<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sylwia
  Date: 10/09/2023
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add user</title>
  <c:import url="head.jsp"></c:import>
</head>

<body class="container my-custom-bg">
<c:import url="header-in.jsp"></c:import>
<main class="my-5">
  <section class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-12 text-center">
          <h3 class="text-light">Ajouter un utilisateur</h3>
        </div>
      </div>
      <div class="row justify-content-center">
        <div class="col-12 col-md-6">
          <form action="add" method="post" class="bg-warning p-4 rounded mt-4">
            <div class="mb-3">
              <label class="form-label" for="nom">Username</label>
              <input class="form-control" id="nom" name="username" type="text" required>
            </div>
            <div class="mb-3">
              <label class="form-label" for="pwd">Password</label>
              <input class="form-control" id="pwd" name="password" type="password" required>
            </div>
            <div class="mb-3">
              <label class="form-label" for="phone">Phone</label>
              <input class="form-control" id="phone" name="phoneNumber" type="tel">
            </div>
            <div class="mb-3">
              <label class="form-label" for="photo">Photo</label>
              <input class="form-control" id="photo" name="photoUrl" type="text">
            </div>
            <div class="mb-3">
              <label class="form-label" for="email">Email</label>
              <input class="form-control" id="email" name="email" type="email" required>
            </div>
            <div class="mb-3 text-center d-flex justify-content-end">
              <c:if test="${not empty confirmationMessage}">
                <div class="alert alert-success">${confirmationMessage}</div>
              </c:if>
              <button class="btn btn-primary" type="submit">Add</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>

</main>
<c:import url="footer.jsp"></c:import>
</body>
</html>

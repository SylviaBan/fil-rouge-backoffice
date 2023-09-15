<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sylwia
  Date: 10/09/2023
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <c:import url="head.jsp"></c:import>
</head>
<body class="container my-custom-bg">
<c:import url="js-scripts.html"></c:import>
<c:import url="header-in.jsp"></c:import>
<section class="py-5">
  <div class="container py-5">
    <h2 class="text-light d-flex justify-content-center mb-3">Recherche des utilisateurs</h2>
    <form action="search" method="GET">
      <div class="form-group">
        <input type="text" id="username" name="username" class="form-control bg-light" placeholder="Entrez le username">
      </div>
      <button type="submit" class="btn btn-primary my-3">Rechercher</button>
    </form>
  </div>

  <div class="col-8 offset-2">
    <h4 class="text-light d-flex justify-content-center mb-2">Détails du compte</h4>
    <div class="card mt-3 text-grey">
      <div class="card-body bg-light">
        <p class="card-title ws-bold">${user.username}</p>
        <p class="card-title ws-bold">${user.password}</p>
        <p class="card-text"> ${user.email}</p>
        <p class="card-text"> ${user.phoneNumber}</p>
        <p class="card-text"> ${user.photoUrl}</p>
        <div class="d-flex justify-content-end">
          <form action="edit" method="POST">
            <button type="submit" class="btn btn-primary mx-1 btn-size">
              <span class="material-symbols-outlined">Edit</span>
            </button>
          </form>
          <form action="delete" method="POST">
            <button type="submit" class="btn btn-danger mx-1 btn-size" onclick="confirmDelete(${user.getId()})">
              <span class="material-symbols-outlined">Delete</span>
            </button>
            <!-- Un champ caché pour transmettre l'ID de l'utilisateur -->
            <input type="hidden" name="id" value="${user.getId()}">
          </form>
          <button type="button" class="btn btn-success mx-1 btn-size">
            <span class="material-symbols-outlined">Activate</span>
          </button>
          <button type="button" class="btn btn-secondary mx-1 btn-size">
            <span class="material-symbols-outlined">Deactivate</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>

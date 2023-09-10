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
<c:import url="header-in.jsp"></c:import>
<section class="py-5">
  <div class="container py-5">
    <h1 class="text-light d-flex justify-content-center mb-5">Recherche des utilisateurs</h1>
    <form action="search" method="GET">
      <div class="form-group">
        <input type="text" id="username" name="username" class="form-control" placeholder="Entrez le username">
      </div>
      <button type="submit" class="btn btn-primary my-2">Rechercher</button>
    </form>
    <table class="table text-center align-middle my-5">
      <thead>
      <tr class="p-3 mb-2 bg-warning text-dark">
        <th>#</th>
        <th>Username</th>
        <th>Email</th>
        <th colspan="4" class="col-4">Actions</th>
      </tr>
      </thead>
      <tbody>
      <tr class="text-light">
        <th>${user.getId()}</th>
        <td>${user.getUsername()}</td>
        <td>${user.getEmail()}</td>
        <td class="d-flex justify-content-between">
          <button type="button" class="btn btn-primary my-btn-position">
            <span class="material-symbols-outlined">Edit</span>
          </button>
          <form action="delete" method="POST">
            <button type="submit" class="btn btn-danger my-btn-position" onclick="confirmDelete(${user.getId()})">
              <span class="material-symbols-outlined">Delete</span>
            </button>
            <!-- Un champ caché pour transmettre l'ID de l'utilisateur -->
            <input type="hidden" name="id" value="${user.getId()}">
          </form>
          <button type="button" class="btn btn-success my-btn-position">
            <span class="material-symbols-outlined">Activate</span>
          </button>
          <button type="button" class="btn btn-secondary my-btn-position">
            <span class="material-symbols-outlined">Deactivate</span>
          </button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</section>
</body>
</html>

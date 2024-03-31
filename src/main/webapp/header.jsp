<%--
  Created by IntelliJ IDEA.
  User: macio
  Date: 31.03.2024
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .header {
        background-color: #333;
        color: white;
        padding: 10px 0;
    }

    .navbar {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .navbar a {
        color: white;
        padding: 14px 20px;
        text-decoration: none;
        font-size: 16px;
    }

    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }
</style>

<div class="header">
    <nav class="navbar">
        <a href="${pageContext.request.contextPath}/students">Students</a>
        <a href="${pageContext.request.contextPath}/lessons">Lessons</a>
    </nav>
</div>


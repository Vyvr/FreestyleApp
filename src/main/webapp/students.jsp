<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Students</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        header nav a {
            margin-right: 20px;
            text-decoration: none;
            color: #333;
        }

        h2 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        td a {
            color: #4CAF50;
            text-decoration: none;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .add-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
            display: inline-block;
        }

        .add-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Students List</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Class</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.name}</td>
            <td>${student.surname}</td>
            <td>${student.studentClass}</td>
            <td><a href="/editStudent?id=${student.id}">Edit</a></td>
            <td><a href="/deleteStudent?id=${student.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/addStudent" class="add-button">Add Student</a>
</body>
</html>

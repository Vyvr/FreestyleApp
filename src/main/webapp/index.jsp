<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Homepage - Login and Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        h2 {
            text-align: center;
        }

        input[type=text], input[type=password], input[type=email] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .hidden {
            display: none;
        }
    </style>
</head>
<body>

<div id="loginForm" class="form-container">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <input type="text" name="email" placeholder="Email" required><br>
        <input type="password" name="password" placeholder="Password" required><br>

        <% if (request.getAttribute("errorMessage") != null) { %>
        <div style="color: red; text-align: center;">
            <%= request.getAttribute("errorMessage") %>
        </div>
        <% } %>

        <% if (request.getAttribute("successMessage") != null) { %>
        <div style="color: green; text-align: center;">
            <%= request.getAttribute("successMessage") %>
        </div>
        <% } %>

        <button type="submit">Submit</button>
    </form>
    <button onclick="toggleForms()">Register</button>
</div>

<div id="registerForm" class="form-container hidden">
    <h2>Register</h2>
    <form action="RegisterServlet" method="post">
        <input type="text" name="name" placeholder="Username" required><br>
        <input type="text" name="surname" placeholder="Surname" required><br>
        <input type="password" name="password" placeholder="Password" required><br>
        <input type="email" name="email" placeholder="Email" required><br>

        <% if (request.getAttribute("errorMessage") != null) { %>
        <div style="color: red; text-align: center;">
            <%= request.getAttribute("errorMessage") %>
        </div>
        <% } %>

        <% if (request.getAttribute("successMessage") != null) { %>
        <div style="color: green; text-align: center;">
            <%= request.getAttribute("successMessage") %>
        </div>
        <% } %>

        <button type="submit">Submit</button>
    </form>
    <button onclick="toggleForms()">Login</button>
</div>

<script>
    function toggleForms() {
        var loginForm = document.getElementById("loginForm");
        var registerForm = document.getElementById("registerForm");
        if (loginForm.classList.contains("hidden")) {
            loginForm.classList.remove("hidden");
            registerForm.classList.add("hidden");
        } else {
            loginForm.classList.add("hidden");
            registerForm.classList.remove("hidden");
        }
    }
</script>

</body>
</html>

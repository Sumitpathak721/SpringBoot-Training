<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
</head>
<body>
    <h1>Calculator</h1>
    <form action="sol4" method="post">
        <input type="number" name="num1" placeholder="First number">
        <input type="number" name="num2" placeholder="Second number">
        <button type="submit">Calculate</button>
    </form>
    <p id="result"></p>
</body>
</html>
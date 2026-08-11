<%@ page import="com.codegnan.app.javawebapp10082026.dto.UserDto" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <%
        UserDto userDto = (UserDto) session.getAttribute("USERDTO");
    %>

    <h1>Welcome <%= userDto.getFirstName() %> <%= userDto.getLastName() %>
</h1>
</body>
</html>
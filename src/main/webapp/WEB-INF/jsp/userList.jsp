```jsp
<%@ page import="java.util.List" %>
<%@ page import="com.codegnan.app.javawebapp11082026.entity.User" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Users List</title>
</head>

<body>

<h2>Users List</h2>

<table border="1" cellpadding="10">

    <tr>
        <th>User ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Change Password</th>
        <th>Delete User</th>
    </tr>

<%
    List<User> usersList =
            (List<User>) request.getAttribute("usersList");

    if (usersList != null && !usersList.isEmpty()) {

        for (User user : usersList) {
%>

    <tr>

        <td>
            <%= user.getUserId() %>
        </td>

        <td>
            <%= user.getFirstName() %>
        </td>

        <td>
            <%= user.getLastName() %>
        </td>

        <td>
            <a href="<%= request.getContextPath() %>/changepassword?userId=<%= user.getUserId() %>">
                Change Password
            </a>
        </td>

        <td>
            <a href="<%= request.getContextPath() %>/deleteuser?userId=<%= user.getUserId() %>">
                Delete User
            </a>
        </td>

    </tr>

<%
        }

    } else {
%>

    <tr>
        <td colspan="5">No users found</td>
    </tr>

<%
    }
%>

</table>

</body>
</html>
```

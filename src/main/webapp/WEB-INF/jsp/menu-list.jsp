<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Items</title>
    <style>
        body {
            font-family: "Trebuchet MS", Arial, sans-serif;
            margin: 24px;
        }
        h1 {
            margin: 0 0 16px;
        }
        .actions {
            margin-bottom: 16px;
        }
        .button {
            display: inline-block;
            padding: 8px 14px;
            background: #2f5dff;
            color: #ffffff;
            text-decoration: none;
            border-radius: 4px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #cccccc;
            padding: 8px;
        }
        .edit-link {
            color: #1d4ed8;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>Menu Items</h1>
<div class="actions">
    <a class="button" href="<c:url value='/add' />">Add Menu Item</a>
    <a class="button" href="<c:url value='/menu-join' />">View Join Data</a>
</div>
<table>
    <thead>
    <tr>
        <th>Item Name</th>
        <th>Price</th>
        <th>Restaurant Name</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${menuItems}" var="item">
        <tr>
            <td><c:out value="${item.itemName}" /></td>
            <td><c:out value="${item.price}" /></td>
            <td><c:out value="${item.restaurant.name}" /></td>
            <td>
                <a class="edit-link" href="<c:url value='/edit/${item.id}' />">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Join Data</title>
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
    </style>
</head>
<body>
<h1>Menu Join Data</h1>
<div class="actions">
    <a class="button" href="<c:url value='/menu' />">Back to Menu</a>
</div>
<table>
    <thead>
    <tr>
        <th>Item Name</th>
        <th>Price</th>
        <th>Restaurant Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${menuData}" var="row">
        <tr>
            <td><c:out value="${row[0]}" /></td>
            <td><c:out value="${row[1]}" /></td>
            <td><c:out value="${row[2]}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

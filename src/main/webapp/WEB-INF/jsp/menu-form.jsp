<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Item Form</title>
    <style>
        body {
            font-family: "Trebuchet MS", Arial, sans-serif;
            margin: 24px;
        }
        h1 {
            margin: 0 0 16px;
        }
        form {
            max-width: 420px;
        }
        label {
            display: block;
            margin: 8px 0 4px;
            font-weight: 600;
        }
        input, select {
            padding: 8px;
            border: 1px solid #cccccc;
            width: 100%;
        }
        button {
            margin-top: 12px;
            padding: 8px 14px;
            background: #2f5dff;
            color: #ffffff;
            border: none;
            border-radius: 4px;
        }
        .back-link {
            display: inline-block;
            margin-top: 12px;
            text-decoration: none;
            color: #1d4ed8;
        }
    </style>
</head>
<body>
<c:choose>
    <c:when test="${menuItem.id != null}">
        <h1>Edit Menu Item</h1>
        <c:set var="formAction" value="/update" />
    </c:when>
    <c:otherwise>
        <h1>Add Menu Item</h1>
        <c:set var="formAction" value="/save" />
    </c:otherwise>
</c:choose>

<form method="post" action="${formAction}">
    <input type="hidden" name="id" value="${menuItem.id}" />

    <label for="itemName">Item Name</label>
    <input id="itemName" type="text" name="itemName" value="${menuItem.itemName}" required />

    <label for="price">Price</label>
    <input id="price" type="number" step="0.01" name="price" value="${menuItem.price}" required />

    <label for="restaurantId">Restaurant</label>
    <select id="restaurantId" name="restaurant.id" required>
        <option value="">Select restaurant</option>
        <c:forEach items="${restaurants}" var="restaurant">
            <option value="${restaurant.id}"
                <c:if test="${menuItem.restaurant != null and restaurant.id == menuItem.restaurant.id}">selected</c:if>>
                <c:out value="${restaurant.name}" />
            </option>
        </c:forEach>
    </select>

    <button type="submit">Save</button>
</form>

<a class="back-link" href="<c:url value='/menu' />">Back to list</a>
</body>
</html>

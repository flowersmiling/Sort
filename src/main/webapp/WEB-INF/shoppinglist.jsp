<%-- 
    Document   : shoppinglist
    Created on : Feb. 9, 2022, 1:00:21 p.m.
    Author     : peony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
    <form>
        
        <label for="item">Items:</label>
        <input type="text" name="item">
    </form>
        <form>
            <p>
            <input type="radio" name="item" value="apple">Apples
            </p><!-- comment -->
            
            <button type="submit">Save</button>
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="grid.css">
    <script src="grid.js"></script>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 20px;
        }
        h1 {
            margin: 0;
        }
        nav {
            background-color: #ddd;
            padding: 10px;
            margin: 20px;
            display: flex;
            flex-wrap: wrap;
        }
        nav a {
            text-decoration: none;
            color: #333;
            padding: 10px;
            border-radius: 5px;
            margin-right: 10px;
            margin-bottom: 10px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0,0,0,0.2);
            transition: all 0.2s ease-in-out;
        }
        nav a:hover {
            background-color: #333;
            color: #fff;
            box-shadow: 0 4px 6px rgba(0,0,0,0.3);
        }
    </style>
</head>
<body>
<header>
    <h1>Home Page</h1>
</header>
<nav>
    <a href="createkPac.jsp">Add K-PAC</a>
    <a href="kpacsList.jsp">View K-PACs</a>
    <a href="createSet.jsp">Add Set</a>
    <a href="setsList.jsp">View Sets</a>
    <a href="kPacSet.jsp">View K-PACs to the selected K-PAC set</a>
</nav>
<script>
    dhx.ready(function(){
        dhx.event(document.body, "click", function(e){
            var target = e.target || e.srcElement;
            if(target.tagName.toLowerCase() === "a"){
                e.preventDefault();
                var href = target.getAttribute("href");
                dhx.ajax().get(href, function(response){
                    document.body.innerHTML = response;
                });
            }
        });
    });
</script>
</body>
</html>

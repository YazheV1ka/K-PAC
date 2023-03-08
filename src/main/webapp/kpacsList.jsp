<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>kPac Form</title>
    <link rel="stylesheet" type="text/css" href="grid.css">
    <script src="grid.js"></script>
</head>
<body>
<h1>kPac Form</h1>
<form id="kPacForm">
    <div>
        <label for="id">ID:</label>
        <input type="text" name="id" id="id">
    </div>
    <div>
        <label for="title">Title:</label>
        <input type="text" name="title" id="title">
    </div>
    <div>
        <label for="description">Description:</label>
        <textarea name="description" id="description"></textarea>
    </div>
    <div>
        <label for="creationDate">Creation Date:</label>
        <input type="text" name="creationDate" id="creationDate">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
<script>
    var kPacForm = new dhx.Form("kPacForm", {
        width: "500px",
        rows: [
            {type: "input", label: "ID", name: "id"},
            {type: "input", label: "Title", name: "title"},
            {type: "textarea", label: "Description", name: "description"},
            {type: "input", label: "Creation Date", name: "creationDate"}
        ]
    });

    kPacForm.attachEvent("onSubmit", function(data){
        dhx.ajax().post("kPacServlet", data, function(response){
            console.log(response);
        });
        return false;
    });
</script>
</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <title>Set Form</title>
    <link rel="stylesheet" type="text/css" href="grid.css">
    <script src="https://cdn.dhtmlx.com/suite/edge/suite.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.dhtmlx.com/suite/edge/suite.css"/>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>kPac Form</h1>
        <form method="post" id="set" action="${pageContext.request.contextPath}/set/create"></form>
        <form id="setForm" class="form">
            <div class="form-group">
                <input type="submit" value="Submit">
            </div>
        </form>
    </div>

</div>
<script>
    var kPacForm = new dhx.Form("setForm", {
        width: "500px",
        rows: [
            {type: "input", label: "ID", name: "id"},
            {type: "input", label: "Title", name: "title"},
            {type: "submit", label: "Submit", name: "submit"}
        ]
    });
    kPacForm.attachEvent("onSubmit", function(data){
        dhx.ajax().post("SetServlet", data, function(response){
            console.log(response);
        });
        return false;
    });
</script>
</body>
</html>

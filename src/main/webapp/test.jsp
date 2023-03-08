<!DOCTYPE html>
<html>
<head>
  <title>kPac Form</title>
  <link rel="stylesheet" type="text/css" href="grid.css">
  <script src="https://cdn.dhtmlx.com/suite/edge/suite.js"></script>
  <link rel="stylesheet" type="text/css" href="https://cdn.dhtmlx.com/suite/edge/suite.css"/>
</head>
<body>
<div class="container">
  <div class="header">
    <h1>kPac Form</h1>
    <form method="post" id="kPac" action="${pageContext.request.contextPath}/kpacs/create"></form>
    <form id="kPacForm" class="form">
      <div class="form-group">
        <input type="submit" name="submit" value="Submit">
      </div>
    </form>
  </div>

</div>
<script>
  var kPacForm = new dhx.Form("kPacForm", {
    width: "500px",
    rows: [
      {type: "input", label: "ID", name: "id"},
      {type: "input", label: "Title", name: "title"},
      {type: "textarea", label: "Description", name: "description"},
      {type: "input", label: "Creation Date", name: "creationDate"},
      {type: "submit", label: "Submit", name: "submit"}
    ]
  });
  kPacForm.attachEvent("submit", function(data){
    dhx.ajax().post("kPacServlet", data, function(response){
      console.log(response);
    });
    return false;
  });
</script>
</body>
</html>

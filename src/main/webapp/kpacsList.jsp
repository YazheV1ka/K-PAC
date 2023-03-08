<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Knowledge Packages</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- DHTMLX 7 CSS -->
    <link rel="stylesheet" type="text/css" href="https://cdn.dhtmlx.com/suite/edge/suite.css"/>
    <!-- DHTMLX 7 JS -->
    <script src="https://cdn.dhtmlx.com/suite/edge/suite.js"></script>
</head>
<body>
<div class="dhx_container">
    <h1 class="dhx_title">All Knowledge Packages</h1>
    <div id="kpac_table" class="dhx_dataview_container"></div>
</div>

<script>
    // Data
    const kPacs = ${kPac};

    // Layout
    const kPacTable = new dhx.DataView("kpac_table", {
        css: "dhx_widget--bordered dhx_widget--bg_white",
        select: false,
        editable: false,
        multiselect: false,
        dragMode: "both",
        template: function (kPac) {
            return "<div class='dhx_dataview__item'>" +
                "<div class='dhx_dataview__content'>" +
                "<div class='id'>" + kPac.id + "</div>" +
                "<div class='dhx_dataview__title'>" + kPac.title + "</div>" +
                "<div class='dhx_dataview__description'>" + kPac.description + "</div>" +
                "<div class='dhx_dataview__date'>" + kPac.creationDate + "</div>" +
                "</div>" +
                "<div class='dhx_dataview__button'><a href='${pageContext.request.contextPath}/removeKPac/" + kPac.id + "'>Delete</a></div>" +
                "</div>";
        },
        data: kPacs,
        dragMode: false,
        height: 500,
        css: "dhx_widget--bg_white dhx_widget--bordered",
        padding: 10,
        navigation: true,
        keyNavigation: true,
        autoWidth: true,
        onClick: function (id) {
            console.log(kPacTable.getItem(id));
        },
    });

    // Filter
    const kPacFilter = kPacTable.addFilter({
        type: "search",
        position: "header",
        text: "Filter",
        icon: "dxi-magnify",
        showButton: true,
    });

    // Sort
    kPacTable.addSorting("title");
    kPacTable.addSorting("description");
    kPacTable.addSorting("creationDate");
</script>
</body>
</html>

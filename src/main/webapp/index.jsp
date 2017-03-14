<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java REST Services</title>

        <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>

        <script>
            var ctxPath = "<%=request.getContextPath()%>";
            $(function () {
                $("#postPerson").on("click", function () {
                    $.ajax({
                        url: ctxPath + "/contact/services/addcontact",
                        type: "POST",
                        data: '{"id":"2", "firstName":"asas", "middleName":"asas", "lastName":"Jordan", "dob":"wewe", "homeAddress":"wewe", "workAddress":"wewe", "homePhone":"sdsd", "workPhone":"sdsds", "cellPhone":"sds", "fax":"sds", "email":"sdsd" }',
                        contentType: "application/json",
                        cache: false,
                        dataType: "json",
                        success: function (data, textStatus, jqXHR) {
                            alert(data);
                        }
                    });
                });
            });
        </script>


        <script>
            var ctxPath = "<%=request.getContextPath()%>";
            $(function () {
                $("#updatePerson").on("click", function () {
                    $.ajax({
                        url: ctxPath + "/contact/services/updatecontact",
                        type: "PUT",
                        data: '{"id":"2", "firstName":"asas", "middleName":"asas", "lastName":"Jordan", "dob":"wewe", "homeAddress":"wewe", "workAddress":"wewe", "homePhone":"sdsd", "workPhone":"sdsds", "cellPhone":"sds", "fax":"sds", "email":"sdsd" }',
                        contentType: "application/json",
                        cache: false,
                        dataType: "json",
                        success: function (data, textStatus, jqXHR) {
                            alert(data);
                        }
                    });
                });
            });
        </script>

    </head>

    <body>
        <h1>Java REST Services</h1>
        <ul>
            <li><a href="<%=request.getContextPath()%>/contact/services/getall"><%=request.getContextPath()%>/service/person/getall</a></li>
            <br>
            <li><button id="postPerson">Post Person</button></li>
            <br>
            <li><button id="updatePerson">Update Person</button></li>
        </ul>

    </body>

</html>
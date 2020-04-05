<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<html>
<head>
    <title>Nearpe : ZipCode lookup tool</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

<div style="padding: 30px 30%;">
    <form class="form-inline" action="javascript:;">
        <div class="form-group">
            <label for="state">State : </label>
            <input type="text" class="form-control" id="state">
        </div>
        <div class="form-group">
            <label for="city">City : </label>
            <input type="text" class="form-control" id="city">
        </div>
        <button type="submit" class="btn btn-default">Find</button>
    </form>
</div>

<div style="padding: 30px 30%; font-size: 15px;">
    Result :
    <div id="result">
    </div>
</div>

<script>
    $(document).ready(function() {
        var baseUri = "http://localhost:8000/zipcode-0.0.1/";

        $("form").submit(function( event ) {
            event.preventDefault();
            var state = $("#state").val();
            var city = $("#city").val();
            console.log("state = " + state);
            console.log("city = " + city);

            if(state.length == 0 && city.length == 0) {
                alert("Plese enter something");
            } else if(city.length == 0) {
                $.ajax({
                    url: baseUri + "state?state=" + state,
                    success: function(result) {
                        console.log(result);
                        $("#result").html(result);
                    }});
            } else if(state.length == 0) {
                $.ajax({
                    url: baseUri + "city?city=" + city,
                    success: function(result) {
                        console.log(result);
                        $("#result").html(result);
                    }});
            } else {
                $.ajax({
                    url: baseUri + "zip?city=" + city + "&state=" + state,
                    success: function(result) {
                        console.log(result);
                        $("#result").html(result);
                    }});
            }

        });
    });
</script>

</body>
</html>
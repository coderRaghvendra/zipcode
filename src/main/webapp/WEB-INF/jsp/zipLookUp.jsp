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
        var baseUri = "http://localhost:8000/zipcode/";

        $("form").submit(function( event ) {
            event.preventDefault();
            var state = $("#state").val();
            var city = $("#city").val();

            if(state.length == 0 && city.length == 0) {
                alert("Please enter something");
            } else if(city.length == 0) {
                $.ajax({
                    url: baseUri + "state?state=" + state,
                    success: function(result) {
                        console.log(result);
                        var html = "";
                        for(var i=0; i<result.length; i++) {
                            html += "<div>" + result[i] + "</div>";
                        }
                        $("#result").html(html);
                    }});
            } else if(state.length == 0) {
                $.ajax({
                    url: baseUri + "city?city=" + city,
                    success: function(result) {
                        console.log(result);
                        var html = "";
                        if(result.states != null && result.states.length != 0) {
                            for(var i=0; i<result.states.length; i++) {
                                html += "<div>" + result.states[i] + "</div>";
                            }
                        }
                        if(result.zips != null && result.zips.length != 0) {
                            for(var i=0; i<result.zips.length; i++) {
                                html += "<div>" + result.zips[i] + "</div>";
                            }
                        }
                        $("#result").html(html);
                    }});
            } else {
                $.ajax({
                    url: baseUri + "zip?city=" + city + "&state=" + state,
                    success: function(result) {
                        console.log(result);
                        var html = "";
                        for(var i=0; i<result.length; i++) {
                            html += "<div>" + result[i] + "</div>";
                        }
                        $("#result").html(html);
                    }});
            }

        });
    });
</script>

</body>
</html><%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        var baseUri = "http://localhost:8000/zipcode/";

        $("form").submit(function( event ) {
            event.preventDefault();
            var state = $("#state").val();
            var city = $("#city").val();

            if(state.length == 0 && city.length == 0) {
                alert("Please enter something");
            } else if(city.length == 0) {
                $.ajax({
                    url: baseUri + "state?state=" + state,
                    success: function(result) {
                        console.log(result);
                        var html = "";
                        for(var i=0; i<result.length; i++) {
                            html += "<div>" + result[i] + "</div>";
                        }
                        $("#result").html(html);
                    }});
            } else if(state.length == 0) {
                $.ajax({
                    url: baseUri + "city?city=" + city,
                    success: function(result) {
                        console.log(result);
                        var html = "";
                        if(result.states != null && result.states.length != 0) {
                            for(var i=0; i<result.states.length; i++) {
                                html += "<div>" + result.states[i] + "</div>";
                            }
                        }
                        if(result.zips != null && result.zips.length != 0) {
                            for(var i=0; i<result.zips.length; i++) {
                                html += "<div>" + result.zips[i] + "</div>";
                            }
                        }
                        $("#result").html(html);
                    }});
            } else {
                $.ajax({
                    url: baseUri + "zip?city=" + city + "&state=" + state,
                    success: function(result) {
                        console.log(result);
                        var html = "";
                        for(var i=0; i<result.length; i++) {
                            html += "<div>" + result[i] + "</div>";
                        }
                        $("#result").html(html);
                    }});
            }

        });
    });
</script>

</body>
</html>
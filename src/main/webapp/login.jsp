<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Online Exam Portal</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap/css/custom-theme.min.css">

    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <header>
        <jsp:include page="header.jsp" />
        <jsp:include page="nav_public.jsp">
            <jsp:param name="page" value="login" />
        </jsp:include>
    </header>
    <div class="col-lg-1"></div>
    <div class="col-sm-10">
        <% String error = (String) request.getAttribute("error");
            String error_msg = (String) request.getAttribute("error_msg"); %>
        <% if (error == "true") { %>
        <div class="alert alert-dismissible alert-danger">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong><%= error_msg%>
            </strong>
        </div>
        <% } %>
        <form class="form-horizontal" action="login" method="post">
            <fieldset>
                <legend>Login Form</legend>
                <div class="form-group">
                    <label for="inputUsername" class="col-lg-2 control-label">Username</label>
                    <div class="col-lg-10">
                        <input type="text" name="username" class="form-control" id="inputUsername"
                               placeholder="Username">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                    <div class="col-sm-8">
                        <input type="password" name="password" class="form-control" id="inputPassword"
                               placeholder="Password">
                    </div>
                    <div class="col-sm-2 text-right">
                        <button type="button" class="btn btn-primary" id="showpass">Show Password</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-5">
                        <button type="reset" class="btn btn-default">Reset</button>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
    <div class="col-lg-1"></div>
</div>
</body>
<script>
    $('.nav-collapse').click('li', function () {
        $('.nav-collapse').collapse('hide');
    });

    $('#showpass').mousedown(function () {
        $('#inputPassword').removeAttr("type").prop('type', 'text');
    }).mouseup(function () {
        $('#inputPassword').removeAttr("type").prop('type', 'password');
    })
    ;
</script>
</html>
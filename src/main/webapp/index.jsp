<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Online Exam Portal</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Latest compiled and minified CSS -->
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="bootstrap/css/custom-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <header>
        <jsp:include page="header.jsp" />
        <jsp:include page="nav_public.jsp" />
    </header>
    <div class="page-header">
        <h3>About Us</h3>
    </div>
    <% String info = (String) session.getAttribute("info");
        String info_msg = (String) session.getAttribute("info_msg"); %>
    <% if (info == "true") { %>
    <div class="alert alert-dismissible alert-success">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <strong><%= info_msg%>
        </strong>
    </div>
    <% } %>
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <p style="font-size: 1.5em;">Online Exam Portal is the project made in Java Servlet in this user has to first register his or her account then registered user can select desired topic for quiz.<br /><br />
        </p>
    </div>
    <div class="col-lg-1"></div>
</div>
</body>
<script>
    $('.nav-collapse').click('li', function () {
        $('.nav-collapse').collapse('hide');
    });
</script>
</html>
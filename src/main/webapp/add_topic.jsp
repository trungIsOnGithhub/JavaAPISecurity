<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Online Exam Portal</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Latest compiled and minified CSS -->
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="bootstrap/css/custom-theme.min.css">


    <!-- Latest compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <header>
        <jsp:include page="header.jsp"/>
        <jsp:include page="nav_user.jsp">
            <jsp:param name="page" value="user_index"/>
        </jsp:include>
    </header>
    <form class="form-horizontal" action="AddTopic" method="post">
        <fieldset>
            <legend>
                Add Topic
            </legend>
            <div class="col-lg-1"></div>
            <div class="col-lg-10">
                <div class="form-group">
                    <label for="inputTopicName" class="col-lg-2 control-label">Name</label>
                    <div class="col-lg-10">
                        <input type="text" name="topicname" class="form-control" id="inputTopicName" placeholder="Name">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputTopicDesc" class="col-lg-2 control-label">Description</label>
                    <div class="col-lg-10">
                        <textarea rows="4" style="resize: none;" name="topicdesc" class="form-control"
                                  id="inputTopicDesc" placeholder="Description"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-5">
                        <button type="reset" class="btn btn-default">Reset</button>
                        <button type="submit" class="btn btn-primary">Add Topic</button>
                    </div>
                </div>
            </div>
            <div class="col-lg-1"></div>

        </fieldset>
    </form>
</div>
</body>
<script>
    $('.nav-collapse').click('li', function () {
        $('.nav-collapse').collapse('hide');
    });
</script>
</html>
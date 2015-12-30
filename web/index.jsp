<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main_style.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script src="js/jQuery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</head>

<body>
    <nav class = "navbar navbar-default">
    	<div class="container">
            <div id="navbar" class="navbar-collapse collapse">
                <ul class = "nav navbar-nav">
                    <li> <a name="home" role="button" onclick="getPage('Home')" href="#">Home</a> </li>
                    <li> <a name="aboutme" role="button" onclick = "getPage('aboutme')" href="#">About Me</a> </li>
                    <li> <a name="RSS" role="button" onclick="getPage('RSS')" href="#">RSS</a> </li>
                </ul>

                <form action="UploadServlet" method="POST" class="navbar-form navbar-right" enctype="multipart/form-data">
                    <span class="btn btn-default btn-file">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    Add Page <input type="file" name="upfile">
                    </span>
                    <input type="submit" name="submit_file">
                </form>
            </div>
        </div>
    </nav>

    <div class="container bs-docs-container">
        <div class="bs-docs-section" id="content">

        </div>
    </div>
</body>
</html>
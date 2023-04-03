<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
</head>

<body>

<div class="container mb-5">
    <center>
        <div class="col-lg-6 col-sm-12">

            <!-- The login form -->
            <div class="card p-2 mt-2 bg-light">
                <form name="login" action="autho" method="post">
                    <div class="mt-3 mb-3">
                        <label class="form-label">Username :</label>
                        <input type="text" class="form-control" name="id">
                    </div>
                    <div class="mb-3">
                        <label  class="form-label">Password :</label>
                        <input type="password" class="form-control" name="pass" >
                    </div>


                    <a href="#" class="text-decoration-none">Forgot Password?</a>

                    <button class="btn btn-primary" type="submit">Login</button>
                </form>
            </div>
        </div>
    </center>
</div>
</body>
</html>
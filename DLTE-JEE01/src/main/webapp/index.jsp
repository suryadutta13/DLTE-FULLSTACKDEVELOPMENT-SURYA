<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>customer/payee </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <script src="files/customer.js"></script>
    <style>
        span{
            color:black;
        }
    </style>
</head>
<body style="background-color: white;">
<div class="container mt-5">

    <div class="alert alert-light">
        <div class="row justify-content-between">
            <img class="col-2" src="files/SavinCardIco.png" width="300px" height="100px" />
            <p class="col-7 display-6 align-self-center text-center text-info mt-3">SavinCard its bank where common people save, get credit and grow</p>
        </div>
    </div>
    <div style="box-shadow:1px 1px 3px black ;" class="mt-1 row justify-content-center rounded-5">
        <!-- First column is slide in this landing page -->
        <div class="col-lg-9 col-sm-12 p-2">
            <video class="w-100 rounded-5" controls autoplay muted>
                <source src="files/union.mp4" />
            </video>
        </div>
        <!-- second column is current news and login navigation button -->
        <div class="col-lg-3 col-sm-12 align-self-center">
            <!-- <div class="text-warning h-100"> -->
            <div class="row justify-content-center p-1">
                <h3 class="text-center text-light bg-info rounded-5">Current News</h3>
                <div class="col-12 h-100 bg-light rounded-5 shadow-lg">
                    <marquee direction="down" class="h-50">
                        <p>Union bank now digitalized more in the form of App</p>
                        <p>Union bank now increased interest on Savings account holders</p>
                    </marquee>
                </div>
            </div>
            <div class="row justify-content-center mt-1 p-1">
                <h3 class="text-center text-light bg-info rounded-5">Banker Portal</h3>
                <form action="authenticate" method="post" name="log" class="rounded-1 shadow-lg p-1 text-info">
                    <div class="form group">
                        <label>Customer ID
                            <span id="errid"></span>
                        </label>
                        <input type="text" placeholder="Banker ID" name="bankerId" class="form-control"/>
                    </div>
                    <div class="form group">
                        <label>
                            Password
                            <span id="errpin"></span>
                        </label>
                        <input type="password" placeholder="Password" name="Password" class="form-control"/>
                    </div>
                    <div class="row mt-2 justify-content-around">
                        <input type="submit" class="col-2 btn btn-outline-danger" value="Login"/>
                        <input type="reset" class="col-2 btn btn-outline-danger" value="Cancel"/>
                    </div>
                </form>
            </div>
            <!-- </div> -->
        </div>
    </div>
</div>
</body>
</html>

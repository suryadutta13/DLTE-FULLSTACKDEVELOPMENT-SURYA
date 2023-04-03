<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Database </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

    <style>

        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
            color: #4d4d4d;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px #cccccc;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #4d4d4d;
        }

        input, textarea {
            padding: 10px;
            border-radius: 5px;
            border: none;
            width: 100%;
            box-sizing: border-box;
            margin-bottom: 20px;
            font-size: 16px;
            color: #4d4d4d;
            background-color: #f2f2f2;
        }


        input[type="submit"] {
            background-color: #4d4d4d;
            color: #ffffff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #333333;
        }

        textarea {
            height: 100px;
            resize: none;
        }
    </style>

</head>
<h1>Student Details</h1>
<body style="background-color: white;">
<div class="container mt-5">

<form method="post" action="insert">
    <div class="mt-3">
        <label class="form-label">Register Number</label>
        <input type="text"  name="Reg_no" required>
    </div>
    <div class="mt-3">
        <label class="form-label">Name</label>
        <input type="text"  name="Name" required>
    </div>
    <div class="mt-3">
        <label class="form-label">Age</label>
        <input type="number" name="Age" required>
    </div>
    <div class="mt-3">
        <label class="form-label">E-mail</label>
        <input type="email" name="Email" required>
    </div>
    <div><h3>Address Field</h3></div>

    <div class="mt-3">
        <h5>Current address</h5>

    </div>
<%--
    <div class="form-group">
        <label class="form-label">Address_id</label>
        <input type="nmber" name="a_id">
--%>

    <div class=" mt-3">
        <label class="form-label">Door_no</label>
        <input type="number"  name="Door_No" required>
    </div>
    <div class="mt-3">
        <label class="form-label">Locality</label>
        <input type="text"  name="Locality" required>
    </div>
    <div class="mt-3">
        <label class="form-label">City</label>
        <input type="text"  name="City" required>
    </div>
    <div class="mt-3">
        <label class="form-label">Pincode</label>
        <input type="number"  name="Pincode" required>
    </div>
    <div class="mt-3">
        <h5>Permanent Address</h5>


    <div class="mt-3">
        <label class="form-label">P_Door_no</label>
        <input type="number"  name="P_Door_No" required>
    </div>
    <div class="mt-3">
        <label class="form-label">P_Locality</label>
        <input type="text"  name="P_Locality" required>
    </div>
    <div class="mt-3">
        <label class="form-label">P_City</label>
        <input type="text"  name="P_City" required>
    </div>
    <div class="mt-3">
        <label class="form-label">P_Pincode</label>
        <input type="number"  name="P_Pincode" required>
    </div>
    <button type="submit">Submit</button>

    </div>

</form>



</div>
</body>
</html>

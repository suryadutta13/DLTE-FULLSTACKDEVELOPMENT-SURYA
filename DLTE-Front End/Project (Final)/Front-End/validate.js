function validateForm() {
    var customername = document.getElementById("customername").value.trim();
    var password = document.getElementById("password").value.trim();
    var isValid = true;

    if (customername == "") {
        document.getElementById("customernameError").innerHTML = "Please enter customer name.";
        isValid = false;
    } else {
        document.getElementById("customernameError").innerHTML="Please enter correct name";
    }
    if(password=="boss"){

    }
}
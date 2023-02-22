function script(){
    let json=[
        {
            "id":"surya",
            "password":"12345",
            "email":"suryadutta122@gmail.com",
            "id":456456,
            "phno":123456789

        },
        {
            "id":"san",
            "password":"1234"
        },
        {
            "id":"rocky",
            "password":"1234"
        }
    ]
    let uid=document.forms['login'].id.value;
    let uemail=document.forms['login'].email.value;
    let upass=document.forms['login'].pass.value;
    json.forEach((item) => {
        if(item.id == uid && item.password==upass || item.email == uemail && item.password ==upass){
            window.location.href="http://127.0.0.1:5500/assgg.html"
        }
    });
}
document.addEventListener("DOMContentLoaded", function() {
    let button = document.querySelector(".button");
    let inputs = document.querySelectorAll(".input");
    let form = document.querySelector("form");
    button.addEventListener("click", function() {
        if (inputs[0].value == "" && inputs[1].value == "") {
            alert("Username and password are required");
            inputs[0].focus();
            return false;
        }
        if (inputs[0].value == "") {
            alert("Username is required")
            inputs[0].focus();
            return false;
        }
        if (inputs[1].value == "") {
            alert("Password is required")
            inputs[1].focus;
            return false;
        }
    })
})
let btn1 = document.getElementById("loginBtn");
let btn2 = document.getElementById("signupBtn");

let signIn = document.getElementById("login");
let signUp = document.getElementById("signup");

btn2.addEventListener("click", function () {
    signIn.style.display = "none";
    signUp.style.display = "block";
});

btn1.addEventListener("click", function () {
    signUp.style.display = "none";
    signIn.style.display = "block";
});


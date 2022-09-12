// let prevButton = document.getElementById("prevButton");
document.addEventListener("DOMContentLoaded", function() {

    let prevButton = document.querySelector("#prevButton");
    let images = document.querySelector("ul").querySelectorAll("li");
    let nextButton = document.getElementById("nextButton");
    console.log(prevButton);
    console.log(nextButton);
    let imagesArr = [];
    for (let i = 0; i < images.length; i++) {
        imagesArr.push(images[i]);
    }
    console.log(imagesArr[3]);



    let counter = 0;
    imagesArr[counter].className = "visible";
    nextButton.addEventListener("click", function() {
        if (counter == imagesArr.length - 1) {
            counter--;
        } else
            imagesArr[counter].className = "";
        counter++;
        imagesArr[counter].className = "visible";
    })

    prevButton.addEventListener("click", function() {
        if (counter == 0) {
            counter++;
        } else
            imagesArr[counter].className = "";
        counter--;
        imagesArr[counter].className = "visible";


    })



    // let images = document.querySelector(".ul").querySelectorAll(".li");
    // let image = document.querySelector(".slider ul");

})
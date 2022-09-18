document.addEventListener("DOMContentLoaded", function() {

    let changeButton = document.getElementById("changePrice");

    let counter = 0;
    changeButton.addEventListener("click", function() {
        let currentPrice = document.getElementById("price");
        counter++;
        if (counter % 2 === 0) {
            currentPrice.type = "hidden";

        } else currentPrice.type = "text";

    })


})
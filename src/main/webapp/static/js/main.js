import {dataHandler} from "./dataHandler.js";

function init(){
    let buttons = document.querySelectorAll(".add-to-cart");
    for (let button of buttons) {
        button.addEventListener("click", addToCart);
    }
}

function increaseCartSumQuantityDisplay() {
    let cartSumQuantityDisplay = document.querySelector(".cart-sumquantity");
    let actQuantity = parseInt(cartSumQuantityDisplay.dataset.sumquantity) + 1;
    cartSumQuantityDisplay.textContent = "Cart: " + actQuantity;
    cartSumQuantityDisplay.dataset.sumquantity = actQuantity.toString();
}

function addToCart (event) {
    let button = event.target;
    let productId = button.dataset["productid"];
    let data = "productId=" + productId;
    dataHandler.sendData(data, '/');

    increaseCartSumQuantityDisplay();
}

init();

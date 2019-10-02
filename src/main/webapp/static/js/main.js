import {dataHandler} from "dataHandler.js";

function init(){
    let buttons = document.querySelectorAll(".add-to-cart");
    for (let button of buttons) {
        button.addEventListener("click", addToCart);
    }
}

function addToCart (event) {

    let button = event.target;
    let productId = button.dataset["productid"];
    let data = {
        'productId': productId,
    };
    dataHandler.sendData(data, '/');
}

init();

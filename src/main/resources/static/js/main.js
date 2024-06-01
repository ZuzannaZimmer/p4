
const getCurrentOffer = () => {
    return fetch("/api/current-offer")
        .then(response => response.json());
}

const refreshOffer = (offer) => {
    const offerTotalEl = document.querySelector("#offerTotal");
    const offerItemsCountEl = document.querySelector("#offerItemsCount");

    offerTotalEl.textContent = offer.total;
    offerItemsCountEl.textContent = offer.itemsCount;

}




const getProducts = () => {
    return fetch("/api/products")
        .then(response => response.json());
}

const createProductHtmlEl = (productData) => {
    const template = `
        <div>
            <h4>${productData.name}</h4>
            <img src="https://picsum.photos/id/810/200/300"/>
            <br><br>
            <span>${productData.price}</span><br>
            <button data-id="${productData.id}">Add to cart</button>       
        </div>
        <style>
        button {background-color: #5e5949;
            border: 2px solid #1B1B1B;
            box-sizing: border-box;
            border-radius: 16px;
            padding: 16px 32px 16px 16px;
            text-align: center;
            font-weight: 400;
            margin-top: 20px;
            cursor: pointer;
            color: white;
</style>
        `;

    const htmlEl = document.createElement("li");
    htmlEl.innerHTML = template.trim();
    return htmlEl;
}

//product as json -> product as html -> add to html list
document.addEventListener("DOMContentLoaded", ()=> {
    const productsListEl = document.querySelector('#productsList');

    getProducts()
        .then(productsAsJson => productsAsJson.map(createProductHtmlEl))
        .then(productsAsHtml => {
            productsAsHtml.forEach(el => productsListEl.appendChild(el))
        });

    getCurrentOffer()
        .then(offer => refreshOffer(offer));
});
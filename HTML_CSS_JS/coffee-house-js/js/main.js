const userSurname = document.querySelector('input[name="surname"]'); //получите элемент input с фамилией(*)
const userName = document.querySelector('input[name="name"]'); //получите элемент input с именем(*)

const goodsElements = document.querySelectorAll('[name="goods"]'); //получите элементы checkbox с товарами goods(*)
const countElements = document.querySelectorAll('input[type="number"]'); //получите элементы input с кол-вом(*)

const btn = document.querySelector(".btn"); //получите элемент button(*)
const resultElem = document.querySelector(".sum"); //получите элемент span для итоговой суммы

//создайте переменную для хранения итоговой суммы (*)
let total = 0;

//этот объект нужен для хранения количества каждого товара
//либо, вы можете создать переменные/массив для хранения значений 
const countGoods = {
    "expresso": 0,
    "americano": 0,
    "latte": 0,
    "capuchino": 0,
    "chocolate_muffin": 0,
    "blueberry_muffin": 0,
    "apple_tart": 0
}

//этот объект нужен для хранения цены каждого товара
//т.е. если товар выбран, записываем его цену, если не выбран - записываем 0
//либо, вы можете создать переменные/массив для хранения значений
const choicePriceGoods = {
    "expresso": 0,
    "americano": 0,
    "latte": 0,
    "capuchino": 0,
    "chocolate_muffin": 0,
    "blueberry_muffin": 0,
    "apple_tart": 0
}

//создайте функцию, которая будет считать итоговую сумму, подумайте над формулой.
function calculatePurchaseAmount() {
    total = 0;
    for (numKey in countGoods) {
        for (priceKey in choicePriceGoods) {
            if (numKey == priceKey && countGoods[numKey] > 0) {
                total = total + countGoods[numKey] * choicePriceGoods[priceKey];
            }
        }
    }
    return total;
}

//изменение количество продуктов
function changeNumberProducts(id, num) {
    countElements.forEach(element => {
        if (element.id == id) {
            element.value = num;
            countGoods[id] = num;
        }
    });
}

//проверка на положительное целое число
function validationNumber(num) {
    if (Math.sign(num) == 1 && Number.isInteger(num)) {
        return num;
    } else {
        return 0;
    }
}

//для каждого элемента input с кол-вом нужно повесить событие на изменение change, 
//по которому в объекте должны меняться значения на значение в input
countElements.forEach(elem => {
    elem.addEventListener("change", function () {
        changeNumberProducts(elem.id, validationNumber(parseInt(elem.value)));
        countGoods[elem.id] = parseInt(elem.value);
        resultElem.textContent = calculatePurchaseAmount();
    });
})

//для каждого элемента checkbox нужно повесить событие на изменение change, 
//по которому в объекте должны меняться значение на цену, если чекбокс выбран
//или обратно на 0, если чекбокс не выбран
goodsElements.forEach(product => {
    product.addEventListener("change", function () {
        if (product.checked) {
            choicePriceGoods[product.dataset.goods] = parseInt(product.value);
            changeNumberProducts(product.dataset.goods, 1);
        } else {
            choicePriceGoods[product.dataset.goods] = 0;
            changeNumberProducts(product.dataset.goods, 0);
        }
        resultElem.textContent = calculatePurchaseAmount();
    })
});

//по клику на кнопку должен появиться alert с текстом
//(*)для выбравших способ 1 или 2 именно внутри данного события будет происходить подсчет итоговой суммы,
//вам нужно перебрать все элементы checkbox и input в цикле
btn.addEventListener("click", function () {
    total = calculatePurchaseAmount();
    alert(`Закзчик: ${userSurname.value} ${userName.value}\nИтого: ${total} р.`);
});


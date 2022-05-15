<h1 align="center">Задание Card</h1>

### Решение: [сайт](https://stellular-bubblegum-1e904a.netlify.app/)

Вам нужно сверстать карточку для сайта из [макета](https://www.figma.com/file/IIf4XPgZlWiY29cjsO4Knk/Cards-for-course?node-id=1%3A2) 

[ссылка на макет psd (яндекс.диск)](https://yadi.sk/i/aNr6XZs4us0GUw)

<p align="center"><img src="https://ucarecdn.com/fd240a06-9de9-43c4-abd8-be4b312e8168/" width="900"></p>

<h3 align="center">Характеристики страницы</h3>

Для осуществления проверки выполнения задания установим следующие названия классов у элементов и сами элементы.
  
У вас могут быть и другие элементы, нужные для верстки (например, дополнительные div).

Внутри элемента `div` с классом `card` присутствует:
1. Элемент `div` с классом `card__image`.
2. Элемент `div` с классом `card__content`.
    1. Элемент `div` с классом `card__title`.
    2. Элемент `div` с классом `card__text`.
    3. Элемент `button` с классом `card__btn`.

Цвета, используемые на странице:
* Синий #2797B2
* Черный #000000
* Белый #FFFFFF

Ко всей странице применен шрифт Exo 2 (его нужно подключить с помощью Google Fonts).

Картинка доступна по адресу: [https://source.unsplash.com/T7K4aEPoGGk/1600x900](https://source.unsplash.com/T7K4aEPoGGk/1600x900)

Задайте необходимые hover-эффекты на ваш вкус.

В задании не проверяется точность margin и padding, однако задание проверяет такие css-свойства, как: width, font-family, font-size, font-weight, color, background-color (background), text-decoration, text-transform, cursor ...

Элементы, которые должны быть стилизованы с помощью flexbox имеют уточнения.

<details>
<summary><h3>Подсказка (что делать с картинкой)</h3></summary>
  
Чтобы картинка была по размеру вашего элемента div, внутри которого она находится, нужно задать следующие свойства тегу img
  ```
  img{
    width: 100%;
    height: 100%;
    border-radius: 10px 10px 0px 0px;
}
  ```

</details>

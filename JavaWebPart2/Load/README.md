<h1 align="center">Задание</h1>

Cкачайте тестируюущее приложение (HW05) [по ссылке](https://stepik.org/media/attachments/lesson/12512/HW05.zip).

#### Задача:
Написать `AccountServer`, который будет содержать переменную "разрешенное количество пользователей на сервере" (`usersLimit`).
Задать значение этой переменной по умолчанию -- 10.

Написать сервлет, который будет обрабатывать запросы на `/admin`.
При получении **GET** запроса возвращать значение `usersLimit`.
То есть, сразу после старта сервер на **GET** запрос на `/admin` вернет страницу: 
<br>10

Вывести значение `usersLimit` в **JMX** с именем:
<br>`Admin:type=AccountServerController.usersLimit`
<br>Сделать значение этой переменной изменяемым.

#### Инструкция подготовки к локальной проверке:
Соберите сервер со всеми зависимостями на библиотеки в _server.jar_
Для этого запустите _Maven projects/_<_Project name_>_/Plugins/assembly/assembly:single_
либо _assembly.sh (assembly.bat)_

Скопируйте _server.jar_ на уровень _src_ и запустите
`java -jar server.jar`

В логах консоли вы должны увидеть сообщения о старте сервера.
Проверьте, что сервер отвечает на запросы браузера.

#### Инструкция подготовки к автоматической проверке:
Добавьте в лог сообщение `"Server started"`. По появлению в логе этого сообщения тестирующая система пойдет, что к вашему серверу можно обращаться.
Соберите _server.jar_ содержащий все библиотеки.

Во время проверки тестовая система:
<br>запустит ваш сервер,
<br>подождет пока `"Server started"`,
<br>проверит через **JMX**, что значение по умолчанию == 10
<br>отправит запрос на `/admin` и проверит, что ответ == 10
<br>изменит значение на какое-то число N (0 < N < Integer.MAX_VALUE)
<br>проверит через **JMX**, что значение == N
<br>отправит запрос на `/admin` и проверит, что ответ == N

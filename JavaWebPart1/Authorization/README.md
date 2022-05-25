<h1 align="center">Update</h1>

Я обновил пример для этого занятия на [github](https://github.com/vitaly-chibrikov/stepic_java_webserver/tree/master/L1.1%20Simple%20web%20server)

Теперь в pom.xml вы найдете пример инструкций для сборки server.jar.

И скрипты _assembly.(bat/sh)_ и _start.(bat/sh)_ для сборки и запуска.

<h1 align="center">Задание</h1>

Cкачайте тестируюущее приложение (HW01) [по ссылке](https://stepik.org/media/attachments/lesson/12196/HW01.zip).

Задача:
Написать сервлет, который будет обрабатывать запросы на __/mirror__
При получении **GET** запроса с параметром `key=value` сервлет должен вернуть в `response` строку содержащую `value`.
Например, при **GET** запросе __/mirror?key=hello__ сервер должен вернуть страницу, на которой есть слово `"hello"`.

Инструкция подготовки к локальной проверке:
Соберите сервер со всеми зависимостями на библиотеки в _server.jar_
Для этого запустите _Maven projects/_<_Project name_>_/Plugins/assembly/assembly:single_
либо _assembly.sh (assembly.bat)_

Запустите _start.(sh/bat)_
_java -jar server.jar_

В логах консоли вы должны увидеть сообщения о старте сервера. Проверьте, что сервер отвечает на запросы браузера.

Инструкция подготовки к автоматической проверке:
Добавьте в лог сообщение `"Server started"`. По появлению в логе этого сообщения тестирующая система пойдет, что к вашему серверу можно обращаться.
Соберите server.jar содержащий все библиотеки.
  
Во время проверки тестовая система запускает ваш сервер, ждет пока `"Server started"`, посылает **GET** запрос на
[http://localhost:8080/mirror?key=value](http://localhost:8080/mirror?key=value)
и проверяет, что в ответ пришла страница содержащая только `value`

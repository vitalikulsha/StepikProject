<h1 align="center">Задание</h1>

Cкачайте тестируюущее приложение (HW02) [по ссылке](https://stepik.org/media/attachments/lesson/13016/HW06.zip).

#### Задача:
Добавить в сервер класс `resources.TestResource`

        public class TestResource {
          private String name;
          private int age;

          public TestResource(String name, int age) {
              this.name = name;
              this.age = age;
          }

          public TestResource() {
              this.name = "";
              this.age = 0;
          }

          public String getName() {
              return name;
          }

          public int getAge() {
              return age;
          }
        }

Написать `ResourceServer`, который будет содержать ссылку на `TestResource`.
<br>Вывести `ResourceServer` в **JMX** с именем: `Admin:type=ResourceServerController`
<br>Сделать переменные `name` и `age` доступными для чтения из **JMX** клиента.

Написать сервлет, который будет обрабатывать запросы на `/resources`.
<br>При получении **POST** запроса с параметром `path=path_to_resource`
прочитает ресурс `TestResource` из указанного в параметре файла и сохранит ссылку в `ResourceService`

После чтения, значения `name` и `age` должны быть доступны по **JMX**.

#### Инструкция подготовки к локальной проверке:
Соберите сервер со всеми зависимостями на библиотеки в _server.jar_. 
Для этого запустите _Maven projects/_<_Project name_>_/Plugins/assembly/assembly:single_
либо _assembly.sh (assembly.bat)_

Скопируйте _server.jar_ на уровень _src_ и запустите
`java -jar server.jar`

В логах консоли вы должны увидеть сообщения о старте сервера.
Проверьте, что сервер отвечает на запросы браузера.

#### Инструкция подготовки к автоматической проверке:
Добавьте в лог сообщение `"Server started"`. По появлению в логе этого сообщения тестирующая система пойдет, что к вашему серверу можно обращаться.
Соберите _server.jar_, содержащий все библиотеки.

Во время проверки тестовая система:
<br>запустит ваш сервер,
<br>подождет пока `"Server started"`,
<br>создаст файл _resource.xml_ в локальной файловой системе,
<br>пришлет по **POST** запросу имя этого файла в сервер,
<br>проверит через **JMX**, что значение `name` и `age` совпадают с записанными

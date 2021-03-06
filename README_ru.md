# Целочисленный калькулятор

Калькулятор поддерживает базовые операции над целочисленными числами - сложение, вычитание, умножение и деление.

Проект является адаптером над SOAP-сервисом калькулятора http://www.dneonline.com/calculator.asmx для взаимодействия через REST JSON.

К проекту подключен Swagger, доступ по http://localhost:8080/swagger-ui.html.
![Image of Swagger](https://github.com/mtdr/soap-facade/blob/master/swagger_pic.png)

В проекте реализована "оптимизация", где содержится обработка простейших случаев (деление на 1, вычитание или сложение с 0, умножение на 0). 

Была разработана иерархия сообщений, которая позволяет в унифицированном виде возвращать как успешные результаты, так и сообщения с ошибками. 

Ошибки порождаются механизмом отлова исключений, специфичных для выполняемых задач. 

Система исключений была реализована в виде двух примитивных наследников RuntimeException для исключений по аргументам и по результату операций. 

Автоматизированное тестирование представлено как юнит тестами, так и интеграционными веб-тестами, через замоканный сервис.

# Simple integer calculator

REST Application supporting basic operations on integers (addition, subtraction, multiplication, division). It is an education project for practice in Spring Boot, REST and SOAP information interaction and data exchange, implementing GoF adapter pattern in practice.

Project is a REST JSON adapter on SOAP calculator service (http://www.dneonline.com/calculator.asmx) with some pre-processing for request error handling and optimization. 

Swagger is connected and available after local deploying at: http://localhost:8080/swagger-ui.html

REST system of project based on unified JSON success and error response messages, which extends BaseResponseMessage. BaseResponseMessage guarantees that in message will be boolean flag "isSuccess" and integer "statusCode" (simple hhtp status 400 for errors in request, 404 for errors while processing and 200 for successfully processing). Throwables extend RuntimeException and are handled by SoapFacadeExceptionHandler annotated by "@ControllerAdvice". 

Project contains unit tests at com.edu.mtdr.soapfacade.UnitTests for 4 service operations. Integration testing is presented at com.edu.mtdr.soapfacade.ControllerTest and contains mocked service and MockMVC for Controller testing.

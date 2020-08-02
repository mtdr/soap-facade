package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.wsdl.AddResponse;
import com.edu.mtdr.soapfacade.wsdl.EnvelopeResponse;
import com.edu.mtdr.soapfacade.wsdl.MultiplyResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapFacadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapFacadeApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(AdditionClient additionClient) {
        return args -> {
            MultiplyResponse response = additionClient.getMultiplyResult();
            System.err.println(response.getMultiplyResult());
        };
    }

}

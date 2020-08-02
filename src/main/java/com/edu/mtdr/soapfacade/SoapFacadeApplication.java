package com.edu.mtdr.soapfacade;

import com.edu.mtdr.soapfacade.service.SoapClient;
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
    CommandLineRunner lookup(SoapClient soapClient) {
        return args -> {
            MultiplyResponse response = soapClient.getMultiplyResult(5, 10);
            System.err.println(response.getMultiplyResult());
        };
    }

}

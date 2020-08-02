package com.edu.mtdr.soapfacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class AdditionConfiguration {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.edu.mtdr.soapfacade.wsdl");
        return marshaller;
    }

    @Bean
    public AdditionClient additionClient(Jaxb2Marshaller marshaller) {
        AdditionClient client = new AdditionClient();
        client.setDefaultUri("http://tempuri.org/Add");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}

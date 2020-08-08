package com.edu.mtdr.soapfacade.config;

import com.edu.mtdr.soapfacade.util.SoapSenderUtil;
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
        marshaller.setContextPath("com.edu.mtdr.soapfacade.model.soapMsgs");
        return marshaller;
    }

    @Bean
    public SoapSenderUtil additionClient(Jaxb2Marshaller marshaller) {
        SoapSenderUtil soapSenderUtil = new SoapSenderUtil();
        soapSenderUtil.setDefaultUri("http://tempuri.org/Add");
        soapSenderUtil.setMarshaller(marshaller);
        soapSenderUtil.setUnmarshaller(marshaller);
        return soapSenderUtil;
    }
}

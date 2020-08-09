package com.edu.mtdr.soapfacade.config;

import com.edu.mtdr.soapfacade.util.SoapExchangeUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Configuration for SOAP marshaller registration
 */
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
    public SoapExchangeUtil additionClient(Jaxb2Marshaller marshaller) {
        SoapExchangeUtil soapExchangeUtil = new SoapExchangeUtil();
        soapExchangeUtil.setDefaultUri("http://tempuri.org/Add");
        soapExchangeUtil.setMarshaller(marshaller);
        soapExchangeUtil.setUnmarshaller(marshaller);
        return soapExchangeUtil;
    }
}

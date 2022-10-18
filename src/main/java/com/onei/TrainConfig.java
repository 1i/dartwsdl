package com.onei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class TrainConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in gradle
        marshaller.setContextPath("com.onei.irishrail.wsdl");
        return marshaller;
    }

    @Bean
    public TrainClient countryClient(Jaxb2Marshaller marshaller) {
        TrainClient client = new TrainClient();
        client.setDefaultUri("http://api.irishrail.ie/realtime/realtime.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
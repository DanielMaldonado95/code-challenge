package com.codechallangeapi.apirest.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.codechallangesoap.soapservice.soap");
		return marshaller;
	}

	@Bean
	public SoapClient soapClient(Jaxb2Marshaller marshaller) {
		SoapClient soapClient = new SoapClient();
		soapClient.setDefaultUri("http://localhost:8085/ws");
		soapClient.setMarshaller(marshaller);
		soapClient.setUnmarshaller(marshaller);
		return soapClient;
	}
}

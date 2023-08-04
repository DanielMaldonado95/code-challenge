package com.codechallangeapi.apirest.configurations;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.codechallangesoap.soapservice.soap.ActualizarClienteRequest;
import com.codechallangesoap.soapservice.soap.ActualizarClienteResponse;
import com.codechallangesoap.soapservice.soap.EliminarClienteRequest;
import com.codechallangesoap.soapservice.soap.EliminarClienteResponse;
import com.codechallangesoap.soapservice.soap.GuardarClienteRequest;
import com.codechallangesoap.soapservice.soap.GuardarClienteResponse;

public class SoapClient extends WebServiceGatewaySupport {

	public GuardarClienteResponse soapGuardarCliente(GuardarClienteRequest request) {
		GuardarClienteResponse response = (GuardarClienteResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8085/ws/guardarClienteRequest", request,
				new SoapActionCallback("http://www.codechallange.com/"));
		return response;
	}

	public ActualizarClienteResponse soapActualizarCliente(ActualizarClienteRequest request) {
		ActualizarClienteResponse response = (ActualizarClienteResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8085/ws/actualizarClienteRequest", request,
				new SoapActionCallback("http://www.codechallange.com/"));
		return response;
	}

	public EliminarClienteResponse soapEliminarCliente(EliminarClienteRequest request) {
		EliminarClienteResponse response = (EliminarClienteResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8085/ws/eliminarClienteRequest", request,
				new SoapActionCallback("http://www.codechallange.com/"));
		return response;
	}
}

package com.codechallangeapi.apirest.configurations;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.codechallangesoap.soapservice.soap.ActualizarClienteRequest;
import com.codechallangesoap.soapservice.soap.ActualizarClienteResponse;
import com.codechallangesoap.soapservice.soap.ActualizarCuentaRequest;
import com.codechallangesoap.soapservice.soap.ActualizarCuentaResponse;
import com.codechallangesoap.soapservice.soap.EliminarClienteRequest;
import com.codechallangesoap.soapservice.soap.EliminarClienteResponse;
import com.codechallangesoap.soapservice.soap.EliminarCuentaRequest;
import com.codechallangesoap.soapservice.soap.EliminarCuentaResponse;
import com.codechallangesoap.soapservice.soap.GuardarClienteRequest;
import com.codechallangesoap.soapservice.soap.GuardarClienteResponse;
import com.codechallangesoap.soapservice.soap.GuardarCuentaRequest;
import com.codechallangesoap.soapservice.soap.GuardarCuentaResponse;
import com.codechallangesoap.soapservice.soap.GuardarMovimientoRequest;
import com.codechallangesoap.soapservice.soap.GuardarMovimientoResponse;

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

	public GuardarCuentaResponse soapGuardarCuenta(GuardarCuentaRequest request) {
		GuardarCuentaResponse response = (GuardarCuentaResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8085/ws/guardarCuentaRequest", request,
				new SoapActionCallback("http://www.codechallange.com/"));
		return response;
	}

	public ActualizarCuentaResponse soapActualizarCuenta(ActualizarCuentaRequest request) {
		ActualizarCuentaResponse response = (ActualizarCuentaResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8085/ws/actualizarCuentaRequest", request,
				new SoapActionCallback("http://www.codechallange.com/"));
		return response;
	}

	public EliminarCuentaResponse soapEliminarCuenta(EliminarCuentaRequest request) {
		EliminarCuentaResponse response = (EliminarCuentaResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8085/ws/eliminarCuentaRequest", request,
				new SoapActionCallback("http://www.codechallange.com/"));
		return response;
	}

	public GuardarMovimientoResponse soapGuardarMovimiento(GuardarMovimientoRequest request) {
		GuardarMovimientoResponse response = (GuardarMovimientoResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8085/ws/guardarMovimientoRequest", request,
				new SoapActionCallback("http://www.codechallange.com/"));
		return response;
	}
}

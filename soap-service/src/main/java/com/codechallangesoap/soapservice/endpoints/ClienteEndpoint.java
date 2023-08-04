package com.codechallangesoap.soapservice.endpoints;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.codechallangesoap.soapservice.entities.ClienteEntity;
import com.codechallangesoap.soapservice.services.ClienteService;
import com.codechallangesoap.soapservice.soap.ActualizarClienteRequest;
import com.codechallangesoap.soapservice.soap.ActualizarClienteResponse;
import com.codechallangesoap.soapservice.soap.Cliente;
import com.codechallangesoap.soapservice.soap.EliminarClienteRequest;
import com.codechallangesoap.soapservice.soap.EliminarClienteResponse;
import com.codechallangesoap.soapservice.soap.Estado;
import com.codechallangesoap.soapservice.soap.GuardarClienteRequest;
import com.codechallangesoap.soapservice.soap.GuardarClienteResponse;

@Endpoint
public class ClienteEndpoint {
	@Autowired
	private ClienteService clienteService;
	private static final String NAMESPACE_URI = "http://www.codechallange.com/";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "guardarClienteRequest")
	@ResponsePayload
	public GuardarClienteResponse guardarClienteRequest(@RequestPayload GuardarClienteRequest request)
			throws DatatypeConfigurationException {
		GuardarClienteResponse response = new GuardarClienteResponse();
		ClienteEntity clienteEntityTemp = new ClienteEntity();
		Estado estado = new Estado();

		if (request != null) {
			clienteEntityTemp.setIdCliente(0);
			BeanUtils.copyProperties(request, clienteEntityTemp);
			clienteEntityTemp.setFechaNacimiento(LocalDate.of(request.getFechaNacimiento().getYear(),
					request.getFechaNacimiento().getMonth(), request.getFechaNacimiento().getDay()));
		}

		var respTemp = clienteService.guardar(clienteEntityTemp);
		if (respTemp.containsKey("data")) {
			estado.setEstado("Success");
			estado.setMensaje("Registro ingresado correctamente");
			response.setEstado(estado);
			Cliente clienteTemp = new Cliente();
			BeanUtils.copyProperties(respTemp.get("data"), clienteTemp);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(
					ClienteEntity.class.cast(respTemp.get("data")).getFechaNacimiento().toString());
			clienteTemp.setFechaNacimiento(xmlGregorianCalendar);
			response.setCliente(clienteTemp);
		} else {
			estado.setEstado("Error");
			estado.setMensaje(respTemp.get("error").toString());
			response.setEstado(estado);
			response.setCliente(null);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "actualizarClienteRequest")
	@ResponsePayload
	public ActualizarClienteResponse actualizarClienteRequest(@RequestPayload ActualizarClienteRequest request) {
		ActualizarClienteResponse response = new ActualizarClienteResponse();
		ClienteEntity clienteTemp = new ClienteEntity();
		Estado estado = new Estado();
		var respTemp = clienteService.buscar(request.getCliente().getIdCliente());
		if (respTemp.containsKey("data")) {
			if (request.getCliente() != null) {
				clienteTemp.setIdCliente(request.getCliente().getIdCliente());
				clienteTemp.setNombre(request.getCliente().getNombre());
				clienteTemp.setIdentificacion(request.getCliente().getIdentificacion());
				clienteTemp.setTipoIdentifiacion(request.getCliente().getTipoIdentifiacion());
				clienteTemp.setFechaNacimiento(LocalDate.of(request.getCliente().getFechaNacimiento().getYear(),
						request.getCliente().getFechaNacimiento().getMonth(),
						request.getCliente().getFechaNacimiento().getDay()));
			}

			respTemp = clienteService.guardar(clienteTemp);
			if (respTemp.containsKey("data")) {
				estado.setEstado("Success");
				estado.setMensaje("Registro actualizado correctamente");
				response.setEstado(estado);
				response.setCliente(request.getCliente());
			} else {
				estado.setEstado("Error");
				estado.setMensaje(respTemp.get("error").toString());
				response.setEstado(estado);
				response.setCliente(null);
			}
		} else {
			estado.setEstado("Error");
			estado.setMensaje(
					respTemp.containsKey("info") ? respTemp.get("info").toString() : respTemp.get("error").toString());
			response.setEstado(estado);
			response.setCliente(null);
		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "eliminarClienteRequest")
	@ResponsePayload
	public EliminarClienteResponse eliminarClienteRequest(@RequestPayload EliminarClienteRequest resquest) {
		EliminarClienteResponse response = new EliminarClienteResponse();
		Estado estado = new Estado();
		var respTemp = clienteService.eliminar(resquest.getIdCliente());
		if (respTemp.containsKey("data")) {
			estado.setEstado("Succes");
			estado.setMensaje(respTemp.get("data").toString());
		} else {
			estado.setEstado("Error");
			estado.setMensaje(
					respTemp.containsKey("info") ? respTemp.get("info").toString() : respTemp.get("error").toString());
		}
		response.setEstado(estado);
		return response;
	}
}

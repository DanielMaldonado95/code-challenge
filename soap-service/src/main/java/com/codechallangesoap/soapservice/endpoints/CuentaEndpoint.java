package com.codechallangesoap.soapservice.endpoints;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.codechallangesoap.soapservice.entities.ClienteEntity;
import com.codechallangesoap.soapservice.entities.CuentaEntity;
import com.codechallangesoap.soapservice.services.CuentaService;
import com.codechallangesoap.soapservice.soap.ActualizarCuentaRequest;
import com.codechallangesoap.soapservice.soap.ActualizarCuentaResponse;
import com.codechallangesoap.soapservice.soap.Cuenta;
import com.codechallangesoap.soapservice.soap.EliminarCuentaRequest;
import com.codechallangesoap.soapservice.soap.EliminarCuentaResponse;
import com.codechallangesoap.soapservice.soap.Estado;
import com.codechallangesoap.soapservice.soap.GuardarCuentaRequest;
import com.codechallangesoap.soapservice.soap.GuardarCuentaResponse;

@Endpoint
public class CuentaEndpoint {
	@Autowired
	private CuentaService cuentaService;
	private static final String NAMESPACE_URI = "http://www.codechallange.com/";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "guardarCuentaRequest")
	@ResponsePayload
	public GuardarCuentaResponse guardarCuentaResponse(@RequestPayload GuardarCuentaRequest request) {
		GuardarCuentaResponse response = new GuardarCuentaResponse();
		CuentaEntity cuentaEntity = new CuentaEntity();
		Estado estado = new Estado();
		if (request != null) {
			ClienteEntity clienteTemp = new ClienteEntity();
			cuentaEntity.setNumeroCuenta(request.getNumeroCuenta());
			cuentaEntity.setEstadoCuenta(request.isEstadoCuenta());
			cuentaEntity.setSaldo(request.getSaldo());
			cuentaEntity.setFechaApartura(LocalDate.now());
			cuentaEntity.setHoraApertura(LocalTime.now());
			clienteTemp.setIdCliente(request.getCliente().getIdCliente());
			clienteTemp.setNombre(request.getCliente().getNombre());
			clienteTemp.setIdentificacion(request.getCliente().getIdentificacion());
			clienteTemp.setTipoIdentifiacion(request.getCliente().getIdentificacion());
			clienteTemp.setFechaNacimiento(LocalDate.of(request.getCliente().getFechaNacimiento().getYear(),
					request.getCliente().getFechaNacimiento().getMonth(),
					request.getCliente().getFechaNacimiento().getDay()));
			cuentaEntity.setClienteEntity(clienteTemp);
		}
		var respTemp = cuentaService.guardar(cuentaEntity);
		if (respTemp.containsKey("data")) {
			estado.setEstado("Success");
			estado.setMensaje("Registro ingresado correctamente");
			response.setEstado(estado);
			Cuenta cuentaTemp = new Cuenta();
			BeanUtils.copyProperties(respTemp.get("data"), cuentaTemp);
			response.setCuenta(cuentaTemp);

		} else {
			estado.setEstado("Error");
			estado.setMensaje(respTemp.get("error").toString());
			response.setEstado(estado);
			response.setCuenta(null);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "actualizarCuentaRequest")
	@ResponsePayload
	public ActualizarCuentaResponse actualizarCuentaResponse(@RequestPayload ActualizarCuentaRequest request) {
		ActualizarCuentaResponse response = new ActualizarCuentaResponse();
		CuentaEntity cuentaEntity = new CuentaEntity();
		Estado estado = new Estado();
		var respTemp = cuentaService.buscar(request.getNumeroCuenta());
		if (respTemp.containsKey("data")) {
			BeanUtils.copyProperties(respTemp.get("data"), cuentaEntity);
			cuentaEntity.setSaldo(request.getSaldo());
			respTemp = cuentaService.guardar(cuentaEntity);
			if (respTemp.containsKey("data")) {
				estado.setEstado("Success");
				estado.setMensaje("Registro actualizado correctamente");
				response.setEstado(estado);
				Cuenta cuentaTemp = new Cuenta();
				BeanUtils.copyProperties(cuentaEntity, cuentaTemp);
				response.setCuenta(cuentaTemp);
			} else {
				estado.setEstado("Error");
				estado.setMensaje(respTemp.get("error").toString());
				response.setEstado(estado);
				response.setCuenta(null);
			}
		} else {
			estado.setEstado("Error");
			estado.setMensaje(
					respTemp.containsKey("info") ? respTemp.get("info").toString() : respTemp.get("error").toString());
			response.setEstado(estado);
			response.setCuenta(null);
		}
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "eliminarCuentaRequest")
	@ResponsePayload
	public EliminarCuentaResponse eliminarCuentaResponse(@RequestPayload EliminarCuentaRequest request) {
		EliminarCuentaResponse response = new EliminarCuentaResponse();
		Estado estado = new Estado();
		var respTemp = cuentaService.eliminar(request.getNumeroCuenta());
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

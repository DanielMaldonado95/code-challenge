package com.codechallangesoap.soapservice.endpoints;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.codechallangesoap.soapservice.entities.CuentaEntity;
import com.codechallangesoap.soapservice.entities.MovimientoEntity;
import com.codechallangesoap.soapservice.services.CuentaService;
import com.codechallangesoap.soapservice.services.MovimientoService;
import com.codechallangesoap.soapservice.soap.Estado;
import com.codechallangesoap.soapservice.soap.GuardarMovimientoRequest;
import com.codechallangesoap.soapservice.soap.GuardarMovimientoResponse;
import com.codechallangesoap.soapservice.soap.Movimiento;

@Endpoint
public class MovimientoEnpoint {
	@Autowired
	private MovimientoService movimientoService;
	@Autowired
	private CuentaService cuentaService;
	private static final String NAMESPACE_URI = "http://www.codechallange.com/";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "guardarMovimientoRequest")
	@ResponsePayload
	public GuardarMovimientoResponse guardarMovimientoResponse(@RequestPayload GuardarMovimientoRequest request) {
		GuardarMovimientoResponse response = new GuardarMovimientoResponse();
		MovimientoEntity movimientoEntity = new MovimientoEntity();
		Estado estado = new Estado();
		var cuentaOrigenTemp = cuentaService.buscar(request.getMovimiento().getCuentaOrigen());
		var cuentaDestinoTemp = cuentaService.buscar(request.getMovimiento().getCuentaDestino());
		if (request != null && cuentaOrigenTemp.containsKey("data") && cuentaDestinoTemp.containsKey("data")) {
			movimientoEntity.setNumeroReferencia(request.getMovimiento().getNumeroReferencia());
			movimientoEntity.setCuentaOrigen(CuentaEntity.class.cast(cuentaOrigenTemp.get("data")));
			movimientoEntity.setCuentaDestino(CuentaEntity.class.cast(cuentaDestinoTemp.get("data")));
			movimientoEntity.setFechaMovimiento(LocalDate.now());
			movimientoEntity.setHoraMovimiento(LocalTime.now());
			movimientoEntity.setTipoMovimiento(request.getMovimiento().getTipoMovimiento());
			movimientoEntity.setMonto(request.getMovimiento().getMonto());
		}
		var respTemp = movimientoService.guardar(movimientoEntity);
		if (respTemp.containsKey("data")) {
			estado.setEstado("Success");
			estado.setMensaje("Registro ingresado correctamente");
			response.setEstado(estado);
			Movimiento movimientoTemp = new Movimiento();
			movimientoTemp.setCuentaOrigen(
					MovimientoEntity.class.cast(respTemp.get("data")).getCuentaOrigen().getNumeroCuenta());
			movimientoTemp.setCuentaDestino(
					MovimientoEntity.class.cast(respTemp.get("data")).getCuentaDestino().getNumeroCuenta());
			BeanUtils.copyProperties(respTemp.get("data"), movimientoTemp);
			response.setMovimiento(movimientoTemp);

		} else {
			estado.setEstado("Error");
			estado.setMensaje(respTemp.containsKey("error") ? respTemp.get("error").toString()
					: "La cuenta de origen y/o destino no fue encontrada.");
			response.setEstado(estado);
			response.setMovimiento(null);
		}
		return response;
	}
}

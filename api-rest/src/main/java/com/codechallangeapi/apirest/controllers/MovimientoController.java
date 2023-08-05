package com.codechallangeapi.apirest.controllers;

import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codechallangeapi.apirest.configurations.SoapClient;
import com.codechallangeapi.apirest.entities.MovimientoEntity;
import com.codechallangeapi.apirest.services.MovimientoService;
import com.codechallangesoap.soapservice.soap.GuardarMovimientoRequest;
import com.codechallangesoap.soapservice.soap.Movimiento;

@RestController
@RequestMapping(path = "/code-challenge/api/v1")
public class MovimientoController {
	@Autowired
	private MovimientoService movimientoService;
	@Autowired
	private SoapClient soapClient;
	
	@GetMapping(path = "/movimientos")
	public Map<String, Object> obtenerCuentas() {
		return movimientoService.obtener();
	}

	@GetMapping(path = "/movimiento/{id}")
	public Map<String, Object> buscarCuenta(@PathVariable long id) {
		return movimientoService.buscar(id);
	}
	
	@PostMapping(path = "/guardar/movimiento")
	public ResponseEntity<?> guardarCuenta(@RequestBody MovimientoEntity movimientoEntity)
			throws DatatypeConfigurationException {
		GuardarMovimientoRequest request = new GuardarMovimientoRequest();
		if (movimientoEntity != null) {
			Movimiento movimientoTemp = new Movimiento();
			movimientoTemp.setNumeroReferencia(movimientoEntity.getNumeroReferencia());
			movimientoTemp.setCuentaOrigen(movimientoEntity.getCuentaOrigen().getNumeroCuenta());
			movimientoTemp.setCuentaDestino(movimientoEntity.getCuentaDestino().getNumeroCuenta());
			movimientoTemp.setMonto(movimientoEntity.getMonto());
			movimientoTemp.setTipoMovimiento(movimientoEntity.getTipoMovimiento());
			request.setMovimiento(movimientoTemp);
		}
		return ResponseEntity.ok(soapClient.soapGuardarMovimiento(request));
	}
}

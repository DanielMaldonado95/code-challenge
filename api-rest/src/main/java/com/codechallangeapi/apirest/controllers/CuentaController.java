package com.codechallangeapi.apirest.controllers;

import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codechallangeapi.apirest.configurations.SoapClient;
import com.codechallangeapi.apirest.entities.ClienteEntity;
import com.codechallangeapi.apirest.entities.CuentaEntity;
import com.codechallangeapi.apirest.services.CuentaSerivce;
import com.codechallangesoap.soapservice.soap.ActualizarClienteRequest;
import com.codechallangesoap.soapservice.soap.ActualizarCuentaRequest;
import com.codechallangesoap.soapservice.soap.Cliente;
import com.codechallangesoap.soapservice.soap.Cuenta;
import com.codechallangesoap.soapservice.soap.EliminarClienteRequest;
import com.codechallangesoap.soapservice.soap.EliminarCuentaRequest;
import com.codechallangesoap.soapservice.soap.GuardarClienteRequest;
import com.codechallangesoap.soapservice.soap.GuardarCuentaRequest;

@RestController
@RequestMapping(path = "/code-challenge/api/v1")
public class CuentaController {
	@Autowired
	private CuentaSerivce cuentaSerivce;
	@Autowired
	private SoapClient soapClient;

	@GetMapping(path = "/cuentas")
	public Map<String, Object> obtenerCuentas(@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		return cuentaSerivce.obtener(page == null ? 0 : page, size == null ? 0 : size);
	}

	@GetMapping(path = "/cuenta/{id}")
	public Map<String, Object> buscarCuenta(@PathVariable long id) {
		return cuentaSerivce.buscar(id);
	}
	
	@PostMapping(path = "/guardar/cuenta")
	public ResponseEntity<?> guardarCuenta(@RequestBody CuentaEntity cuentaEntity)
			throws DatatypeConfigurationException {
		GuardarCuentaRequest request = new GuardarCuentaRequest();
		if (cuentaEntity != null) {
			BeanUtils.copyProperties(cuentaEntity, request);
			Cliente clienteTemp = new Cliente();
			clienteTemp.setIdCliente(cuentaEntity.getClienteEntity().getIdCliente());
			clienteTemp.setIdentificacion(cuentaEntity.getClienteEntity().getIdentificacion());
			clienteTemp.setNombre(cuentaEntity.getClienteEntity().getNombre());
			clienteTemp.setTipoIdentifiacion(cuentaEntity.getClienteEntity().getTipoIdentifiacion());
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(cuentaEntity.getClienteEntity().getFechaNacimiento().toString());
			clienteTemp.setFechaNacimiento(xmlGregorianCalendar);
			request.setCliente(clienteTemp);
		}
		return ResponseEntity.ok(soapClient.soapGuardarCuenta(request));
	}

	@PutMapping(path = "/actualizar/cuenta")
	public ResponseEntity<?> actualizarCuenta(@RequestBody CuentaEntity cuentaEntity)
			throws DatatypeConfigurationException {
		ActualizarCuentaRequest request = new ActualizarCuentaRequest();
		if (cuentaEntity != null) {
			request.setNumeroCuenta(cuentaEntity.getNumeroCuenta());
			request.setEstadoCuenta(cuentaEntity.isEstadoCuenta());
			request.setSaldo(cuentaEntity.getSaldo());
		}
		return ResponseEntity.ok(soapClient.soapActualizarCuenta(request));
	}

	@DeleteMapping(path = "/eliminar/cuenta/{id}")
	public ResponseEntity<?> eliminarCuenta(@PathVariable long id) {
		EliminarCuentaRequest request = new EliminarCuentaRequest();
		request.setNumeroCuenta(id);
		return ResponseEntity.ok(soapClient.soapEliminarCuenta(request));
	}
}

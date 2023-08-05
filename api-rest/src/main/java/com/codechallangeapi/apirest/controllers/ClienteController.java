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
import com.codechallangeapi.apirest.services.ClienteService;
import com.codechallangesoap.soapservice.soap.ActualizarClienteRequest;
import com.codechallangesoap.soapservice.soap.Cliente;
import com.codechallangesoap.soapservice.soap.EliminarClienteRequest;
import com.codechallangesoap.soapservice.soap.GuardarClienteRequest;

@RestController
@RequestMapping(path = "/code-challenge/api/v1")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private SoapClient soapClient;

	@GetMapping(path = "/clientes")
	public Map<String, Object> obtenerClientes(@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "size", required = false) Integer size) {
		return clienteService.obtener(page == null ? 0 : page, size == null ? 0 : size);
	}

	@GetMapping(path = "/cliente/{id}")
	public Map<String, Object> buscarCliente(@PathVariable long id) {
		return clienteService.buscar(id);
	}

	@PostMapping(path = "/guardar/cliente")
	public ResponseEntity<?> guardarCliente(@RequestBody ClienteEntity clienteEntity)
			throws DatatypeConfigurationException {
		GuardarClienteRequest request = new GuardarClienteRequest();
		if (clienteEntity != null) {
			BeanUtils.copyProperties(clienteEntity, request);
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(clienteEntity.getFechaNacimiento().toString());
			request.setFechaNacimiento(xmlGregorianCalendar);
		}
		return ResponseEntity.ok(soapClient.soapGuardarCliente(request));
	}

	@PutMapping(path = "/actualizar/cliente")
	public ResponseEntity<?> actualizarCliente(@RequestBody ClienteEntity clienteEntity)
			throws DatatypeConfigurationException {
		ActualizarClienteRequest request = new ActualizarClienteRequest();
		if (clienteEntity != null) {
			Cliente clienteTemp = new Cliente();
			clienteTemp.setIdCliente(clienteEntity.getIdCliente());
			clienteTemp.setNombre(clienteEntity.getNombre());
			clienteTemp.setIdentificacion(clienteEntity.getIdentificacion());
			clienteTemp.setTipoIdentifiacion(clienteEntity.getTipoIdentifiacion());
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(clienteEntity.getFechaNacimiento().toString());
			clienteTemp.setFechaNacimiento(xmlGregorianCalendar);
			request.setCliente(clienteTemp);
		}
		return ResponseEntity.ok(soapClient.soapActualizarCliente(request));
	}

	@DeleteMapping(path = "/eliminar/cliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable long id) {
		EliminarClienteRequest request = new EliminarClienteRequest();
		request.setIdCliente(id);
		return ResponseEntity.ok(soapClient.soapEliminarCliente(request));
	}
}

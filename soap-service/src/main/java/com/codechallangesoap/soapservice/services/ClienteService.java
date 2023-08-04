package com.codechallangesoap.soapservice.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallangesoap.soapservice.entities.ClienteEntity;
import com.codechallangesoap.soapservice.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public Map<String, Object> buscar(long id) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			Optional<ClienteEntity> clienteTemp = clienteRepository.findById(id);
			if (clienteTemp.isPresent())
				resp.put("data", clienteTemp.get());
			else
				resp.put("info", "El registro no fue encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}

	public Map<String, Object> guardar(ClienteEntity clienteEntity) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			ClienteEntity clienteTemp = clienteRepository.save(clienteEntity);
			if (clienteTemp != null)
				resp.put("data", clienteTemp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}

	public Map<String, Object> eliminar(long id) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			if(buscar(id).containsKey("data")) {				
				clienteRepository.deleteById(id);
				resp.put("data", "El registro fue eliminado de forma exitosa");
			} else {
				resp.put("info", "El registro no fue encontrado");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}
}

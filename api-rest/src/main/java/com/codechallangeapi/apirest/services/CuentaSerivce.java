package com.codechallangeapi.apirest.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallangeapi.apirest.entities.CuentaEntity;
import com.codechallangeapi.apirest.repositories.CuentaRepository;

@Service
public class CuentaSerivce {
	@Autowired
	private CuentaRepository cuentaRepository;

	public Map<String, Object> obtener() {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			resp.put("data", cuentaRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}

	public Map<String, Object> buscar(long id) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			Optional<CuentaEntity> cuentaTemp = cuentaRepository.findById(id);
			if (cuentaTemp.isPresent())
				resp.put("data", cuentaTemp.get());
			else
				resp.put("info", "El registro no fue encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}
}

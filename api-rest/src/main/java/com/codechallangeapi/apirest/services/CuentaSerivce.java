package com.codechallangeapi.apirest.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.codechallangeapi.apirest.entities.CuentaEntity;
import com.codechallangeapi.apirest.repositories.CuentaRepository;

@Service
public class CuentaSerivce {
	@Autowired
	private CuentaRepository cuentaRepository;

	public Map<String, Object> obtener(int page, int size) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			if (page == 0 && size == 0) {
				resp.put("data", cuentaRepository.findAll());
			} else {
				PageRequest pageRequest = PageRequest.of(page, size);
				resp.put("data", cuentaRepository.findAll(pageRequest));
			}
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

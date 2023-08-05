package com.codechallangeapi.apirest.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallangeapi.apirest.entities.MovimientoEntity;
import com.codechallangeapi.apirest.repositories.MovimientoRepository;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoRepository movimientoRepository;

	public Map<String, Object> obtener() {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			resp.put("data", movimientoRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}

	public Map<String, Object> buscar(long id) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			Optional<MovimientoEntity> movimientoTemp = movimientoRepository.findById(id);
			if (movimientoTemp.isPresent())
				resp.put("data", movimientoTemp.get());
			else
				resp.put("info", "El registro no fue encontrado");
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}
}

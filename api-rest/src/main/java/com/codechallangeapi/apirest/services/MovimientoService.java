package com.codechallangeapi.apirest.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.codechallangeapi.apirest.entities.MovimientoEntity;
import com.codechallangeapi.apirest.repositories.MovimientoRepository;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoRepository movimientoRepository;

	public Map<String, Object> obtener(int page, int size) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			if (page == 0 && size == 0) {
				resp.put("data", movimientoRepository.findAll());
			} else {
				PageRequest pageRequest = PageRequest.of(page, size);
				resp.put("data", movimientoRepository.findAll(pageRequest));
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

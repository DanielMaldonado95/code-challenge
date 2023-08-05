package com.codechallangesoap.soapservice.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallangesoap.soapservice.entities.MovimientoEntity;
import com.codechallangesoap.soapservice.repositories.MovimientoRepository;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoRepository movimientoRepository;

	public Map<String, Object> guardar(MovimientoEntity movimientoEntity) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			MovimientoEntity movimientoTemp = movimientoRepository.save(movimientoEntity);
			if (movimientoTemp != null)
				resp.put("data", movimientoTemp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}
}

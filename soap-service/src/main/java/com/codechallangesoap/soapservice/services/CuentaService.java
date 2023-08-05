package com.codechallangesoap.soapservice.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codechallangesoap.soapservice.entities.CuentaEntity;
import com.codechallangesoap.soapservice.repositories.CuentaRepository;

@Service
public class CuentaService {
	@Autowired
	private CuentaRepository cuentaRepository;

	public Map<String, Object> buscar(long id) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			Optional<CuentaEntity> clienteTemp = cuentaRepository.findById(id);
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

	public Map<String, Object> guardar(CuentaEntity cuentaEntity) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			CuentaEntity cuentaTemp = cuentaRepository.save(cuentaEntity);
			if (cuentaTemp != null)
				resp.put("data", cuentaTemp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.put("error", e.getMessage());
		}
		return resp;
	}

	public Map<String, Object> eliminar(long id) {
		Map<String, Object> resp = new HashMap<String, Object>();
		try {
			if (buscar(id).containsKey("data")) {
				cuentaRepository.deleteById(id);
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

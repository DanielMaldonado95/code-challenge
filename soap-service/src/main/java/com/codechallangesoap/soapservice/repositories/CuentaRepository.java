package com.codechallangesoap.soapservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codechallangesoap.soapservice.entities.CuentaEntity;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {

}

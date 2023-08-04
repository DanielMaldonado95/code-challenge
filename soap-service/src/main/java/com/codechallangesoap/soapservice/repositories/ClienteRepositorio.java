package com.codechallangesoap.soapservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codechallangesoap.soapservice.entities.ClienteEntity;

@Repository
public interface ClienteRepositorio extends JpaRepository<ClienteEntity, Long>{

}

package com.actividad6.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actividad6.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

}

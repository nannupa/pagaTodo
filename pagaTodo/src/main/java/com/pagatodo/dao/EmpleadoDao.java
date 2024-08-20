package com.pagatodo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pagatodo.entity.Empleado;


public interface EmpleadoDao extends JpaRepository<Empleado, Long>{

}

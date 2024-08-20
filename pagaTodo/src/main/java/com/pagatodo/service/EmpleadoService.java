package com.pagatodo.service;

import java.util.List;

import com.pagatodo.entity.Empleado;

public interface EmpleadoService {
	
	public List<Empleado> findAll();
	
	public Empleado save(Empleado empleado);
	
	public Empleado findById(Long id);
	
	public void delete(Empleado empleado);

}

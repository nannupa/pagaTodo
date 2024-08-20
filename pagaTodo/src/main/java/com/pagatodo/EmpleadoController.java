package com.pagatodo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagatodo.entity.Empleado;
import com.pagatodo.service.EmpleadoService;

@RestController
@RequestMapping("emp/v1")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping(value="/empleados")
	public ResponseEntity<Object> get(){		
		try {
			List<Empleado> empleadoList = empleadoService.findAll();
			return new ResponseEntity<Object>(empleadoList, HttpStatus.OK);
		}catch(Exception e) {
			return errorInternal(e);
		}
	}

	@GetMapping(value="/empleado/{id}")
	public ResponseEntity<Object> getById(@PathVariable long id){
		try {
			Empleado emp = empleadoService.findById(id);
			return new ResponseEntity<Object>(emp, HttpStatus.OK);
		}catch(Exception e) {
			return errorInternal(e);
		}
	}
	
	@PostMapping(value="/empleadoAlta")
	public ResponseEntity<Object> create(@RequestBody Empleado empleado){
		try {
			Empleado emp = empleadoService.save(empleado);
			return new ResponseEntity<Object>(emp, HttpStatus.OK);
		}catch(Exception e) {
			return errorInternal(e);
		}
	}
	
	@PutMapping(value="/empleado/{id}")
	public ResponseEntity<Object> update(@RequestBody Empleado empleado, @PathVariable Long id){
		try {
			Empleado empActual = empleadoService.findById(id);
			
			empActual.setDep_id(empleado.getDep_id());
			empActual.setEmp_nombre(empleado.getEmp_nombre());
			empActual.setEmp_puesto(empleado.getEmp_puesto());
			
			Empleado empRes = empleadoService.save(empActual);
			
			return new ResponseEntity<Object>(empRes, HttpStatus.OK);
		}catch(Exception e) {
			return errorInternal(e);
		}
	}
	
	@DeleteMapping(value="/empleado/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		try {
			Empleado empActual = empleadoService.findById(id);
			
			empleadoService.delete(empActual);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("deleted",true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		}catch(Exception e) {
			return errorInternal(e);
		}
	}

	private ResponseEntity<Object> errorInternal(Exception e){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("message", e.getMessage());
		return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

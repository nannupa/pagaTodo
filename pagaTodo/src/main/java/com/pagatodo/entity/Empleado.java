package com.pagatodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int emp_id;
	
	@Column(name="dep_id")
	private int dep_id;
	
	@Column(name="emp_nombre")
	private String emp_nombre;
	
	@Column(name="emp_puesto")
	private String emp_puesto;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getEmp_nombre() {
		return emp_nombre;
	}
	public void setEmp_nombre(String emp_nombre) {
		this.emp_nombre = emp_nombre;
	}
	public String getEmp_puesto() {
		return emp_puesto;
	}
	public void setEmp_puesto(String emp_puesto) {
		this.emp_puesto = emp_puesto;
	}
	
}

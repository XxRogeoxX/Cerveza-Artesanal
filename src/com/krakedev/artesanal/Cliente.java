package com.krakedev.artesanal;

public class Cliente {
	private String nombre;
	private String cedula;
	private String codigo;
	private double totalConsumido;

	public Cliente(String nombre, String cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getTotalConsumido() {
		return totalConsumido;
	}

	public void setTotalConsumido(double totalConsumido) {
		this.totalConsumido = totalConsumido;
	}

}

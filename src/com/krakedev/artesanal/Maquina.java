package com.krakedev.artesanal;

public class Maquina {
	private String codigo;
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;

	// === CONTRUCTORES ===

	public Maquina(String codigo, String nombreCerveza, String descripcion, double precioPorMl, double capacidadMaxima) {
		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;
	}

	public Maquina(String codigo, String nombreCerveza, String descripcion, double precioPorMl) {
		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 10000;
		this.cantidadActual = 0;
	}

	// === GETTERS ===

	public String getCodigo() {
		return codigo;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	// === SETTERS ===

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	// === IMPRIMIR ===

	public void imprimir() {
		String mensaje;
		mensaje = "Codigo: " + codigo + ", Nombre Cerveza: " + nombreCerveza + ", Descripción: " + descripcion
				+ ", Precio por ML: " + precioPorMl + ", Capacidad Máxima: " + capacidadMaxima + ", Cantidad Actual: "
				+ cantidadActual;
		System.out.println(mensaje);
	}

	// === MÉTODOS ===

	public void llenarMaquina() {
		cantidadActual = capacidadMaxima - 200;
	}

	public boolean recargarCerveza(double cantidad) {
		if (cantidadActual + cantidad < capacidadMaxima - 200) {
			cantidadActual += cantidad;
			return true;
		} else {
			return false;
		}
	}

	public double servirCerveza(double cantidad) {
		if (cantidadActual >= cantidad) {
			cantidadActual -= cantidad;
			double valor;
			valor = cantidad * precioPorMl;
			return valor;
		}
		return 0;
	}
}

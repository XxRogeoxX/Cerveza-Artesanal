package com.krakedev.artesanal;

public class Negocio {
	private String nombre;
	private Maquina maquinaA;
	private int ultimoCodigo = 100;
	
	public Negocio() {
		
	}

	public Negocio(String nombre, Maquina maquinaA) {
		this.nombre = nombre;
		this.maquinaA = maquinaA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Maquina getMaquinaA() {
		return maquinaA;
	}

	public void setMaquinaA(Maquina maquinaA) {
		this.maquinaA = maquinaA;
	}
	
	public void asignarCodigoCliente(Cliente cliente) {
		String codigo = ultimoCodigo + "";
		cliente.setCodigo(codigo);
		ultimoCodigo++;
	}
	
	public void cargarMaquinaA() {
		maquinaA.llenarMaquina();
	}
	
	public void consumirCervezaMaquinaA(Cliente cliente, double ml) {
		double valor = maquinaA.servirCerveza(ml);
		cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);
	}
}

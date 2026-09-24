package com.krakedev.artesanal;
 
import java.util.ArrayList;
 
public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
 
	// PASO 8: para provocar el error, cambiar esta línea temporalmente por:
	// private ArrayList<Cliente> clientes;
	// PASO 11: dejarla como está abajo (corrección).
	private ArrayList<Cliente> clientes = new ArrayList<>();
 
	
 
	// === CONSTRUCTOR ===
 
	public NegocioMejorado() {
		maquinas = new ArrayList<>();
	}
 
	// === GETTERS Y SETTERS ===
 
	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}
 
	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
 
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
 
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
 
	// === PARTE 1: MÁQUINAS ===
 
	public String generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1; // 1 a 100
		return "M-" + numero;
	}
 
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		String codigo = generarCodigo();
 
		// Validación de duplicados
		if (recuperarMaquina(codigo) != null) {
			return false;
		}
 
		Maquina maquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
		maquinas.add(maquina);
		return true;
	}
 
	public void cargarMaquinas() {
		for (int i = 0; i < maquinas.size(); i++) {
			maquinas.get(i).llenarMaquina();
		}
	}
 
	public Maquina recuperarMaquina(String codigo) {
		for (int i = 0; i < maquinas.size(); i++) {
			Maquina maquina = maquinas.get(i);
			if (maquina.getCodigo().equals(codigo)) {
				return maquina;
			}
		}
		return null;
	}
 
	
}

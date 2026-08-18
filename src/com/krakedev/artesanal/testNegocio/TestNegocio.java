package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {
	public static void main(String[] args) {
		Maquina maquina1 = new Maquina("016", "Cerveza Club", "Cerveza Fría", 0.02, 8000);
		Negocio negocio1 = new Negocio("Mi Negocio", maquina1);
		
		System.out.println("Nombre: " + negocio1.getNombre());
		System.out.println("Maquina: " + negocio1.getMaquinaA());
		
		Maquina m1 = negocio1.getMaquinaA();
		double capacidad = m1.getCapacidadMaxima();
		System.out.println("Capacidad Maxima: " + capacidad);
	}
}

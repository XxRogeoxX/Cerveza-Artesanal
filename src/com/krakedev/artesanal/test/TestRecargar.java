package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {
	public static void main(String[] args) {
		boolean resultado;
		Maquina rubia = new Maquina("004", "Pilsener", "Cerveza fría", 0.02, 8000);
		
		System.out.println("-> Estado Inicial");
		rubia.imprimir();
		
		System.out.println("-> Recarga 1");
		resultado = rubia.recargarCerveza(3000);
		System.out.println("Recargando... 3000");
		
		if(resultado) {
			System.out.println("Se recargo correctamente.");
		} else {
			System.out.println("No se pudo recargar.");
		}
		rubia.imprimir();
		
		System.out.println("-> Recarga 2");
		resultado = rubia.recargarCerveza(4000);
		System.out.println("Recargando... 4000");
		
		if(resultado) {
			System.out.println("Se recargo correctamente.");
		} else {
			System.out.println("No se pudo recargar.");
		}
		rubia.imprimir();
		
		System.out.println("-> Recarga 3");
		resultado = rubia.recargarCerveza(3000);
		System.out.println("Recargando... 3000");
		
		if(resultado) {
			System.out.println("Se recargo correctamente.");
		} else {
			System.out.println("No se pudo recargar.");
		}
		rubia.imprimir();
	}
}

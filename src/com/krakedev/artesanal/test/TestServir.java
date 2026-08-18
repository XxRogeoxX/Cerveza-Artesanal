package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {
	public static void main(String[] args) {
		Maquina rubia = new Maquina("005", "Pilsener", "Cerveza fría", 0.02, 8000);
		
		System.out.println("-> Estado Inicial");
		rubia.imprimir();
		System.out.println("-> Llenando Máquina...");
		rubia.llenarMaquina();
		rubia.imprimir();
		
		System.out.println("-> Servir 1000Ml...");
		double valor;
		valor = rubia.servirCerveza(1000);
		System.out.println("Valor a pagar: " + valor + "USD");
		rubia.imprimir();
		
		System.out.println("-> Servir 2000Ml...");
		valor = rubia.servirCerveza(2000);
		System.out.println("Valor a pagar: " + valor + "USD");
		rubia.imprimir();
		
		System.out.println("-> Servir 5000Ml...");
		valor = rubia.servirCerveza(5000);
		System.out.println("Valor a pagar: " + valor + "USD");
		rubia.imprimir();
	}
}

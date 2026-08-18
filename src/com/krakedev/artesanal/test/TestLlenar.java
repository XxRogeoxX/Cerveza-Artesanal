package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {
	public static void main(String[] args) {
		Maquina rubia = new Maquina("002", "Pilsener", "Cerveza fría", 0.02, 80000);
		System.out.println("========= MAQUINA RUBIA =========");
		System.out.println("-> Estado Por Defecto");
		rubia.imprimir();
		System.out.println("-> Llenar Maquina");
		rubia.llenarMaquina();
		rubia.imprimir();

		Maquina negra = new Maquina("003", "Club", "Cerveza buena", 0.03);
		System.out.println("========= MAQUINA NEGRA =========");
		System.out.println("-> Estado Por Defecto");
		negra.imprimir();
		System.out.println("-> Llenar Maquina");
		negra.llenarMaquina();
		negra.imprimir();
	}
}

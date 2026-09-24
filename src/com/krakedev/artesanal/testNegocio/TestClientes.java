package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {
	public static void main(String[] args) {
		NegocioMejorado negocio = new NegocioMejorado();

		// Con "clientes" sin inicializar, esta línea lanza NullPointerException
		negocio.registrarCliente("Mario", "2300210967");

		// Estas líneas solo se ejecutan cuando el error ya está corregido (paso 12)
		negocio.registrarCliente("Andres", "2300678927");
		System.out.println("Total clientes: " + negocio.getClientes().size());

		Cliente c = negocio.buscarClientePorCedula("2300210967");
		System.out.println("Por cédula -> " + c.getNombre() + " (código " + c.getCodigo() + ")");

		Cliente d = negocio.buscarClientePorCodigo("101");
		System.out.println("Por código -> " + d.getNombre() + " (cédula " + d.getCedula() + ")");
	}
}
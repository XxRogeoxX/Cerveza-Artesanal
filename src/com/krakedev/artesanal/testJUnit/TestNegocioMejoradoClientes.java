package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejoradoClientes {

	@Test
	public void testListaClientesInicializada() {
		NegocioMejorado negocio = new NegocioMejorado();
		assertNotNull(negocio.getClientes());
		assertEquals(0, negocio.getClientes().size());
	}

	@Test
	public void testRegistrarClienteAsignaCodigosConsecutivos() {
		NegocioMejorado negocio = new NegocioMejorado();

		negocio.registrarCliente("Mario", "2300210967");
		negocio.registrarCliente("Andres", "2300678927");

		assertEquals(2, negocio.getClientes().size());
		assertEquals("100", negocio.getClientes().get(0).getCodigo());
		assertEquals("101", negocio.getClientes().get(1).getCodigo());
		assertEquals("Mario", negocio.getClientes().get(0).getNombre());
		assertEquals("2300678927", negocio.getClientes().get(1).getCedula());
	}

	@Test
	public void testBuscarClientePorCedula() {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Mario", "2300210967");
		negocio.registrarCliente("Andres", "2300678927");

		Cliente encontrado = negocio.buscarClientePorCedula("2300678927");

		assertNotNull(encontrado);
		assertEquals("Andres", encontrado.getNombre());
		assertNull(negocio.buscarClientePorCedula("0000000000"));
	}

	@Test
	public void testBuscarClientePorCodigo() {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.registrarCliente("Mario", "2300210967");
		negocio.registrarCliente("Andres", "2300678927");

		Cliente encontrado = negocio.buscarClientePorCodigo("100");

		assertNotNull(encontrado);
		assertEquals("Mario", encontrado.getNombre());
		assertNull(negocio.buscarClientePorCodigo("999"));
	}

	@Test
	public void testBuscarEnListaVacia() {
		NegocioMejorado negocio = new NegocioMejorado();
		assertNull(negocio.buscarClientePorCedula("2300210967"));
		assertNull(negocio.buscarClientePorCodigo("100"));
	}
}

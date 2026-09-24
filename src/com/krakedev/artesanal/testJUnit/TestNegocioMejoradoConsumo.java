package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejoradoConsumo {
	private static final double DELTA = 0.00001;

	private NegocioMejorado negocio;
	private Maquina maquina;

	@BeforeEach
	public void preparar() {
		negocio = new NegocioMejorado();
		maquina = new Maquina("M-1", "Pilsener", "Rubia", 0.002, 8000);
		negocio.getMaquinas().add(maquina);
		negocio.cargarMaquinas(); // cantidadActual = 7800

		negocio.registrarCliente("Andres", "2080027381"); // código 100
		negocio.registrarCliente("Mario", "2300210967"); // código 101
	}

	@Test
	public void testConsumirCervezaActualizaClienteYMaquina() {
		negocio.consumirCerveza("100", "M-1", 100);

		Cliente andres = negocio.buscarClientePorCodigo("100");
		assertEquals(7700, maquina.getCantidadActual(), DELTA);
		assertEquals(0.2, andres.getTotalConsumido(), DELTA);
	}

	@Test
	public void testConsumoSeAcumula() {
		negocio.consumirCerveza("100", "M-1", 100);
		negocio.consumirCerveza("100", "M-1", 200);

		Cliente andres = negocio.buscarClientePorCodigo("100");
		assertEquals(7500, maquina.getCantidadActual(), DELTA);
		assertEquals(0.6, andres.getTotalConsumido(), DELTA);
	}

	@Test
	public void testConsumoNoAfectaAOtroCliente() {
		negocio.consumirCerveza("100", "M-1", 100);

		Cliente mario = negocio.buscarClientePorCodigo("101");
		assertEquals(0, mario.getTotalConsumido(), DELTA);
	}

	@Test
	public void testRegistrarConsumoAcumula() {
		Cliente andres = negocio.buscarClientePorCodigo("100");

		negocio.registrarConsumo(andres, 5.0);
		negocio.registrarConsumo(andres, 2.5);

		assertEquals(7.5, andres.getTotalConsumido(), DELTA);
	}

	@Test
	public void testConsumirMasDeLoDisponibleNoCambiaNada() {
		negocio.consumirCerveza("100", "M-1", 50000);

		Cliente andres = negocio.buscarClientePorCodigo("100");
		assertEquals(7800, maquina.getCantidadActual(), DELTA);
		assertEquals(0, andres.getTotalConsumido(), DELTA);
	}

	@Test
	public void testConsumirConMaquinaInexistenteNoLanzaError() {
		negocio.consumirCerveza("100", "M-999", 100);

		Cliente andres = negocio.buscarClientePorCodigo("100");
		assertEquals(7800, maquina.getCantidadActual(), DELTA);
		assertEquals(0, andres.getTotalConsumido(), DELTA);
	}

	@Test
	public void testConsumirConClienteInexistenteNoLanzaError() {
		negocio.consumirCerveza("999", "M-1", 100);

		assertEquals(7800, maquina.getCantidadActual(), DELTA);
	}

	// === consultarValorVendido ===

	@Test
	public void testConsultarValorVendidoSinConsumos() {
		assertEquals(0, negocio.consultarValorVendido(), DELTA);
	}

	@Test
	public void testConsultarValorVendidoSumaTodosLosClientes() {
		negocio.consumirCerveza("100", "M-1", 100); // 0.2
		negocio.consumirCerveza("101", "M-1", 300); // 0.6
		negocio.consumirCerveza("100", "M-1", 200); // 0.4

		assertEquals(1.2, negocio.consultarValorVendido(), DELTA);
	}

	@Test
	public void testConsultarValorVendidoSinClientes() {
		NegocioMejorado vacio = new NegocioMejorado();
		assertEquals(0, vacio.consultarValorVendido(), DELTA);
	}
}
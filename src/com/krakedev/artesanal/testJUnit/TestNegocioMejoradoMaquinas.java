package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejoradoMaquinas {

	@Test
	public void testListaMaquinasInicializada() {
		NegocioMejorado negocio = new NegocioMejorado();
		assertNotNull(negocio.getMaquinas());
		assertEquals(0, negocio.getMaquinas().size());
	}

	@Test
	public void testSetMaquinas() {
		NegocioMejorado negocio = new NegocioMejorado();
		ArrayList<Maquina> lista = new ArrayList<>();
		lista.add(new Maquina("M-1", "Pilsener", "Rubia", 0.02));
		negocio.setMaquinas(lista);
		assertSame(lista, negocio.getMaquinas());
	}

	// === generarCodigo ===

	@Test
	public void testGenerarCodigoFormatoYRango() {
		NegocioMejorado negocio = new NegocioMejorado();
		for (int i = 0; i < 1000; i++) {
			String codigo = negocio.generarCodigo();
			assertTrue(codigo.matches("M-\\d{1,3}"), "Formato inválido: " + codigo);
			int numero = Integer.parseInt(codigo.substring(2));
			assertTrue(numero >= 1 && numero <= 100, "Número fuera de rango: " + codigo);
		}
	}

	// === recuperarMaquina ===

	@Test
	public void testRecuperarMaquinaExistente() {
		NegocioMejorado negocio = new NegocioMejorado();
		Maquina m1 = new Maquina("M-10", "Pilsener", "Rubia", 0.02);
		Maquina m2 = new Maquina("M-20", "Club", "Negra", 0.03);
		negocio.getMaquinas().add(m1);
		negocio.getMaquinas().add(m2);

		assertSame(m1, negocio.recuperarMaquina("M-10"));
		assertSame(m2, negocio.recuperarMaquina("M-20"));
	}

	@Test
	public void testRecuperarMaquinaInexistente() {
		NegocioMejorado negocio = new NegocioMejorado();
		negocio.getMaquinas().add(new Maquina("M-10", "Pilsener", "Rubia", 0.02));

		assertNull(negocio.recuperarMaquina("M-99"));
	}

	@Test
	public void testRecuperarMaquinaListaVacia() {
		NegocioMejorado negocio = new NegocioMejorado();
		assertNull(negocio.recuperarMaquina("M-1"));
	}

	// === agregarMaquina ===

	@Test
	public void testAgregarMaquinaExitoso() {
		NegocioMejorado negocio = new NegocioMejorado();

		boolean resultado = negocio.agregarMaquina("Pilsener", "Cerveza rubia", 0.02);

		assertTrue(resultado);
		assertEquals(1, negocio.getMaquinas().size());

		Maquina agregada = negocio.getMaquinas().get(0);
		assertTrue(agregada.getCodigo().matches("M-\\d{1,3}"));
		assertEquals("Pilsener", agregada.getNombreCerveza());
		assertEquals("Cerveza rubia", agregada.getDescripcion());
		assertEquals(0.02, agregada.getPrecioPorMl(), 0.00001);
		assertSame(agregada, negocio.recuperarMaquina(agregada.getCodigo()));
	}

	@Test
	public void testAgregarMaquinaDuplicadoRetornaFalse() {
		NegocioMejorado negocio = new NegocioMejorado();

		// Se ocupan TODOS los códigos posibles (M-1 a M-100),
		// así cualquier código generado será un duplicado.
		ArrayList<Maquina> llena = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			llena.add(new Maquina("M-" + i, "Pilsener", "Rubia", 0.02));
		}
		negocio.setMaquinas(llena);

		boolean resultado = negocio.agregarMaquina("Club", "Cerveza fría", 0.03);

		assertFalse(resultado);
		assertEquals(100, negocio.getMaquinas().size());
	}

	@Test
	public void testAgregarMaquinaNoRepiteCodigos() {
		NegocioMejorado negocio = new NegocioMejorado();
		for (int i = 0; i < 300; i++) {
			negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
		}

		ArrayList<Maquina> lista = negocio.getMaquinas();
		for (int i = 0; i < lista.size(); i++) {
			for (int j = i + 1; j < lista.size(); j++) {
				assertFalse(lista.get(i).getCodigo().equals(lista.get(j).getCodigo()),
						"Código repetido: " + lista.get(i).getCodigo());
			}
		}
	}

	// === cargarMaquinas ===

	@Test
	public void testCargarMaquinas() {
		NegocioMejorado negocio = new NegocioMejorado();
		Maquina m1 = new Maquina("M-1", "Pilsener", "Rubia", 0.02, 8000);
		Maquina m2 = new Maquina("M-2", "Club", "Negra", 0.03); // capacidad 10000
		negocio.getMaquinas().add(m1);
		negocio.getMaquinas().add(m2);

		negocio.cargarMaquinas();

		assertEquals(7800, m1.getCantidadActual(), 0.0001);
		assertEquals(9800, m2.getCantidadActual(), 0.0001);
	}
}
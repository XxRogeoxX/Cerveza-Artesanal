package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestRecargarJUnit {
	@Test
	public void testRecargaExistosa() {
		Maquina rubia = new Maquina("008", "Pilsener", "Cerveza", 0.02, 8000);
		boolean resultado = rubia.recargarCerveza(3000);
		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual(), 0.0001);
	}
	
	// Este es el único test que fallara, siguiendo con las instrucciones de los videos.
	@Test
	public void testRecargaFallidaPorDesborde() {
	    Maquina negra = new Maquina("009", "Club", "Cerveza fría", 0.03, 8000);
	    negra.recargarCerveza(7000);
	    boolean resultado = negra.recargarCerveza(1000);
	    assertFalse(resultado);
	    assertEquals(7000, negra.getCantidadActual(), 0.0001);
	}
}

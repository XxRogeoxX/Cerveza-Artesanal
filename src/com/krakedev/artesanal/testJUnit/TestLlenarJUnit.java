package com.krakedev.artesanal.testJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {

	@Test
	public void testLlenarMaquina() {
		Maquina rubia = new Maquina("007", "Pilsener", "Cerveza", 0.02, 8000);
		rubia.llenarMaquina();
		assertEquals(7800, rubia.getCantidadActual(), 0.0001);
	}
}

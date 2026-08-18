package com.krakedev.artesanal.testJUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServirCervezaAI {

    // Delta / Tolerancia permitida para las comparaciones de tipo double
    private final double DELTA = 0.001;

    // ==========================================
    // PRUEBAS CON CONSTRUCTOR DE 4 PARÁMETROS
    // ==========================================

    @Test
    @DisplayName("Debe servir correctamente cuando la máquina tiene suficiente cerveza (Constructor completo)")
    public void testServirCervezaSuficienteConstructorCompleto() {
        // Arrange (Preparación)
        // Usamos el constructor de 4 parámetros
        Maquina maquina = new Maquina("010", "IPA", "Cerveza artesanal amarga", 0.05, 5000.0);
        
        // Cargamos cerveza en la máquina usando los métodos disponibles
        maquina.llenarMaquina(); // Capacidad actual pasa a ser 4800.0 (5000.0 - 200)
        double cantidadInicial = maquina.getCantidadActual(); // 4800.0
        
        double cantidadAServir = 500.0;
        double precioEsperado = cantidadAServir * maquina.getPrecioPorMl(); // 500.0 * 0.05 = 25.0

        // Act (Ejecución)
        double valorPagado = maquina.servirCerveza(cantidadAServir);

        // Assert (Verificaciones basadas en la descripción funcional)
        // 1. Debe retornar el valor a pagar correcto
        assertEquals(precioEsperado, valorPagado, DELTA);
        
        // 2. Debe restar la cantidad servida de la cantidad actual de la máquina
        assertEquals(cantidadInicial - cantidadAServir, maquina.getCantidadActual(), DELTA);
    }

    @Test
    @DisplayName("No debe servir nada si la cantidad a servir es mayor a la cantidad disponible")
    public void testServirCervezaInsuficiente() {
        // Arrange
        Maquina maquina = new Maquina("011", "Stout", "Cerveza negra", 0.08, 2000.0);
        
        // Llenamos la máquina (queda con 1900.0 ml)
        maquina.llenarMaquina(); 
        double cantidadInicial = maquina.getCantidadActual(); // 1900.0
        
        // Intentamos servir más de lo disponible
        double cantidadAServir = 2500.0;

        // Act
        double valorPagado = maquina.servirCerveza(cantidadAServir);

        // Assert
        // 1. Si no hay suficiente cerveza, debe retornar 0
        assertEquals(0.0, valorPagado, DELTA);
        
        // 2. Si no sirve nada, la cantidad actual no debe sufrir variaciones
        assertEquals(cantidadInicial, maquina.getCantidadActual(), DELTA);
    }

    @Test
    @DisplayName("No debe servir nada si la máquina está vacía (cantidad actual es 0)")
    public void testServirCervezaMaquinaVacia() {
        // Arrange
        // Al instanciar, la máquina inicia con cantidadActual = 0
        Maquina maquina = new Maquina("014", "Red Ale", "Cerveza roja", 0.06, 3000.0);
        double cantidadInicial = maquina.getCantidadActual(); // 0.0
        
        double cantidadAServir = 300.0;

        // Act
        double valorPagado = maquina.servirCerveza(cantidadAServir);

        // Assert
        // 1. Debe retornar 0 al estar vacía
        assertEquals(0.0, valorPagado, DELTA);
        
        // 2. La cantidad actual debe mantenerse en 0
        assertEquals(cantidadInicial, maquina.getCantidadActual(), DELTA);
    }

    @Test
    @DisplayName("Debe permitir servir exactamente toda la cantidad disponible en la máquina")
    public void testServirCervezaExactamenteLaCantidadDisponible() {
        // Arrange
        Maquina maquina = new Maquina("015", "Golden", "Cerveza rubia", 0.04, 1000.0);
        
        // Agregamos cerveza utilizando recargarCerveza
        maquina.recargarCerveza(500.0); // La cantidad disponible actual es 500.0
        
        double cantidadAServir = 500.0; // Servir exactamente la totalidad disponible
        double precioEsperado = cantidadAServir * maquina.getPrecioPorMl(); // 500.0 * 0.04 = 20.0

        // Act
        double valorPagado = maquina.servirCerveza(cantidadAServir);

        // Assert
        // 1. Debe retornar el valor a pagar correspondiente
        assertEquals(precioEsperado, valorPagado, DELTA);
        
        // 2. La cantidad restante en la máquina debe quedar en 0
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);
    }

    // ==========================================
    // PRUEBAS CON CONSTRUCTOR DE 3 PARÁMETROS
    // ==========================================

    @Test
    @DisplayName("Debe servir correctamente usando el constructor de 3 parámetros (Capacidad por defecto)")
    public void testServirCervezaConstructorTresParametros() {
        // Arrange
        // Usamos el constructor de 3 parámetros
        Maquina maquina = new Maquina("017", "Pilsner", "Cerveza Pilsner clásica", 0.03);
        
        // Recargamos cerveza
        maquina.recargarCerveza(1500.0);
        double cantidadInicial = maquina.getCantidadActual(); // 1500.0
        
        double cantidadAServir = 400.0;
        double precioEsperado = cantidadAServir * maquina.getPrecioPorMl(); // 400.0 * 0.03 = 12.0

        // Act
        double valorPagado = maquina.servirCerveza(cantidadAServir);

        // Assert
        // 1. Debe retornar el valor a pagar esperado
        assertEquals(precioEsperado, valorPagado, DELTA);
        
        // 2. La cantidad actual debe reducirse en la cantidad servida
        assertEquals(cantidadInicial - cantidadAServir, maquina.getCantidadActual(), DELTA);
    }
}
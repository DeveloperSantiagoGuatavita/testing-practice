package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    private Example example;

    @BeforeEach
    public void init() {
        this.example = new Example();
    }

    @Test
    void sumar() {
        //Given (dado o teniendo)
        int numberA = 3;
        int numberB = 3;

        //When (cuando)
        int sumared = example.sumar(numberA, numberB);

        //Then (entonces)
        assertEquals(6, 6);
        assertInstanceOf(Integer.class, sumared);
    }

    @Test
    void checkPositivo() {
        int number = 3;

        boolean checkPositivo = example.checkPositivo(number);

        assertTrue(checkPositivo);
    }

    @Test
    void checkPositivoError() {
        //Given
        int number = -3;

        //When-Then
        assertThrows(IllegalArgumentException.class, () -> {
           example.checkPositivo(number);
        });
    }

    @Test
    void contarLetrasA() {
        //Given
        String cadena = "Hola";

        //When
        int letrasA = example.contarLetrasA(cadena);

        //Then
        assertNotNull(letrasA);
        assertEquals(1, letrasA);
    }

    @Test
    void contieneElemento() {
        //Given
        List<String> list = Arrays.asList("Juan", "Pedro", "Santiago");
        String element = "Santiago";

        //When
        boolean result = example.contieneElemento(list, element);

        //Then
        assertTrue(result);

    }

    @Test
    void revertirCadena() {
        //Given
        String cadena = "Hola";

        //When
        String revertiredCadena = example.revertirCadena(cadena);

        //Then
        assertEquals("aloH", revertiredCadena);
    }

    @Test
    void factorial() {
        //Given
        int i = 6;

        //When
        long factorial = example.factorial(i);

        //Then
        assertEquals(720, factorial);
    }

    @Test
    void factorialError() {
        //Given
        int i = -1;

        //When-Then
        assertThrows(IllegalArgumentException.class, () -> {
           example.factorial(i);
        });
    }

    @Test
    void esPrimo() {
        //Given
        int i = 3;

        //When
        boolean esPrimo = example.esPrimo(i);

        //Then
        assertTrue(esPrimo);
    }

    @Test
    void esPrimoMayorQueCuatro() {
        //Given
        int i = 7;

        //When
        boolean esPrimo = example.esPrimo(i);

        //Then
        assertTrue(esPrimo);
    }

    @Test
    void esPrimoMenorQueUno() {
        //Given
        int i = -1;

        //When
        boolean esPrimo = example.esPrimo(i);

        //Then
        assertFalse(esPrimo);
    }

    @Test
    void esPrimoMayorQueUno() {
        //Given
        int i = 8;

        //When
        boolean esPrimo = example.esPrimo(i);

        //Then
        assertFalse(esPrimo);
    }

    @Test
    void mensajeConRetraso() throws InterruptedException {
        //Given

        //When
        String string = example.mensajeConRetraso();

        //Then
        assertEquals("Listo después de retraso", string);
    }

    @Test
    void convertirAString() {
        //Given
        List<Integer> integerList = List.of(1, 2, 3);

        //When
        List<String> convertiredAString = example.convertirAString(integerList);

        //Then
        assertEquals(List.of("1","2","3"), convertiredAString);
    }

    @Test
    void calcularMedia() {
        //Given
        List<Integer> integerList = List.of(1, 2, 3);

        //When
        double calcularedMedia = example.calcularMedia(integerList);

        //Then
        assertEquals(2, calcularedMedia);
    }

    @Test
    void calcularMediaListaNula() {
        //Given
        List<Integer> integerList = null;

        //When Then
        assertThrows(IllegalArgumentException.class, () -> {
            example.calcularMedia(integerList);
        });
    }

    @Test
    void calcularMediaListaVacia() {
        //Given
        List<Integer> integerList = List.of();

        //When Then
        assertThrows(IllegalArgumentException.class, () -> {
            example.calcularMedia(integerList);
        });
    }

    @Test
    void convertirListaAString() {
        //Given
        List<String> stringList = List.of("Santi", "Juan", "Pedro");

        //When
        String convertiredListaAString = example.convertirListaAString(stringList);

        //Then
        assertEquals("SANTI,JUAN,PEDRO", convertiredListaAString);

    }
}
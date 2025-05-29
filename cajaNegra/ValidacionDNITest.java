/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.proyectoed.Paciente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidacionDNITest {

    @Test
    void testDNINull() {
        assertFalse(Paciente.validarDNI(null));
    }

    @Test
    void testFormatoInvalido() {
        assertFalse(Paciente.validarDNI(""));            // Vacío
        assertFalse(Paciente.validarDNI("1234567A"));     // 7 dígitos
        assertFalse(Paciente.validarDNI("123456789B"));   // 9 dígitos
        assertFalse(Paciente.validarDNI("ABCDEFGHI"));    // Solo letras
        assertFalse(Paciente.validarDNI("12345678Ñ"));    // Letra inválida (Ñ)
    }

    @Test
    void testLetraIncorrecta() {
        // DNI válido: 12345678Z, pero con letra incorrecta
        assertFalse(Paciente.validarDNI("12345678A"));
        assertFalse(Paciente.validarDNI("12345678B"));
    }

    @Test
    void testDNIValido() {
        // DNIs válidos conocidos
        assertTrue(Paciente.validarDNI("12345678Z"));  // 12345678 % 23 = 14 -> Z
        assertTrue(Paciente.validarDNI("45921406C"));  // 87654321 % 23 = 11 -> S
        assertTrue(Paciente.validarDNI("00000000T"));  // 0 % 23 = 0 -> T
        assertTrue(Paciente.validarDNI("99999999R"));  // 99999999 % 23 = 17 -> R

        // Variantes con espacios y minúsculas
        assertTrue(Paciente.validarDNI(" 12345678z "));  // con espacios y minúscula
        assertTrue(Paciente.validarDNI("52510785z"));    // letra minúscula
    }
}
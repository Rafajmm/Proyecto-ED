/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoed;

/**
 *
 * @author rafa
 */
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Paciente {
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaPrimeraConsulta;
    private EstadoPaciente estado;
    public enum EstadoPaciente {ACTIVO, INACTIVO, ALTA}

    public Paciente(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, 
                    String direccion, String telefono, String email, 
                    LocalDate fechaPrimeraConsulta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaPrimeraConsulta = fechaPrimeraConsulta;
        this.estado = EstadoPaciente.ACTIVO; // Estado por defecto
    }

    public static boolean validarDNI(String dni) {
        if (dni == null) {
            return false;
        }

        // Normalizar entrada
        dni = dni.trim().toUpperCase();

        // Comprobar formato: 8 dígitos + letra válida
        if (!dni.matches("[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]")) {
            return false;
        }

        // Extraer componentes
        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);

        // Calcular letra correcta
        String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";
        try {
            int resto = Integer.parseInt(numeros) % 23;
            return letra == letrasValidas.charAt(resto);
        } catch (NumberFormatException e) {
            return false; // Nunca debería ocurrir por la regex
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaPrimeraConsulta() {
        return fechaPrimeraConsulta;
    }

    public void setFechaPrimeraConsulta(LocalDate fechaPrimeraConsulta) {
        this.fechaPrimeraConsulta = fechaPrimeraConsulta;
    }

    public EstadoPaciente getEstado() {
        return estado;
    }

    public void setEstado(EstadoPaciente estado) {
        this.estado = estado;
    }

    
}
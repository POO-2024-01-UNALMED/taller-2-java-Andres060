package test;

import java.util.ArrayList;

class Asiento {
    String color;
    int precio;
    int registro;

    public void cambiarColor(String nuevoColor) {
        String[] coloresPermitidos = {"rojo", "verde", "amarillo", "negro", "blanco"};
        for (String colorPermitido : coloresPermitidos) {
            if (nuevoColor.equalsIgnoreCase(colorPermitido)) {
                color = nuevoColor;
                break;
            }
        }
    }
}

class Auto {
    String modelo;
    int precio;
    ArrayList<Asiento> asientos;
    String marca;
    Motor motor;
    int registro;
    static int cantidadCreados;

    public Auto(String modelo, int precio, String marca, Motor motor, int registro) {
        this.modelo = modelo;
        this.precio = precio;
        this.asientos = new ArrayList<>();
        this.marca = marca;
        this.motor = motor;
        this.registro = registro;
        cantidadCreados++;
    }

    public int cantidadAsientos() {
        int cantidad = 0;
        for (Asiento asiento : asientos) {
            if (asiento != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public String verificarIntegridad() {
        for (Asiento asiento : asientos) {
            if (asiento != null && asiento.registro != registro) {
                return "Las piezas no son originales";
            }
        }
        if (motor.registro != registro) {
            return "Las piezas no son originales";
        }
        return "Auto original";
    }
}

class Motor {
    int numeroCilindros;
    String tipo;
    int registro;

    public void cambiarRegistro(int registro) {
        this.registro = registro;
    }

    public void asignarTipo(String tipo) {
        if (tipo.equalsIgnoreCase("electrico") || tipo.equalsIgnoreCase("gasolina")) {
            this.tipo = tipo;
        }
    }
}

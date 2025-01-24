package TP5;

public abstract class Persona {
    private String nombre;
    private String domicilio;
    public Persona(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
    }
    public String getNombre() {
        return this.nombre;
    }


}

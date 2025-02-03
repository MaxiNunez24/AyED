package TP5;

public class Piloto {
    private int idPiloto;
    private String nombre;
    private int cantPasesEscuderias;

    public Piloto(int idPiloto, String nombre, int cantPasesEscuderias) {
        this.idPiloto = idPiloto;
        this.nombre = nombre;
        this.cantPasesEscuderias = cantPasesEscuderias;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantPasesEscuderias() {
        return cantPasesEscuderias;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantPasesEscuderias(int cantPasesEscuderias){
        this.cantPasesEscuderias = cantPasesEscuderias;
    }
}

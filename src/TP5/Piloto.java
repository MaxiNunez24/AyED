package TP5;

public class Piloto {
    private int id;
    private int pases;

    public Piloto(int id) {
        this.id = id;
        this.pases = 0;
    }


    public String getNombre() {
        return switch (this.id) {
            case 1 -> "Fangio";
            case 2 -> "Prost";
            case 3 -> "Senna";
            case 4 -> "Clark";
            default -> "Ninguno";
        };
    }

    public int getPases(){
        return this.pases;
    }

    public void incrementarPases(){
        this.pases++;
    }

    public int getId() {
        return id;
    }

}

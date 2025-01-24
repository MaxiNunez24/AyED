package TP5;

public class Jubilado extends Persona{
    private boolean cobro;
    public Jubilado(String nombre, String domicilio, boolean cobro){
        super(nombre,domicilio);
        this.cobro = cobro;
    }

    public boolean getCobro(){
        return this.cobro;
    }

    public void setCobro(boolean cobro){
        this.cobro = cobro;
    }

    public boolean cumple(){
        return !this.cobro;
    }
}

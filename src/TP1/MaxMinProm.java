package TP1;

public class MaxMinProm {
    private int max;
    private int min;
    private double prom;

    public MaxMinProm() {
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
        this.prom = 0;
    }

    public int getMax(){
        return this.max;
    }

    public void setMax(int max){
        this.max = max;
    }

    public int getMin(){
        return this.min;
    }

    public void setMin(int min){
        this.min = min;
    }

    public double getProm(){
        return this.prom;
    }

    public void setProm(int prom){
        this.prom = prom;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "Máximo: " + this.getMax()+ " " +
                "Mínimo: " + this.getMin()+ " " +
                "Promedio: " + this.getProm();

        return aux;
    }
}

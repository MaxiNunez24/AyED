package TP1.ej7;

import java.util.ArrayList;
import java.util.List;

public class ej7g {
    public static List<Integer> calcularSucesion(int n){
        List<Integer> lista = new ArrayList<>();
        calcularSucesionRecursivo(n, lista);
        return lista;
    }
    private static void calcularSucesionRecursivo(int n, List<Integer> lista){
        if(n != 1){
            if(n % 2 == 0){
                calcularSucesionRecursivo(n/2, lista);
            }
            else{
                calcularSucesionRecursivo(3*n+1, lista);
            }
        }
        lista.addFirst(n);
    }
    public static void main(String[] args) {
        List<Integer> lista = calcularSucesion(6);
        System.out.println(lista);
    }
}

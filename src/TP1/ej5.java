package TP1;
// Las variables static son las globales.
// Este ejercio da contexto sobre el ejercicio 4

// NUNCA USAR VARIABLES GLOBALES! ES SOLO DE EJEMPLO

public class ej5 {

    static MaxMinProm global = new MaxMinProm();

    public static MaxMinProm a(int[] arr){
        MaxMinProm aux = new MaxMinProm();
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>aux.getMax())aux.setMax(arr[i]);
            if(arr[i]<aux.getMin())aux.setMin(arr[i]);
            sum+=arr[i];
        }
        aux.setProm(sum/arr.length);
        return aux;
    }

    public static void b(int[] arr, MaxMinProm aux){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>aux.getMax())aux.setMax(arr[i]);
            if(arr[i]<aux.getMin())aux.setMin(arr[i]);
            sum+=arr[i];
        }
        aux.setProm(sum/arr.length);
    }

    public static void c(int[] arr){
        int aux = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>global.getMax())global.setMax(arr[i]);
            if(arr[i]<global.getMin())global.setMin(arr[i]);
            aux += arr[i];
        }
        global.setProm(aux/arr.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+20*i-(-i*5+2);
        }

        System.out.println(a(arr).toString());
        MaxMinProm b = new MaxMinProm();
        b(arr, b);
        System.out.println(b.toString());
        c(arr);
        System.out.println(global.toString());

    }

}

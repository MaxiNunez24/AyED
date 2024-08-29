package TP1;

import java.util.Scanner;

public class ej2 {
    public static int[] arrayN(int n){
        int[] arr = new int[n];
        int j = 1;
        for(int i=0; i<n; i++){
            arr[i] = n * j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] arr = arrayN(n);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}



package TP1;

public class ej1 {

    public static void a(int a,int b){
        for(int i=a; i<=b; i++){
            System.out.println(i);
        }
    }

    public static void b(int a,int b){
        int i = a;
        while(i <= b){
            System.out.println(i);
            i++;
        }
    }

    public static void c(int a, int b){
        if(a <= b){
            System.out.println(a);
            c(++a,b);
        }
    }

    public static void main(String[] args) {
        a(13, 25);
        System.out.println("------------------------------");
        b(13,25);
        System.out.println("------------------------------");
        c(13,25);
        System.out.println("------------------------------");
    }
}

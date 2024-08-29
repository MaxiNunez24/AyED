package TP1;

public class ej3 {
    public static void main(String[] args) {
        Estudiante[] est = new Estudiante[2];
        Profesor[] prof = new Profesor[3];

        est[0] = new Estudiante("Juan", "Perez","2A", "Pedro@gmail.com", "Juan 15412");
        est[1] = new Estudiante("Pedro","Gomez", "8A", "pedro@gmail.com", "Pedro 15412");

        prof[0] = new Profesor("Alfonso", "Pereira", "alfonso@gmail.com", "Objetos", "Informática");
        prof[1] = new Profesor("Martina", "Gaidán", "martina@gmail.com","Taller de programación", "Informática");
        prof[2] = new Profesor("Gonzalo", "Güemes", "gonza@gmail.com", "AyED", "Informática");

        for(int i = 0; i < est.length; i++) {
            System.out.println(est[i].tusDatos());
        }

        for(Profesor p : prof) {
            System.out.println(p.tusDatos());
        }
    }
}

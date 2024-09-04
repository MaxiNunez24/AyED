package TP1.ej7;

import TP1.Estudiante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ej7d {
    public static void main(String[] args) {
        List<Estudiante> estudiantes = new ArrayList<Estudiante>();
        Estudiante est1 = new Estudiante("Juan", "Perez","2A", "Pedro@gmail.com", "Juan 15412");
        Estudiante est2= new Estudiante("Pedro","Gomez", "8A", "pedro@gmail.com", "Pedro 15412");
        Estudiante est3= new Estudiante("Maria","Clara", "3A", "maria@gmail.com", "Maria 16512");
        estudiantes.add(est1); estudiantes.add(est2); estudiantes.add(est3);

        List<Estudiante> copiaEstudiante = new ArrayList(estudiantes); // se crea mediante el constructor
        // copiaEstudiantes.addAll(estudiantes); -> primero se crea y luego se agregan los elementos
        // copiaEstudiantes = (ArrayList<Estudiante>)estudiantes.clone(); -> No es recomendado ya que hay que realizar un Downcasting

        for(Estudiante est: estudiantes) System.out.println(est.tusDatos());
        for(Estudiante est: copiaEstudiante) System.out.println(est.tusDatos());

        System.out.println("----------------------------------------------------------------");

        est2.setApellido("Modificado");

        for(Estudiante est: estudiantes) System.out.println(est.tusDatos());
        for(Estudiante est: copiaEstudiante) System.out.println(est.tusDatos());

        System.out.println("----------------------------------------------------------------");

        // La conclusión que obtengo a partir de lo realizado es que lo que se guarda entry de la Lista son referencias a los estudiantes y que, por más que genere una nueva lista, al copiarla se están copiando las referencias.


        Estudiante est4 = new Estudiante("Clara","Figueroa","2","clara@gmail.com","Clara 15412");

        boolean esta = false;
        /*
        Iterator<Estudiante> it = estudiantes.iterator();
        while(it.hasNext()&&!esta){
            if(it.next().equals(est4)) esta = true;
        }
        PREGUNTAR!
        */
        for(Estudiante est: estudiantes) if(est.equals(est2)) esta = true;

        if(esta){
            System.out.println("El estudiante ya se encuentra en la lista");
        }else{
            estudiantes.add(est4);
            for(Estudiante est: estudiantes) System.out.println(est.tusDatos());
            System.out.println("----------------------------------------------------------------");
        }




    }
}

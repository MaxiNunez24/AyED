package TP1;

public class ej6 {
    //Análisis de las estructuras de listas provistas por la API de Java.
    //a. ¿En qué casos ArrayList ofrece un mejor rendimiento que LinkedList?
    // En los casos que se requiera acceso directo o busqueda por índice y para realizar iteraciones.
    //b. ¿Cuándo LinkedList puede ser más eficiente que ArrayList?
    // Cuando se quiera realizar muchas inserciones al principio o en el medio de la lista, ya que se evita realizar los corrimientos que si realiza el ArrayList.
    //c. ¿Qué diferencia encuentra en el uso de la memoria en ArrayList y LinkedList?
    //  ArrayList: Utiliza menos memoria por elemento. Sin embargo, para manejar el crecimiento dinámico, puede tener una capacidad mayor a la necesaria en un momento dado, lo que puede implicar un uso de memoria no utilizado (espacio adicional asignado).

    // LinkedList: Requiere más memoria por elemento, ya que además de almacenar el valor del elemento, necesita almacenar dos referencias adicionales (punteros) para mantener la relación entre los nodos (siguiente y anterior en una lista doblemente enlazada). Esto implica un mayor uso de memoria para listas con un gran número de elementos.

    //d. ¿En qué casos sería preferible usar un ArrayList o un LinkedList?
    // Preferir ArrayList cuando:
    //      - Se necesita acceso rápido por índice o búsqueda frecuente.
    //      - Las inserciones y eliminaciones se realizan mayoritariamente al final de la lista.
    //      - Se necesita menos sobrecarga de memoria por elemento.
    //      - La lista se utiliza principalmente para almacenar y acceder secuencialmente a datos.
    // Preferir LinkedList cuando:
    //      - Se realizan inserciones o eliminaciones frecuentes en posiciones intermedias o al principio de la lista.
    //      - El tamaño de la lista cambia frecuentemente y se desconoce el tamaño final.
    //      - No es necesario un acceso rápido a elementos individuales mediante índices.

}

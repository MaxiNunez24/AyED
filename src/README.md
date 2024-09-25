# Notas

Los programas con tipos genéricos pesan lo mismo en binario que los que no tienen tipos genéricos.  




## Wrappers

Integer b = new Integer(2);
int a = 1;

Integer c = a + b

La línea de arriba es equivalente a esto: 

Integer c = new Integer(a + b.intValue());


Esta línea de acá abajo es similar a la de arriba, ya que no se va a cambiar la referencia que contiene "c", sino que se va a hacer un new Integer(c + a) y se perdería la anterior dirección de "c" sin modificarla.
c = c + a; 


En resumen, si se pasa un Integer por parámetro no se modifica su valor, se vuelven "inmutables".




Un objeto para transportar datos se llama DPO




## Binary Tree

Un árbol es vacío cuando es hoja (sus hijos son null) y el dato es null.

Los métodos auxiliares se denominan **Helpers**, y son mayormente privados y recursivos.

Declarar las variables donde se utilicen, no mandar al helper variables innecesarias


## General Tree
La cantidad de nodos de un árbol general lleno es:
(k^h+1 - 1)/(k-1)

Esto llevado a un árbol binario es reemplazar K por 2

(2^h+1 - 1) / (2 - 1) =
(2^h+1 - 1) / 1 =
(2^h+1 - 1)

Si el árbol está implementado con lista de hijos con Arraylist ocupa más espacio que con Linkedlist?

## Short Circuit

a && b -> Circuito corto (a es falso = todo falso)

a & b -> Circuito largo (a es falso, si b es falso = todo falso)







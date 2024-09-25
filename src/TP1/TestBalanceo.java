package TP1;

public class TestBalanceo {

    // Método para verificar si un string está balanceado
    public boolean estaBalanceado(String s) {
        Stack<Character> pila = new Stack<>();

        // Recorremos cada carácter en el string
        for (char c : s.toCharArray()) {
            // Si es un símbolo de apertura, lo añadimos a la pila
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }
            // Si es un símbolo de cierre, verificamos la pila
            else if (c == ')' || c == ']' || c == '}') {
                // Si la pila está vacía o el símbolo no corresponde, no está balanceado
                if (pila.isEmpty() || !coincide(pila.pop(), c)) {
                    return false;
                }
            }
        }

        // Al final, la pila debe estar vacía si el string está balanceado
        return pila.isEmpty();
    }

    // Método para verificar si los símbolos de apertura y cierre coinciden
    private boolean coincide(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }

    public static void main(String[] args) {
        TestBalanceo test = new TestBalanceo();

        String cadena1 = "{( ) [ ( ) ] }";
        String cadena2 = "( [ ) ]";

        System.out.println("¿Está balanceado?: " + test.estaBalanceado(cadena1));  // true
        System.out.println("¿Está balanceado?: " + test.estaBalanceado(cadena1));  // false
    }
}

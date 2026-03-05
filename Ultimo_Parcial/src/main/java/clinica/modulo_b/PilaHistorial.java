package clinica.modulo_b;

/**
 * Pila LIFO (Last In, First Out) de diagnósticos médicos implementada sobre nodos enlazados.
 * Representa el historial clínico de un paciente: el diagnóstico más reciente es el primero
 * en consultarse o eliminarse.
 *
 * <p>¿Por qué una Pila y no una Cola para el historial clínico?</p>
 * <p>
 * En medicina, el diagnóstico más reciente es el más relevante clínicamente: el médico
 * necesita ver primero el último estado del paciente, no el primero. La pila (LIFO) modela
 * exactamente esta necesidad: acceso inmediato O(1) al registro más reciente. Una cola (FIFO)
 * obligaría a recorrer todo el historial para llegar al diagnóstico actual, lo que sería
 * ineficiente y contrario al flujo clínico real.
 * </p>
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class PilaHistorial {

    /** Nodo en el tope de la pila (diagnóstico más reciente). */
    private NodoDiagnostico tope;

    /** Cantidad de diagnósticos almacenados en la pila. */
    private int tamanio;

    /**
     * Constructor: inicializa la pila vacía.
     */
    public PilaHistorial() {
        this.tope    = null;
        this.tamanio = 0;
    }

    /**
     * Agrega un diagnóstico en el tope de la pila.
     * Complejidad: O(1).
     *
     * @param d Diagnóstico a apilar.
     */
    public void push(Diagnostico d) {
        NodoDiagnostico nuevo = new NodoDiagnostico(d);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    /**
     * Retira y retorna el diagnóstico más reciente (tope de la pila).
     * Complejidad: O(1).
     *
     * @return Diagnóstico más reciente, o {@code null} si la pila está vacía.
     */
    public Diagnostico pop() {
        if (isEmpty()) {
            System.out.println("[PILA] El historial está vacío.");
            return null;
        }
        Diagnostico reciente = tope.dato;
        tope = tope.siguiente;
        tamanio--;
        return reciente;
    }

    /**
     * Consulta el diagnóstico más reciente sin eliminarlo.
     * Complejidad: O(1).
     *
     * @return Diagnóstico en el tope, o {@code null} si la pila está vacía.
     */
    public Diagnostico peek() {
        if (isEmpty()) {
            System.out.println("[PILA] El historial está vacío.");
            return null;
        }
        return tope.dato;
    }

    /**
     * Indica si la pila no contiene diagnósticos.
     *
     * @return {@code true} si está vacía.
     */
    public boolean isEmpty() {
        return tope == null;
    }

    /**
     * Retorna el número de diagnósticos en la pila.
     *
     * @return Tamaño actual de la pila.
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     * Imprime todos los diagnósticos desde el más reciente hasta el más antiguo.
     * Complejidad: O(n).
     */
    public void mostrarHistorial() {
        if (isEmpty()) {
            System.out.println("[PILA] Historial vacío.");
            return;
        }
        System.out.println("=== Historial Clínico (" + tamanio + " registro(s)) — más reciente primero ===");
        NodoDiagnostico actual = tope;
        int i = 1;
        while (actual != null) {
            System.out.printf("  [%d] %s%n", i++, actual.dato);
            actual = actual.siguiente;
        }
        System.out.println("=====================================================================");
    }
}

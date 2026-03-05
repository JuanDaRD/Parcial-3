package clinica.moduloB;

/**
 * Pila LIFO (Last In, First Out) de diagnósticos médicos implementada
 * sobre nodos enlazados (sin uso de Stack ni Deque de Java).
 *
 * <p>El tope de la pila corresponde al diagnóstico más reciente del paciente,
 * lo que permite acceder instantáneamente al último registro clínico.</p>
 *
 * <p><b>¿Por qué una pila y no una cola para el historial clínico?</b><br>
 * En medicina, el médico de turno necesita revisar primero el diagnóstico
 * más reciente (el último registrado) para entender la evolución actual del
 * paciente y evitar duplicar tratamientos. La pila modela naturalmente ese
 * acceso LIFO: el tope siempre expone el evento más reciente sin necesidad
 * de recorrer toda la estructura, algo que una cola no podría garantizar
 * de forma eficiente.</p>
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class PilaHistorial {

    /** Nodo en el tope de la pila (diagnóstico más reciente). */
    private NodoDiagnostico tope;

    /** Número de diagnósticos almacenados. */
    private int tamanio;

    /**
     * Inicializa una pila vacía.
     */
    public PilaHistorial() {
        tope    = null;
        tamanio = 0;
    }

    // ═══════════════════════════════════════════════════════
    //  Operaciones principales
    // ═══════════════════════════════════════════════════════

    /**
     * Apila (agrega) un nuevo diagnóstico en el tope de la pila.
     * Complejidad: O(1) — inserción directa en la cabeza de la lista enlazada.
     *
     * @param d Diagnóstico a agregar. No debe ser null.
     */
    public void push(Diagnostico d) {
        if (d == null) throw new IllegalArgumentException("El diagnóstico no puede ser null.");
        NodoDiagnostico nuevo = new NodoDiagnostico(d);
        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    /**
     * Desapila (elimina y retorna) el diagnóstico más reciente.
     * Complejidad: O(1).
     *
     * @return El diagnóstico en el tope.
     * @throws RuntimeException si la pila está vacía.
     */
    public Diagnostico pop() {
        if (isEmpty()) throw new RuntimeException("El historial está vacío.");
        Diagnostico reciente = tope.dato;
        tope = tope.siguiente;
        tamanio--;
        return reciente;
    }

    /**
     * Consulta (sin eliminar) el diagnóstico más reciente.
     *
     * @return El diagnóstico en el tope, o null si la pila está vacía.
     */
    public Diagnostico peek() {
        return isEmpty() ? null : tope.dato;
    }

    // ═══════════════════════════════════════════════════════
    //  Consultas
    // ═══════════════════════════════════════════════════════

    /**
     * Indica si la pila no tiene diagnósticos.
     *
     * @return {@code true} si la pila está vacía.
     */
    public boolean isEmpty() {
        return tope == null;
    }

    /**
     * Retorna el número de diagnósticos en el historial.
     *
     * @return Cantidad de elementos en la pila.
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     * Recorre e imprime todos los diagnósticos del historial,
     * del más reciente al más antiguo.
     */
    public void mostrarHistorial() {
        if (isEmpty()) {
            System.out.println("  >> El historial clínico está vacío.");
            return;
        }
        System.out.println("  ╔══ HISTORIAL CLÍNICO (" + tamanio + " registro(s)) ══╗");
        NodoDiagnostico actual = tope;
        int orden = 1;
        while (actual != null) {
            System.out.printf("  %d. %s%n", orden++, actual.dato);
            actual = actual.siguiente;
        }
        System.out.println("  ╚═══════════════════════════════════════╝");
    }
}

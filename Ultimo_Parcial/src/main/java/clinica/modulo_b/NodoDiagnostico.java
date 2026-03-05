package clinica.modulo_b;

/**
 * Nodo de la pila de historial clínico.
 * Almacena un {@link Diagnostico} y la referencia al nodo inferior en la pila.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class NodoDiagnostico {

    /** Diagnóstico almacenado en este nodo. */
    public Diagnostico dato;

    /** Referencia al nodo siguiente (inferior) en la pila. */
    public NodoDiagnostico siguiente;

    /**
     * Constructor que inicializa el nodo con el diagnóstico dado.
     *
     * @param dato Diagnóstico a almacenar.
     */
    public NodoDiagnostico(Diagnostico dato) {
        this.dato      = dato;
        this.siguiente = null;
    }
}

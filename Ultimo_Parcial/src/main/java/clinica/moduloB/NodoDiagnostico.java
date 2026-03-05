package clinica.moduloB;

/**
 * Nodo de la pila enlazada utilizada por {@link PilaHistorial}.
 * Contiene un {@link Diagnostico} y la referencia al nodo inferior en la pila.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class NodoDiagnostico {

    /** Diagnóstico almacenado en este nodo. */
    public Diagnostico dato;

    /** Referencia al siguiente nodo (hacia la base de la pila). */
    public NodoDiagnostico siguiente;

    /**
     * Crea un nodo con el diagnóstico indicado.
     *
     * @param dato Diagnóstico a almacenar.
     */
    public NodoDiagnostico(Diagnostico dato) {
        this.dato      = dato;
        this.siguiente = null;
    }
}

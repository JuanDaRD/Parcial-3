package clinica.moduloC;

/**
 * Nodo del Árbol Binario de Búsqueda (BST) de médicos.
 * Almacena un {@link Medico} y referencias a los subárboles izquierdo y derecho.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class NodoMedico {

    /** Médico almacenado en este nodo. */
    public Medico dato;

    /** Hijo izquierdo (código menor). */
    public NodoMedico izq;

    /** Hijo derecho (código mayor). */
    public NodoMedico der;

    /**
     * Crea un nodo hoja con el médico indicado.
     *
     * @param dato Médico a almacenar.
     */
    public NodoMedico(Medico dato) {
        this.dato = dato;
        this.izq  = null;
        this.der  = null;
    }
}

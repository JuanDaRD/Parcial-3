package clinica.modulo_c;

/**
 * Nodo del Árbol Binario de Búsqueda (BST) de médicos.
 * Contiene un {@link Medico} y referencias a los subárboles izquierdo y derecho.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class NodoMedico {

    /** Médico almacenado en este nodo. */
    public Medico dato;

    /** Subárbol izquierdo (médicos con código menor). */
    public NodoMedico izq;

    /** Subárbol derecho (médicos con código mayor). */
    public NodoMedico der;

    /**
     * Constructor que inicializa el nodo con el médico dado.
     * Los hijos quedan en null (nodo hoja).
     *
     * @param dato Médico a almacenar.
     */
    public NodoMedico(Medico dato) {
        this.dato = dato;
        this.izq  = null;
        this.der  = null;
    }
}

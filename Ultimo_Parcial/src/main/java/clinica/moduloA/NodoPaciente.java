package clinica.moduloA;

/**
 * Nodo de la lista enlazada simple utilizada por {@link ColaPacientes}.
 * Encapsula un {@link Paciente} y la referencia al siguiente nodo.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class NodoPaciente {

    /** Dato almacenado en este nodo. */
    public Paciente dato;

    /** Referencia al siguiente nodo en la lista. */
    public NodoPaciente siguiente;

    /**
     * Crea un nodo con el paciente indicado y siguiente apuntando a null.
     *
     * @param dato Paciente que se almacenará en el nodo.
     */
    public NodoPaciente(Paciente dato) {
        this.dato      = dato;
        this.siguiente = null;
    }
}

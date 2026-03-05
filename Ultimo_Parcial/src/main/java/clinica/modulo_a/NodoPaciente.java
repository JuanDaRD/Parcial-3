package clinica.modulo_a;

/**
 * Nodo de la lista enlazada simple utilizada para implementar la cola de pacientes.
 * Cada nodo almacena un {@link Paciente} y una referencia al siguiente nodo.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class NodoPaciente {

    /** Dato almacenado en el nodo: un objeto Paciente. */
    public Paciente dato;

    /** Referencia al siguiente nodo en la lista enlazada. */
    public NodoPaciente siguiente;

    /**
     * Constructor que inicializa el nodo con el paciente dado.
     * La referencia {@code siguiente} queda en null por defecto.
     *
     * @param dato Paciente que se almacenará en este nodo.
     */
    public NodoPaciente(Paciente dato) {
        this.dato      = dato;
        this.siguiente = null;
    }
}

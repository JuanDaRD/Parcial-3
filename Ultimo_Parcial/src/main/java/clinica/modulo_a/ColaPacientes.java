package clinica.modulo_a;

/**
 * Cola FIFO (First In, First Out) de pacientes implementada sobre una lista enlazada simple.
 * Gestiona el turno de atención en el área de urgencias de la Clínica VidasPlus.
 *
 * <p>Análisis de complejidad temporal:</p>
 * <ul>
 *   <li>{@code enqueue()} → O(1): Se inserta siempre al final (puntero "ultimo"),
 *       sin necesidad de recorrer la lista.</li>
 *   <li>{@code dequeue()} → O(1): Se elimina siempre el frente (puntero "frente"),
 *       sin necesidad de recorrer la lista.</li>
 *   <li>{@code mostrarCola()} → O(n): Necesita recorrer todos los nodos.</li>
 * </ul>
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class ColaPacientes {

    /** Nodo al frente de la cola (primer en ser atendido). */
    private NodoPaciente frente;

    /** Nodo al final de la cola (último en ingresar). */
    private NodoPaciente ultimo;

    /** Cantidad actual de pacientes en la cola. */
    private int tamanio;

    /**
     * Constructor: inicializa la cola vacía.
     */
    public ColaPacientes() {
        this.frente  = null;
        this.ultimo  = null;
        this.tamanio = 0;
    }

    /**
     * Agrega un paciente al final de la cola (FIFO).
     * Complejidad: O(1) — se enlaza directamente al nodo "ultimo".
     *
     * @param p Paciente a encolar.
     */
    public void enqueue(Paciente p) {
        NodoPaciente nuevo = new NodoPaciente(p);
        if (isEmpty()) {
            frente = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tamanio++;
    }

    /**
     * Retira y retorna el paciente al frente de la cola (próximo a ser atendido).
     * Complejidad: O(1) — se accede directamente al puntero "frente".
     *
     * @return Paciente atendido, o {@code null} si la cola está vacía.
     */
    public Paciente dequeue() {
        if (isEmpty()) {
            System.out.println("[COLA] La cola de urgencias está vacía.");
            return null;
        }
        Paciente atendido = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            ultimo = null; // La cola quedó vacía
        }
        tamanio--;
        return atendido;
    }

    /**
     * Consulta el paciente al frente de la cola sin retirarlo.
     *
     * @return Paciente al frente, o {@code null} si la cola está vacía.
     */
    public Paciente peek() {
        if (isEmpty()) {
            System.out.println("[COLA] La cola está vacía, no hay paciente al frente.");
            return null;
        }
        return frente.dato;
    }

    /**
     * Indica si la cola no tiene pacientes.
     *
     * @return {@code true} si la cola está vacía, {@code false} en caso contrario.
     */
    public boolean isEmpty() {
        return frente == null;
    }

    /**
     * Retorna la cantidad de pacientes actualmente en la cola.
     *
     * @return Número de pacientes en cola.
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     * Imprime en consola todos los pacientes en la cola en orden de atención (frente → último).
     * Complejidad: O(n).
     */
    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("[COLA] No hay pacientes en espera.");
            return;
        }
        System.out.println("=== Estado de la Cola de Urgencias (" + tamanio + " paciente(s)) ===");
        NodoPaciente actual = frente;
        int posicion = 1;
        while (actual != null) {
            System.out.printf("  [%d] %s%n", posicion++, actual.dato);
            actual = actual.siguiente;
        }
        System.out.println("=============================================================");
    }
}

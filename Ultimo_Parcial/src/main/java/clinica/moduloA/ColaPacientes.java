package clinica.moduloA;

/**
 * Cola FIFO (First In, First Out) de pacientes implementada sobre una
 * lista enlazada simple (sin uso de ArrayList ni LinkedList de Java).
 *
 * <p>Se mantienen dos punteros:
 * <ul>
 *   <li>{@code frente} — apunta al primer nodo (próximo a ser atendido).</li>
 *   <li>{@code ultimo} — apunta al último nodo (último en ingresar).</li>
 * </ul>
 *
 * <p><b>Análisis de complejidad temporal:</b>
 * <ul>
 *   <li>{@code enqueue()}: O(1) — el puntero {@code ultimo} permite insertar
 *       directamente al final sin recorrer la lista.</li>
 *   <li>{@code dequeue()}: O(1) — se elimina siempre el nodo {@code frente};
 *       no requiere recorrido alguno.</li>
 * </ul>
 * Gracias a los dos punteros, ambas operaciones son de tiempo constante,
 * lo que hace eficiente esta estructura para colas de atención médica.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class ColaPacientes {

    /** Puntero al primer nodo de la cola (frente de atención). */
    private NodoPaciente frente;

    /** Puntero al último nodo de la cola (último en llegar). */
    private NodoPaciente ultimo;

    /** Cantidad de pacientes actualmente en cola. */
    private int tamanio;

    /**
     * Inicializa una cola vacía.
     */
    public ColaPacientes() {
        frente  = null;
        ultimo  = null;
        tamanio = 0;
    }

    // ═══════════════════════════════════════════════════════
    //  Operaciones principales
    // ═══════════════════════════════════════════════════════

    /**
     * Agrega un paciente al final de la cola (enqueue / ingreso).
     * Complejidad: O(1) — inserción directa mediante el puntero {@code ultimo}.
     *
     * @param p Paciente a agregar. No debe ser null.
     */
    public void enqueue(Paciente p) {
        if (p == null) throw new IllegalArgumentException("El paciente no puede ser null.");
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
     * Atiende (elimina y retorna) al paciente al frente de la cola (dequeue).
     * Complejidad: O(1) — remoción directa del puntero {@code frente}.
     *
     * @return El paciente atendido.
     * @throws RuntimeException si la cola está vacía.
     */
    public Paciente dequeue() {
        if (isEmpty()) throw new RuntimeException("La cola de urgencias está vacía.");
        Paciente atendido = frente.dato;
        frente = frente.siguiente;
        if (frente == null) ultimo = null;   // La cola quedó vacía
        tamanio--;
        return atendido;
    }

    /**
     * Consulta (sin eliminar) al paciente al frente de la cola.
     *
     * @return El siguiente paciente a ser atendido, o null si la cola está vacía.
     */
    public Paciente peek() {
        return isEmpty() ? null : frente.dato;
    }

    // ═══════════════════════════════════════════════════════
    //  Consultas
    // ═══════════════════════════════════════════════════════

    /**
     * Indica si la cola no tiene pacientes.
     *
     * @return {@code true} si la cola está vacía.
     */
    public boolean isEmpty() {
        return frente == null;
    }

    /**
     * Retorna la cantidad de pacientes en espera.
     *
     * @return Número de nodos en la cola.
     */
    public int tamanio() {
        return tamanio;
    }

    /**
     * Recorre e imprime en consola el estado actual de la cola,
     * desde el frente hasta el último paciente.
     */
    public void mostrarCola() {
        if (isEmpty()) {
            System.out.println("  >> La cola de urgencias está vacía.");
            return;
        }
        System.out.println("  ╔══ COLA DE URGENCIAS (" + tamanio + " paciente(s)) ══╗");
        NodoPaciente actual = frente;
        int pos = 1;
        while (actual != null) {
            System.out.printf("  %d. %s%n", pos++, actual.dato);
            actual = actual.siguiente;
        }
        System.out.println("  ╚══════════════════════════════════════╝");
    }
}

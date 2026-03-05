package clinica.modulo_c;

/**
 * Árbol Binario de Búsqueda (BST) para el directorio de médicos de la Clínica VidasPlus.
 * El criterio de ordenación es el {@code codigo} del médico (entero).
 *
 * <p>Análisis de complejidad temporal (insertar / buscar):</p>
 * <ul>
 *   <li>Caso promedio (árbol balanceado): O(log n) — en cada nivel se descarta la mitad del árbol.</li>
 *   <li>Peor caso (árbol degenerado): O(n) — ocurre cuando los códigos se insertan en orden
 *       estrictamente ascendente (o descendente). En ese caso, el BST degenera en una lista
 *       enlazada: cada nuevo nodo siempre va al hijo derecho, formando una cadena de n nodos,
 *       y tanto insertar() como buscar() deben recorrer hasta n nodos. Para evitar esto en
 *       producción se usaría un árbol auto-balanceado como AVL o Rojo-Negro.</li>
 * </ul>
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class BST_Medicos {

    /** Raíz del árbol BST. */
    private NodoMedico raiz;

    /**
     * Constructor: inicializa el árbol vacío.
     */
    public BST_Medicos() {
        this.raiz = null;
    }

    // ──────────────────────────── INSERTAR ────────────────────────────────────

    /**
     * Inserta un médico en el BST según su código.
     * Si el código ya existe, no hace nada (no se permiten duplicados).
     *
     * @param m Médico a insertar.
     */
    public void insertar(Medico m) {
        raiz = insertarRec(raiz, m);
    }

    /**
     * Método recursivo que ubica la posición correcta e inserta el médico.
     *
     * @param n Nodo actual en la recursión.
     * @param m Médico a insertar.
     * @return Nodo raíz del subárbol modificado.
     */
    private NodoMedico insertarRec(NodoMedico n, Medico m) {
        if (n == null) return new NodoMedico(m);
        if (m.getCodigo() < n.dato.getCodigo()) {
            n.izq = insertarRec(n.izq, m);
        } else if (m.getCodigo() > n.dato.getCodigo()) {
            n.der = insertarRec(n.der, m);
        }
        // Si código == n.dato.getCodigo() no se inserta (código duplicado)
        return n;
    }

    // ──────────────────────────── BUSCAR ──────────────────────────────────────

    /**
     * Busca un médico por su código en el BST.
     *
     * @param codigo Código del médico a buscar.
     * @return El {@link Medico} encontrado, o {@code null} si no existe.
     */
    public Medico buscar(int codigo) {
        return buscarRec(raiz, codigo);
    }

    /**
     * Método recursivo de búsqueda por código.
     *
     * @param n      Nodo actual en la recursión.
     * @param codigo Código a buscar.
     * @return Médico encontrado o {@code null}.
     */
    private Medico buscarRec(NodoMedico n, int codigo) {
        if (n == null) return null;
        if (codigo == n.dato.getCodigo()) return n.dato;
        if (codigo < n.dato.getCodigo())  return buscarRec(n.izq, codigo);
        return buscarRec(n.der, codigo);
    }

    // ──────────────────────────── ELIMINAR ────────────────────────────────────

    /**
     * Elimina el médico con el código dado del BST.
     * Maneja tres casos: nodo hoja, nodo con un hijo, nodo con dos hijos.
     *
     * @param codigo Código del médico a eliminar.
     */
    public void eliminar(int codigo) {
        raiz = eliminarRec(raiz, codigo);
    }

    /**
     * Método recursivo de eliminación.
     * Para nodo con dos hijos se usa el sucesor en-orden (mínimo del subárbol derecho).
     *
     * @param n      Nodo actual en la recursión.
     * @param codigo Código del médico a eliminar.
     * @return Nodo raíz del subárbol modificado.
     */
    private NodoMedico eliminarRec(NodoMedico n, int codigo) {
        if (n == null) {
            System.out.println("[BST] Código " + codigo + " no encontrado para eliminar.");
            return null;
        }
        if (codigo < n.dato.getCodigo()) {
            n.izq = eliminarRec(n.izq, codigo);
        } else if (codigo > n.dato.getCodigo()) {
            n.der = eliminarRec(n.der, codigo);
        } else {
            // Nodo encontrado — tres casos:
            if (n.izq == null) return n.der;   // Caso 1: sin hijo izquierdo
            if (n.der == null) return n.izq;   // Caso 2: sin hijo derecho
            // Caso 3: dos hijos — reemplazar con el mínimo del subárbol derecho
            NodoMedico sucesor = minimoNodo(n.der);
            n.dato = sucesor.dato;
            n.der  = eliminarRec(n.der, sucesor.dato.getCodigo());
        }
        return n;
    }

    /**
     * Retorna el nodo con el menor código en el subárbol dado.
     * Se usa como sucesor en-orden en la eliminación con dos hijos.
     *
     * @param n Raíz del subárbol.
     * @return Nodo con el código mínimo.
     */
    private NodoMedico minimoNodo(NodoMedico n) {
        while (n.izq != null) n = n.izq;
        return n;
    }

    // ──────────────────────────── RECORRIDOS ──────────────────────────────────

    /**
     * Imprime el BST en recorrido In-Orden (Izquierda → Raíz → Derecha).
     * Produce los médicos en orden ascendente de código.
     */
    public void inOrden() {
        System.out.print("InOrden   : ");
        inOrdenRec(raiz);
        System.out.println();
    }

    private void inOrdenRec(NodoMedico n) {
        if (n == null) return;
        inOrdenRec(n.izq);
        System.out.printf("[%d:%s] ", n.dato.getCodigo(), n.dato.getNombre());
        inOrdenRec(n.der);
    }

    /**
     * Imprime el BST en recorrido Pre-Orden (Raíz → Izquierda → Derecha).
     */
    public void preOrden() {
        System.out.print("PreOrden  : ");
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoMedico n) {
        if (n == null) return;
        System.out.printf("[%d:%s] ", n.dato.getCodigo(), n.dato.getNombre());
        preOrdenRec(n.izq);
        preOrdenRec(n.der);
    }

    /**
     * Imprime el BST en recorrido Post-Orden (Izquierda → Derecha → Raíz).
     */
    public void postOrden() {
        System.out.print("PostOrden : ");
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoMedico n) {
        if (n == null) return;
        postOrdenRec(n.izq);
        postOrdenRec(n.der);
        System.out.printf("[%d:%s] ", n.dato.getCodigo(), n.dato.getNombre());
    }

    // ──────────────────────────── ALTURA ──────────────────────────────────────

    /**
     * Calcula la altura del árbol (número de niveles - 1).
     * Un árbol vacío tiene altura -1; un árbol con solo la raíz tiene altura 0.
     *
     * @return Altura del árbol.
     */
    public int altura() {
        return alturaRec(raiz);
    }

    /**
     * Método recursivo para calcular la altura.
     *
     * @param n Nodo actual.
     * @return Altura del subárbol.
     */
    private int alturaRec(NodoMedico n) {
        if (n == null) return -1;
        int altIzq = alturaRec(n.izq);
        int altDer = alturaRec(n.der);
        return 1 + Math.max(altIzq, altDer);
    }
}

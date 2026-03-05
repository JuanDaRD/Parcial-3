package clinica.moduloC;

/**
 * Árbol Binario de Búsqueda (BST) para el directorio de médicos de la
 * Clínica VidasPlus. El criterio de ordenación es el {@code codigo} del médico.
 *
 * <p><b>Análisis de complejidad — insertar() y buscar():</b><br>
 * - Caso promedio (árbol balanceado): O(log n) — cada nivel descarta la mitad
 *   de los nodos restantes.<br>
 * - Peor caso (árbol degenerado): O(n) — ocurre cuando los códigos se insertan
 *   en orden estrictamente ascendente o descendente, generando una estructura
 *   equivalente a una lista enlazada. En ese escenario, cada inserción/búsqueda
 *   recorre todos los nodos existentes. Para evitarlo se recomienda usar árboles
 *   auto-balanceados (AVL, Red-Black) cuando se conoce la tendencia de los datos.
 * </p>
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class BST_Medicos {

    /** Raíz del árbol. */
    private NodoMedico raiz;

    /**
     * Inicializa un BST vacío.
     */
    public BST_Medicos() {
        raiz = null;
    }

    // ═══════════════════════════════════════════════════════
    //  INSERTAR
    // ═══════════════════════════════════════════════════════

    /**
     * Inserta un médico en el BST manteniendo la propiedad de orden.
     *
     * @param m Médico a insertar. No debe ser null.
     */
    public void insertar(Medico m) {
        if (m == null) throw new IllegalArgumentException("El médico no puede ser null.");
        raiz = insertarRec(raiz, m);
    }

    /**
     * Inserción recursiva. Navega el árbol comparando códigos.
     *
     * @param nodo Nodo actual en la recursión.
     * @param m    Médico a insertar.
     * @return El nodo actualizado (permite reconstruir el árbol al retornar).
     */
    private NodoMedico insertarRec(NodoMedico nodo, Medico m) {
        if (nodo == null) return new NodoMedico(m);          // Posición encontrada
        if (m.getCodigo() < nodo.dato.getCodigo()) {
            nodo.izq = insertarRec(nodo.izq, m);
        } else if (m.getCodigo() > nodo.dato.getCodigo()) {
            nodo.der = insertarRec(nodo.der, m);
        } else {
            // Código duplicado: se reemplaza el médico existente
            nodo.dato = m;
        }
        return nodo;
    }

    // ═══════════════════════════════════════════════════════
    //  BUSCAR
    // ═══════════════════════════════════════════════════════

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
     * Búsqueda recursiva por código.
     *
     * @param nodo   Nodo actual en la recursión.
     * @param codigo Código a buscar.
     * @return El médico con ese código, o null si no existe.
     */
    private Medico buscarRec(NodoMedico nodo, int codigo) {
        if (nodo == null)                   return null;          // No encontrado
        if (codigo == nodo.dato.getCodigo()) return nodo.dato;    // Encontrado
        if (codigo < nodo.dato.getCodigo())
            return buscarRec(nodo.izq, codigo);
        return buscarRec(nodo.der, codigo);
    }

    // ═══════════════════════════════════════════════════════
    //  ELIMINAR
    // ═══════════════════════════════════════════════════════

    /**
     * Elimina del BST el médico con el código indicado.
     * Maneja los tres casos: nodo hoja, nodo con un hijo y nodo con dos hijos.
     *
     * @param codigo Código del médico a eliminar.
     */
    public void eliminar(int codigo) {
        raiz = eliminarRec(raiz, codigo);
    }

    /**
     * Eliminación recursiva con los tres casos estándar de BST.
     *
     * @param nodo   Nodo actual.
     * @param codigo Código del médico a eliminar.
     * @return El nodo actualizado.
     */
    private NodoMedico eliminarRec(NodoMedico nodo, int codigo) {
        if (nodo == null) {
            System.out.println("  >> Código " + codigo + " no encontrado en el BST.");
            return null;
        }
        if (codigo < nodo.dato.getCodigo()) {
            nodo.izq = eliminarRec(nodo.izq, codigo);
        } else if (codigo > nodo.dato.getCodigo()) {
            nodo.der = eliminarRec(nodo.der, codigo);
        } else {
            // ── Caso 1: nodo hoja (sin hijos) ──
            if (nodo.izq == null && nodo.der == null) return null;

            // ── Caso 2: nodo con un solo hijo ──
            if (nodo.izq == null) return nodo.der;
            if (nodo.der == null) return nodo.izq;

            // ── Caso 3: nodo con dos hijos ──
            // Se reemplaza con el sucesor en inOrden (mínimo del subárbol derecho)
            NodoMedico sucesor = minimoNodo(nodo.der);
            nodo.dato = sucesor.dato;
            nodo.der  = eliminarRec(nodo.der, sucesor.dato.getCodigo());
        }
        return nodo;
    }

    /**
     * Retorna el nodo con el código mínimo dentro del subárbol dado.
     * Se usa para encontrar el sucesor inOrden al eliminar un nodo con dos hijos.
     *
     * @param nodo Raíz del subárbol donde buscar el mínimo.
     * @return El nodo más a la izquierda (valor mínimo).
     */
    private NodoMedico minimoNodo(NodoMedico nodo) {
        while (nodo.izq != null) nodo = nodo.izq;
        return nodo;
    }

    // ═══════════════════════════════════════════════════════
    //  RECORRIDOS
    // ═══════════════════════════════════════════════════════

    /**
     * Recorrido inOrden (izquierda → raíz → derecha).
     * Imprime los médicos en orden ascendente de código.
     */
    public void inOrden() {
        System.out.print("  InOrden   : ");
        inOrdenRec(raiz);
        System.out.println();
    }

    private void inOrdenRec(NodoMedico nodo) {
        if (nodo == null) return;
        inOrdenRec(nodo.izq);
        System.out.print(nodo.dato.getCodigo() + " ");
        inOrdenRec(nodo.der);
    }

    /**
     * Recorrido preOrden (raíz → izquierda → derecha).
     */
    public void preOrden() {
        System.out.print("  PreOrden  : ");
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoMedico nodo) {
        if (nodo == null) return;
        System.out.print(nodo.dato.getCodigo() + " ");
        preOrdenRec(nodo.izq);
        preOrdenRec(nodo.der);
    }

    /**
     * Recorrido postOrden (izquierda → derecha → raíz).
     */
    public void postOrden() {
        System.out.print("  PostOrden : ");
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoMedico nodo) {
        if (nodo == null) return;
        postOrdenRec(nodo.izq);
        postOrdenRec(nodo.der);
        System.out.print(nodo.dato.getCodigo() + " ");
    }

    // ═══════════════════════════════════════════════════════
    //  ALTURA
    // ═══════════════════════════════════════════════════════

    /**
     * Calcula la altura del árbol (número de niveles - 1).
     * Un árbol vacío tiene altura -1; un nodo hoja tiene altura 0.
     *
     * @return Altura del árbol.
     */
    public int altura() {
        return alturaRec(raiz);
    }

    /**
     * Cálculo recursivo de la altura.
     *
     * @param nodo Nodo actual.
     * @return Altura del subárbol con raíz en {@code nodo}.
     */
    private int alturaRec(NodoMedico nodo) {
        if (nodo == null) return -1;
        int altIzq = alturaRec(nodo.izq);
        int altDer = alturaRec(nodo.der);
        return 1 + Math.max(altIzq, altDer);
    }

    /**
     * Imprime los detalles completos del médico con el código indicado,
     * útil para visualizar resultados de búsqueda.
     *
     * @param codigo Código del médico buscado.
     */
    public void imprimirBusqueda(int codigo) {
        Medico m = buscar(codigo);
        if (m != null) {
            System.out.println("  ✔ Encontrado: " + m);
        } else {
            System.out.println("  ✘ Código " + codigo + " no existe en el BST.");
        }
    }
}

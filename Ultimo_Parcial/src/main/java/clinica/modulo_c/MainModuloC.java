package clinica.modulo_c;

/**
 * Clase principal del Módulo C — Árbol BST de Médicos.
 * Demuestra inserción, búsqueda, eliminación, recorridos y cálculo de altura
 * sobre un {@link BST_Medicos}.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class MainModuloC {

    /**
     * Punto de entrada del Módulo C.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        BST_Medicos bst = new BST_Medicos();

        // ── Insertar 8 médicos con distintos códigos ──────────────────────────────
        //    Árbol resultante (raíz = 50):
        //            50
        //          /    \
        //        30      70
        //       /  \    /  \
        //      15   40 60   90
        //          /       /
        //         35      80
        bst.insertar(new Medico(50, "Dr. Jorge Salinas",   "Cardiología",    "mañana",  320));
        bst.insertar(new Medico(30, "Dra. Ana Torres",     "Neurología",     "tarde",   210));
        bst.insertar(new Medico(70, "Dr. Luis Vargas",     "Traumatología",  "mañana",  450));
        bst.insertar(new Medico(15, "Dra. Claudia Ríos",   "Pediatría",      "noche",   180));
        bst.insertar(new Medico(40, "Dr. Miguel Herrera",  "Medicina Interna","tarde",  275));
        bst.insertar(new Medico(60, "Dra. Sofía Mendez",   "Urgencias",      "noche",   390));
        bst.insertar(new Medico(90, "Dr. Andrés Fuentes",  "Cirugía General","mañana",  500));
        bst.insertar(new Medico(35, "Dra. Patricia Leal",  "Ginecología",    "tarde",   145));
        bst.insertar(new Medico(80, "Dr. Roberto Cano",    "Ortopedia",      "noche",   230));

        // ── Recorridos iniciales ──────────────────────────────────────────────────
        System.out.println("\n=== Recorridos del BST ===");
        bst.inOrden();
        bst.preOrden();
        bst.postOrden();

        // ── Altura antes de eliminaciones ─────────────────────────────────────────
        System.out.println("\nAltura del árbol (antes de eliminaciones): " + bst.altura());

        // ── Búsquedas ─────────────────────────────────────────────────────────────
        System.out.println("\n=== Búsquedas ===");

        // Búsqueda exitosa 1
        Medico b1 = bst.buscar(60);
        System.out.println("Buscar código 60 → " + (b1 != null ? b1 : "NO ENCONTRADO"));

        // Búsqueda exitosa 2
        Medico b2 = bst.buscar(35);
        System.out.println("Buscar código 35 → " + (b2 != null ? b2 : "NO ENCONTRADO"));

        // Búsqueda fallida
        Medico b3 = bst.buscar(99);
        System.out.println("Buscar código 99 → " + (b3 != null ? b3 : "NO ENCONTRADO"));

        // ── Eliminaciones ─────────────────────────────────────────────────────────
        System.out.println("\n=== Eliminaciones ===");

        // 1. Eliminar nodo HOJA (código 35 — Dra. Patricia Leal, sin hijos)
        System.out.println("\n[1] Eliminar nodo hoja (código 35):");
        bst.eliminar(35);
        bst.inOrden();
        System.out.println("    Altura: " + bst.altura());

        // 2. Eliminar nodo con UN HIJO (código 90 — Dr. Andrés Fuentes, hijo izquierdo: 80)
        System.out.println("\n[2] Eliminar nodo con un hijo (código 90):");
        bst.eliminar(90);
        bst.inOrden();
        System.out.println("    Altura: " + bst.altura());

        // 3. Eliminar nodo con DOS HIJOS (código 30 — Dra. Ana Torres, hijos: 15 y 40)
        System.out.println("\n[3] Eliminar nodo con dos hijos (código 30):");
        bst.eliminar(30);
        bst.inOrden();
        System.out.println("    Altura: " + bst.altura());

        // ── Altura después de todas las eliminaciones ─────────────────────────────
        System.out.println("\nAltura del árbol (después de todas las eliminaciones): " + bst.altura());
    }
}

package clinica.moduloC;

/**
 * Clase principal del Módulo C — Árbol BST de Médicos.
 * Demuestra inserción, búsqueda, eliminación de nodos (hoja, un hijo, dos hijos),
 * recorridos y cálculo de altura del BST.
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

        // ── Inserción de 8 médicos con códigos variados ──
        // Árbol resultante (códigos):
        //          050
        //        /     \
        //      030      070
        //      / \      / \
        //    010  040  060  090
        //                  / \
        //                 080 100
        bst.insertar(new Medico(50,  "Dra. Adriana Suárez",  "Cardiología",     "mañana", 320));
        bst.insertar(new Medico(30,  "Dr. Luis Gómez",       "Medicina General", "tarde",  215));
        bst.insertar(new Medico(70,  "Dra. Patricia Reyes",  "Traumatología",   "noche",  180));
        bst.insertar(new Medico(10,  "Dr. Camilo Mora",      "Pediatría",       "mañana", 140));
        bst.insertar(new Medico(40,  "Dra. Sandra Vargas",   "Neurología",      "tarde",  260));
        bst.insertar(new Medico(60,  "Dr. Ricardo Peña",     "Ortopedia",       "noche",  195));
        bst.insertar(new Medico(90,  "Dr. Felipe Castro",    "Urgencias",       "mañana", 410));
        bst.insertar(new Medico(80,  "Dra. Marcela Torres",  "Cirugía General", "tarde",  290));
        bst.insertar(new Medico(100, "Dr. Andrés Lozano",    "Radiología",      "noche",  175));

        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("  MÓDULO C — ÁRBOL BST DE MÉDICOS");
        System.out.println("═══════════════════════════════════════════════════");

        // ── Recorridos iniciales ──
        System.out.println("\n► Recorridos del árbol (9 médicos insertados):");
        bst.inOrden();
        bst.preOrden();
        bst.postOrden();

        // ── Altura inicial ──
        System.out.println("\n► Altura del árbol: " + bst.altura());

        // ── Tres búsquedas (2 exitosas, 1 fallida) ──
        System.out.println("\n► Búsquedas:");
        bst.imprimirBusqueda(40);   // Exitosa
        bst.imprimirBusqueda(90);   // Exitosa
        bst.imprimirBusqueda(55);   // Fallida

        // ── Eliminación 1: nodo HOJA (código 10 — sin hijos) ──
        System.out.println("\n► Eliminando nodo HOJA: código 10 (Dr. Camilo Mora)");
        bst.eliminar(10);
        bst.inOrden();

        // ── Eliminación 2: nodo con UN HIJO (código 100 — solo hijo de 90) ──
        System.out.println("\n► Eliminando nodo con UN HIJO: código 100 (Dr. Andrés Lozano)");
        bst.eliminar(100);
        bst.inOrden();

        // ── Eliminación 3: nodo con DOS HIJOS (código 70 — hijos 60 y 90) ──
        System.out.println("\n► Eliminando nodo con DOS HIJOS: código 70 (Dra. Patricia Reyes)");
        bst.eliminar(70);
        bst.inOrden();

        // ── Altura final ──
        System.out.println("\n► Altura del árbol tras las eliminaciones: " + bst.altura());
        System.out.println("═══════════════════════════════════════════════════\n");
    }
}

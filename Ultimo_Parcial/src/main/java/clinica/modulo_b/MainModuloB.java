package clinica.modulo_b;

import clinica.modulo_a.Paciente;

/**
 * Clase principal del Módulo B — Historial Clínico con Pila.
 * Demuestra push, pop, peek y mostrarHistorial en {@link PilaHistorial}.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class MainModuloB {

    /**
     * Punto de entrada del Módulo B.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // ── Paciente 1 ────────────────────────────────────────────────────────────
        Paciente p1 = new Paciente("1098765432", "Carlos Martínez", "05/03/2026", 1, "Dolor precordial");
        PilaHistorial historialP1 = new PilaHistorial();

        historialP1.push(new Diagnostico("01/01/2026", "Hipertensión arterial",   "Losartán 50mg",        "Dra. Ana Torres"));
        historialP1.push(new Diagnostico("10/01/2026", "Angina inestable",        "Nitroglicerina 0.5mg", "Dr. Luis Vargas"));
        historialP1.push(new Diagnostico("20/02/2026", "Infarto agudo de miocardio", "Aspirina 100mg + Clopidogrel", "Dr. Jorge Salinas"));
        historialP1.push(new Diagnostico("05/03/2026", "Post-cateterismo estable", "Estatinas 40mg",       "Dr. Jorge Salinas"));

        // ── Paciente 2 ────────────────────────────────────────────────────────────
        Paciente p2 = new Paciente("1005432109", "María González", "05/03/2026", 3, "Fractura de muñeca");
        PilaHistorial historialP2 = new PilaHistorial();

        historialP2.push(new Diagnostico("15/12/2025", "Esguince de tobillo",   "Ibuprofeno 400mg",    "Dra. Claudia Ríos"));
        historialP2.push(new Diagnostico("02/01/2026", "Osteopenia leve",       "Calcio + Vitamina D", "Dra. Claudia Ríos"));
        historialP2.push(new Diagnostico("18/02/2026", "Fractura radio distal", "Inmovilización + Acetaminofén", "Dr. Miguel Herrera"));
        historialP2.push(new Diagnostico("05/03/2026", "Control post-reducción", "Diclofenaco 75mg",   "Dr. Miguel Herrera"));

        // ── Mostrar historial inicial ─────────────────────────────────────────────
        System.out.println("\n>>> Historial de " + p1.getNombre() + ":");
        historialP1.mostrarHistorial();

        System.out.println("\n>>> Historial de " + p2.getNombre() + ":");
        historialP2.mostrarHistorial();

        // ── Peek: último diagnóstico de cada paciente ─────────────────────────────
        System.out.println("\n>>> Último diagnóstico de " + p1.getNombre() + " (peek):");
        System.out.println("    " + historialP1.peek());

        System.out.println("\n>>> Último diagnóstico de " + p2.getNombre() + " (peek):");
        System.out.println("    " + historialP2.peek());

        // ── Pop: eliminar el diagnóstico más reciente de p1 ──────────────────────
        System.out.println("\n>>> Eliminando último diagnóstico de " + p1.getNombre() + " (pop):");
        Diagnostico eliminado = historialP1.pop();
        System.out.println("    Eliminado → " + eliminado);

        System.out.println("\n>>> Historial actualizado de " + p1.getNombre() + " tras el pop:");
        historialP1.mostrarHistorial();
    }
}

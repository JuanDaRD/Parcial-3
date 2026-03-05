package clinica.moduloB;

import clinica.moduloA.Paciente;

/**
 * Clase principal del Módulo B — Historial Clínico con Pila.
 * Demuestra el uso de {@link PilaHistorial} con dos pacientes,
 * peek del diagnóstico más reciente y pop en uno de ellos.
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

        // ── Creación de dos pacientes ──
        Paciente p1 = new Paciente("1010101010", "Carlos Mendoza",    "05/03/2026", 2, "Dolor torácico");
        Paciente p2 = new Paciente("2020202020", "Luisa Fernanda Rios","05/03/2026", 1, "Paro respiratorio");

        // ── Historial de Paciente 1 (4 diagnósticos) ──
        PilaHistorial historialP1 = new PilaHistorial();
        historialP1.push(new Diagnostico("01/01/2026", "Hipertensión leve",      "Losartán 50mg",    "Dr. Gómez"));
        historialP1.push(new Diagnostico("10/01/2026", "Arritmia sinusal",       "Metoprolol 25mg",  "Dra. Reyes"));
        historialP1.push(new Diagnostico("20/02/2026", "Angina estable",         "Nitroglicerina",   "Dr. Suárez"));
        historialP1.push(new Diagnostico("05/03/2026", "Infarto leve (IAM)",     "Aspirina + Heparina","Dr. Suárez"));

        // ── Historial de Paciente 2 (4 diagnósticos) ──
        PilaHistorial historialP2 = new PilaHistorial();
        historialP2.push(new Diagnostico("15/12/2025", "Asma bronquial",         "Salbutamol inhalado","Dra. Vargas"));
        historialP2.push(new Diagnostico("03/01/2026", "Broncoespasmo agudo",    "Budesonida",       "Dra. Vargas"));
        historialP2.push(new Diagnostico("14/02/2026", "Neumonía bacteriana",    "Amoxicilina 1g",   "Dr. Mora"));
        historialP2.push(new Diagnostico("05/03/2026", "Paro respiratorio",      "Adrenalina IV",    "Dr. Mora"));

        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("  MÓDULO B — HISTORIAL CLÍNICO CON PILA");
        System.out.println("═══════════════════════════════════════════════════");

        // ── Historial completo de ambos pacientes ──
        System.out.println("\n► Historial de " + p1.getNombre() + ":");
        historialP1.mostrarHistorial();

        System.out.println("\n► Historial de " + p2.getNombre() + ":");
        historialP2.mostrarHistorial();

        // ── Peek: diagnóstico más reciente sin eliminar ──
        System.out.println("\n► Último diagnóstico de " + p1.getNombre() + " (peek): " + historialP1.peek());
        System.out.println("► Último diagnóstico de " + p2.getNombre() + " (peek): " + historialP2.peek());

        // ── Pop: eliminar el diagnóstico más reciente de Paciente 1 ──
        System.out.println("\n► Eliminando (pop) el diagnóstico más reciente de " + p1.getNombre() + "...");
        Diagnostico eliminado = historialP1.pop();
        System.out.println("  Registro eliminado: " + eliminado);

        System.out.println("\n► Historial actualizado de " + p1.getNombre() + ":");
        historialP1.mostrarHistorial();

        System.out.println("═══════════════════════════════════════════════════\n");
    }
}

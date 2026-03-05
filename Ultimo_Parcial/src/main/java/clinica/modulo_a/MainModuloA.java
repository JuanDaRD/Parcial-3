package clinica.modulo_a;

/**
 * Clase principal del Módulo A — Cola de Urgencias.
 * Demuestra el funcionamiento de {@link ColaPacientes} con enqueue, dequeue, peek y mostrarCola.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class MainModuloA {

    /**
     * Punto de entrada del Módulo A.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        ColaPacientes cola = new ColaPacientes();

        // ── Ingreso de 6 pacientes con distintos niveles de triage ──────────────
        cola.enqueue(new Paciente("1098765432", "Carlos Martínez",   "05/03/2026", 1, "Dolor precordial intenso"));
        cola.enqueue(new Paciente("1005432109", "María González",    "05/03/2026", 3, "Fractura de muñeca derecha"));
        cola.enqueue(new Paciente("1234567890", "Andrés López",      "05/03/2026", 5, "Resfriado común"));
        cola.enqueue(new Paciente("9876543210", "Laura Pérez",       "05/03/2026", 2, "Dificultad respiratoria"));
        cola.enqueue(new Paciente("1122334455", "Pedro Gómez",       "05/03/2026", 4, "Dolor abdominal leve"));
        cola.enqueue(new Paciente("5566778899", "Valentina Ruiz",    "05/03/2026", 3, "Traumatismo craneoencefálico leve"));

        System.out.println("\n>>> Estado inicial de la cola:");
        cola.mostrarCola();

        // ── Consultar primer paciente sin atenderlo ──────────────────────────────
        System.out.println("\n>>> Próximo a ser atendido (peek): " + cola.peek().getNombre());

        // ── Atender (dequeue) los 3 primeros pacientes ───────────────────────────
        System.out.println("\n>>> Iniciando atención de pacientes...\n");
        for (int turno = 1; turno <= 3; turno++) {
            Paciente atendido = cola.dequeue();
            if (atendido != null) {
                System.out.printf("Turno %d atendido → %s (Triage: %d)%n",
                    turno, atendido.getNombre(), atendido.getTriage());
            }
        }

        // ── Estado de la cola luego de las 3 atenciones ─────────────────────────
        System.out.println("\n>>> Estado de la cola después de 3 atenciones:");
        cola.mostrarCola();
    }
}

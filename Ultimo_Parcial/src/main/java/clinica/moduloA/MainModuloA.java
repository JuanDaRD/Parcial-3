package clinica.moduloA;

/**
 * Clase principal del Módulo A — Cola de Urgencias.
 * Demuestra el uso de {@link ColaPacientes} con al menos 6 pacientes,
 * atención de los 3 primeros y estado final de la cola.
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

        // ── Registro de 6 pacientes con distintos niveles de triage ──
        cola.enqueue(new Paciente("1010101010", "Carlos Mendoza",   "05/03/2026", 2, "Dolor torácico severo"));
        cola.enqueue(new Paciente("2020202020", "Luisa Fernanda Rios","05/03/2026", 1, "Paro respiratorio"));
        cola.enqueue(new Paciente("3030303030", "Pedro Ariza",      "05/03/2026", 4, "Fiebre alta"));
        cola.enqueue(new Paciente("4040404040", "María Camila Vega","05/03/2026", 3, "Fractura de muñeca"));
        cola.enqueue(new Paciente("5050505050", "Jorge Duarte",     "05/03/2026", 5, "Resfriado común"));
        cola.enqueue(new Paciente("6060606060", "Ana Lucía Torres", "05/03/2026", 2, "Crisis hipertensiva"));

        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("  MÓDULO A — COLA DE URGENCIAS");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("\n► Estado inicial de la cola:");
        cola.mostrarCola();

        // ── Atención de los 3 primeros pacientes ──
        System.out.println("\n► Atendiendo a los 3 primeros pacientes...\n");
        for (int turno = 1; turno <= 3; turno++) {
            Paciente atendido = cola.dequeue();
            System.out.printf("  Turno %d atendido: %s%n", turno, atendido);
        }

        // ── Estado de la cola tras las atenciones ──
        System.out.println("\n► Estado de la cola después de 3 atenciones:");
        cola.mostrarCola();

        // ── Próximo a ser atendido (peek sin eliminar) ──
        System.out.println("\n► Próximo paciente (peek): " + cola.peek());
        System.out.println("═══════════════════════════════════════════════════\n");
    }
}

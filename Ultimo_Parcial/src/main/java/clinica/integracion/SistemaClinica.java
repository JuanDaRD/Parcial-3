package clinica.integracion;

import clinica.moduloA.ColaPacientes;
import clinica.moduloA.Paciente;
import clinica.moduloB.Diagnostico;
import clinica.moduloB.PilaHistorial;
import clinica.moduloC.BST_Medicos;
import clinica.moduloC.Medico;

/**
 * Clase principal de integración — Sistema Clínica VidasPlus.
 *
 * <p>Integra los tres módulos en un flujo coherente de atención médica:
 * <ol>
 *   <li>Registro de 5 pacientes en la {@link ColaPacientes}.</li>
 *   <li>Atención del primer paciente (dequeue) con 3 diagnósticos en su {@link PilaHistorial}.</li>
 *   <li>Búsqueda en el BST del médico responsable del primer diagnóstico.</li>
 *   <li>Estado final: cola, pila del paciente atendido e inOrden del BST.</li>
 *   <li>Eliminación del médico con más pacientes atendidos y recálculo de altura.</li>
 * </ol>
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class SistemaClinica {

    /**
     * Punto de entrada del sistema integrado.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA CLÍNICA VIDASPLUS — INTEGRACIÓN TOTAL  ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // ════════════════════════════════════════════════════
        //  PASO 1: Registrar 5 pacientes en la ColaPacientes
        // ════════════════════════════════════════════════════
        System.out.println("\n─────────────────────────────────────────────────");
        System.out.println("  PASO 1 — Registro de pacientes en urgencias");
        System.out.println("─────────────────────────────────────────────────");

        ColaPacientes cola = new ColaPacientes();
        cola.enqueue(new Paciente("1010101010", "Carlos Mendoza",     "05/03/2026", 2, "Dolor torácico severo"));
        cola.enqueue(new Paciente("2020202020", "Luisa Fernanda Rios","05/03/2026", 1, "Paro respiratorio"));
        cola.enqueue(new Paciente("3030303030", "Pedro Ariza",        "05/03/2026", 4, "Fiebre alta"));
        cola.enqueue(new Paciente("4040404040", "María Camila Vega",  "05/03/2026", 3, "Fractura de muñeca"));
        cola.enqueue(new Paciente("5050505050", "Jorge Duarte",       "05/03/2026", 5, "Resfriado común"));

        cola.mostrarCola();

        // ════════════════════════════════════════════════════
        //  PASO 2: Atender al primer paciente y registrar 3 diagnósticos
        // ════════════════════════════════════════════════════
        System.out.println("\n─────────────────────────────────────────────────");
        System.out.println("  PASO 2 — Atención del primer paciente");
        System.out.println("─────────────────────────────────────────────────");

        Paciente pacienteAtendido = cola.dequeue();
        System.out.println("  Paciente atendido: " + pacienteAtendido);

        PilaHistorial historial = new PilaHistorial();
        historial.push(new Diagnostico("05/03/2026", "Hipertensión severa",  "Enalapril 10mg",       "Dr. Luis Gómez"));
        historial.push(new Diagnostico("05/03/2026", "Angina inestable",     "Nitroglicerina sublingual","Dra. Adriana Suárez"));
        historial.push(new Diagnostico("05/03/2026", "Infarto agudo (IAM)",  "Aspirina + Heparina IV","Dra. Adriana Suárez"));

        System.out.println("\n  Historial clínico registrado:");
        historial.mostrarHistorial();

        // ════════════════════════════════════════════════════
        //  PASO 3: Construcción del BST y búsqueda del médico
        // ════════════════════════════════════════════════════
        System.out.println("\n─────────────────────────────────────────────────");
        System.out.println("  PASO 3 — Búsqueda del médico en el BST");
        System.out.println("─────────────────────────────────────────────────");

        BST_Medicos bst = new BST_Medicos();
        bst.insertar(new Medico(50,  "Dra. Adriana Suárez",  "Cardiología",     "mañana", 320));
        bst.insertar(new Medico(30,  "Dr. Luis Gómez",       "Medicina General","tarde",  215));
        bst.insertar(new Medico(70,  "Dra. Patricia Reyes",  "Traumatología",   "noche",  180));
        bst.insertar(new Medico(10,  "Dr. Camilo Mora",      "Pediatría",       "mañana", 140));
        bst.insertar(new Medico(40,  "Dra. Sandra Vargas",   "Neurología",      "tarde",  260));
        bst.insertar(new Medico(60,  "Dr. Ricardo Peña",     "Ortopedia",       "noche",  195));
        bst.insertar(new Medico(90,  "Dr. Felipe Castro",    "Urgencias",       "mañana", 410));
        bst.insertar(new Medico(80,  "Dra. Marcela Torres",  "Cirugía General", "tarde",  290));
        bst.insertar(new Medico(100, "Dr. Andrés Lozano",    "Radiología",      "noche",  175));

        // El médico del primer diagnóstico empilado (más antiguo) es Dr. Luis Gómez (código 30)
        String medicoResponsable = "Dr. Luis Gómez";
        System.out.println("  Médico del primer diagnóstico: " + medicoResponsable);
        // Búsqueda por código conocido (30 = Dr. Luis Gómez)
        bst.imprimirBusqueda(30);

        // ════════════════════════════════════════════════════
        //  PASO 4: Estado final de cola, pila e inOrden BST
        // ════════════════════════════════════════════════════
        System.out.println("\n─────────────────────────────────────────────────");
        System.out.println("  PASO 4 — Estado final del sistema");
        System.out.println("─────────────────────────────────────────────────");

        System.out.println("\n  ► Cola de urgencias (pacientes en espera):");
        cola.mostrarCola();

        System.out.println("\n  ► Historial clínico de " + pacienteAtendido.getNombre() + ":");
        historial.mostrarHistorial();

        System.out.println("\n  ► Directorio BST (inOrden — orden por código):");
        bst.inOrden();
        System.out.println("  Altura del BST: " + bst.altura());

        // ════════════════════════════════════════════════════
        //  PASO 5: Eliminar médico con más pacientes atendidos
        //          El médico con más pacientes es Dr. Felipe Castro (código 90, 410 pacientes)
        // ════════════════════════════════════════════════════
        System.out.println("\n─────────────────────────────────────────────────");
        System.out.println("  PASO 5 — Eliminar médico con más pacientes atendidos");
        System.out.println("─────────────────────────────────────────────────");

        System.out.println("  Médico con mayor carga: Dr. Felipe Castro (cód. 90, 410 pacientes)");
        bst.eliminar(90);
        System.out.println("  ► InOrden tras eliminación:");
        bst.inOrden();
        System.out.println("  Nueva altura del BST: " + bst.altura());

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║         FIN DE LA SIMULACIÓN — VidasPlus         ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");
    }
}

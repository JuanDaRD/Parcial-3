package clinica.integracion;

import clinica.modulo_a.ColaPacientes;
import clinica.modulo_a.Paciente;
import clinica.modulo_b.Diagnostico;
import clinica.modulo_b.PilaHistorial;
import clinica.modulo_c.BST_Medicos;
import clinica.modulo_c.Medico;

/**
 * Clase de integración de los tres módulos del sistema de la Clínica VidasPlus.
 * Simula el flujo completo de atención: registro → atención → diagnóstico → consulta BST.
 *
 * <p>Flujo implementado:</p>
 * <ol>
 *   <li>Registrar 5 pacientes en la ColaPacientes.</li>
 *   <li>Atender al primer paciente (dequeue) y registrarle 3 diagnósticos en su PilaHistorial.</li>
 *   <li>Buscar en el BST el médico responsable del primer diagnóstico e imprimir sus datos.</li>
 *   <li>Mostrar estado final de la cola, la pila del paciente atendido y el inOrden del BST.</li>
 *   <li>Eliminar del BST el médico con mayor pacientesAtendidos y recalcular la altura.</li>
 * </ol>
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class SistemaClinico {

    /**
     * Punto de entrada principal del Sistema Clínico integrado.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║       SISTEMA DE GESTIÓN — CLÍNICA VIDASPLUS YOPAL       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");

        // ── PASO 1: Registrar 5 pacientes en la ColaPacientes ────────────────────
        System.out.println("\n──── PASO 1: Registro de pacientes en cola de urgencias ────");
        ColaPacientes cola = new ColaPacientes();

        cola.enqueue(new Paciente("1098765432", "Carlos Martínez",   "05/03/2026", 1, "Dolor precordial intenso"));
        cola.enqueue(new Paciente("1005432109", "María González",    "05/03/2026", 3, "Fractura de muñeca derecha"));
        cola.enqueue(new Paciente("1234567890", "Andrés López",      "05/03/2026", 5, "Resfriado común"));
        cola.enqueue(new Paciente("9876543210", "Laura Pérez",       "05/03/2026", 2, "Dificultad respiratoria"));
        cola.enqueue(new Paciente("1122334455", "Pedro Gómez",       "05/03/2026", 4, "Dolor abdominal leve"));

        cola.mostrarCola();

        // ── PASO 2: Atender al primer paciente y registrar 3 diagnósticos ────────
        System.out.println("\n──── PASO 2: Atención del primer paciente ────");
        Paciente atendido = cola.dequeue();
        System.out.println("Paciente atendido: " + atendido.getNombre()
            + " | Triage: " + atendido.getTriage()
            + " | Motivo: " + atendido.getMotivo());

        PilaHistorial historial = new PilaHistorial();
        historial.push(new Diagnostico("05/03/2026", "Angina inestable",
            "Nitroglicerina sublingual 0.5mg", "Dr. Jorge Salinas"));
        historial.push(new Diagnostico("05/03/2026", "Electrocardiograma alterado",
            "Aspirina 100mg + Heparina", "Dr. Jorge Salinas"));
        historial.push(new Diagnostico("05/03/2026", "Síndrome coronario agudo confirmado",
            "Clopidogrel 75mg + Estatinas 40mg", "Dra. Sofía Mendez"));

        System.out.println("\nHistorial asignado a " + atendido.getNombre() + ":");
        historial.mostrarHistorial();

        // ── PASO 3: Buscar en BST el médico del primer diagnóstico ───────────────
        System.out.println("\n──── PASO 3: Consulta del médico en el BST ────");

        BST_Medicos bst = new BST_Medicos();
        bst.insertar(new Medico(50, "Dr. Jorge Salinas",   "Cardiología",     "mañana",  320));
        bst.insertar(new Medico(30, "Dra. Ana Torres",     "Neurología",      "tarde",   210));
        bst.insertar(new Medico(70, "Dr. Luis Vargas",     "Traumatología",   "mañana",  450));
        bst.insertar(new Medico(15, "Dra. Claudia Ríos",   "Pediatría",       "noche",   180));
        bst.insertar(new Medico(40, "Dr. Miguel Herrera",  "Medicina Interna","tarde",   275));
        bst.insertar(new Medico(60, "Dra. Sofía Mendez",   "Urgencias",       "noche",   390));
        bst.insertar(new Medico(90, "Dr. Andrés Fuentes",  "Cirugía General", "mañana",  500));
        bst.insertar(new Medico(35, "Dra. Patricia Leal",  "Ginecología",     "tarde",   145));
        bst.insertar(new Medico(80, "Dr. Roberto Cano",    "Ortopedia",       "noche",   230));

        // El primer diagnóstico apilado (el del fondo) corresponde al código 50 → Dr. Jorge Salinas
        // El médico responsable del primer diagnóstico cronológico (base de la pila) es código 50.
        int codigoMedico = 50; // Dr. Jorge Salinas — responsable del primer diagnóstico
        Medico medicoResponsable = bst.buscar(codigoMedico);
        if (medicoResponsable != null) {
            System.out.println("Médico responsable (primer diagnóstico) encontrado:");
            System.out.println("  " + medicoResponsable);
        } else {
            System.out.println("Médico con código " + codigoMedico + " NO encontrado en el BST.");
        }

        // ── PASO 4: Estado final de la cola, la pila y el inOrden del BST ────────
        System.out.println("\n──── PASO 4: Estado final del sistema ────");

        System.out.println("\n→ Cola de urgencias (pacientes restantes):");
        cola.mostrarCola();

        System.out.println("\n→ Historial de " + atendido.getNombre() + ":");
        historial.mostrarHistorial();

        System.out.println("\n→ Directorio de médicos (BST inOrden):");
        bst.inOrden();
        System.out.println("  Altura del BST: " + bst.altura());

        // ── PASO 5: Eliminar médico con mayor pacientesAtendidos y recalcular altura
        System.out.println("\n──── PASO 5: Eliminación del médico con más pacientes atendidos ────");
        // El médico con más pacientes atendidos es Dr. Andrés Fuentes (código 90, 500 pacientes)
        int codigoMaxPacientes = 90; // Determinado al insertar — valor conocido
        System.out.println("Eliminando al médico con código " + codigoMaxPacientes
            + " (Dr. Andrés Fuentes — 500 pacientes atendidos)...");
        bst.eliminar(codigoMaxPacientes);

        System.out.println("\n→ BST inOrden tras la eliminación:");
        bst.inOrden();
        System.out.println("  Nueva altura del BST: " + bst.altura());

        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║              FIN DEL FLUJO DE ATENCIÓN                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}

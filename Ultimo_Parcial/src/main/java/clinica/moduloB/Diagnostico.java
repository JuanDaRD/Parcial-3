package clinica.moduloB;

/**
 * Representa un registro de diagnóstico médico almacenado en el historial clínico
 * de un paciente.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class Diagnostico {

    /** Fecha en que se realizó el diagnóstico (formato dd/mm/yyyy). */
    private String fecha;

    /** Descripción del diagnóstico médico. */
    private String diagnostico;

    /** Medicamento recetado al paciente. */
    private String medicamento;

    /** Nombre del médico responsable del diagnóstico. */
    private String medico;

    /**
     * Crea un registro de diagnóstico con todos sus campos.
     *
     * @param fecha       Fecha del diagnóstico.
     * @param diagnostico Descripción del diagnóstico.
     * @param medicamento Medicamento recetado.
     * @param medico      Médico responsable.
     */
    public Diagnostico(String fecha, String diagnostico, String medicamento, String medico) {
        this.fecha       = fecha;
        this.diagnostico = diagnostico;
        this.medicamento = medicamento;
        this.medico      = medico;
    }

    // ──────────────────────── Getters ────────────────────────

    /** @return Fecha del diagnóstico. */
    public String getFecha()       { return fecha; }

    /** @return Descripción del diagnóstico. */
    public String getDiagnostico() { return diagnostico; }

    /** @return Medicamento recetado. */
    public String getMedicamento() { return medicamento; }

    /** @return Médico responsable. */
    public String getMedico()      { return medico; }

    /**
     * Representación en cadena del diagnóstico.
     * @return String con todos los campos del registro.
     */
    @Override
    public String toString() {
        return String.format(
            "[Fecha: %s | Dx: %s | Medicamento: %s | Médico: %s]",
            fecha, diagnostico, medicamento, medico
        );
    }
}

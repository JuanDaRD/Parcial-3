package clinica.modulo_b;

/**
 * Representa un registro de diagnóstico médico dentro del historial clínico de un paciente.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class Diagnostico {

    /** Fecha en que se realizó el diagnóstico (formato DD/MM/YYYY). */
    private String fecha;

    /** Descripción del diagnóstico clínico. */
    private String diagnostico;

    /** Medicamento recetado al paciente. */
    private String medicamento;

    /** Nombre del médico responsable del diagnóstico. */
    private String medico;

    /**
     * Constructor que inicializa todos los campos del diagnóstico.
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

    /** @return Fecha del diagnóstico. */
    public String getFecha() { return fecha; }

    /** @return Descripción del diagnóstico. */
    public String getDiagnostico() { return diagnostico; }

    /** @return Medicamento recetado. */
    public String getMedicamento() { return medicamento; }

    /** @return Nombre del médico responsable. */
    public String getMedico() { return medico; }

    /**
     * Representación en cadena del diagnóstico.
     * @return String con todos los campos del diagnóstico.
     */
    @Override
    public String toString() {
        return String.format(
            "Diagnostico{fecha='%s', dx='%s', medicamento='%s', medico='%s'}",
            fecha, diagnostico, medicamento, medico
        );
    }
}

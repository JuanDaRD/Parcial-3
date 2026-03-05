package clinica.moduloA;

/**
 * Representa un paciente registrado en el sistema de urgencias de la Clínica VidasPlus.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class Paciente {

    /** Número de documento de identidad del paciente. */
    private String documento;

    /** Nombre completo del paciente. */
    private String nombre;

    /** Fecha de ingreso al área de urgencias (formato dd/mm/yyyy). */
    private String fechaIngreso;

    /** Nivel de triage asignado (1 = crítico, 5 = menos urgente). */
    private int triage;

    /** Motivo de consulta del paciente. */
    private String motivo;

    /**
     * Constructor que inicializa todos los atributos del paciente.
     *
     * @param documento   Número de documento del paciente.
     * @param nombre      Nombre completo del paciente.
     * @param fechaIngreso Fecha de ingreso en formato dd/mm/yyyy.
     * @param triage      Nivel de triage (1 a 5).
     * @param motivo      Motivo de consulta.
     */
    public Paciente(String documento, String nombre, String fechaIngreso, int triage, String motivo) {
        this.documento   = documento;
        this.nombre      = nombre;
        this.fechaIngreso = fechaIngreso;
        this.triage      = triage;
        this.motivo      = motivo;
    }

    // ──────────────────────── Getters ────────────────────────

    /**
     * Retorna el número de documento del paciente.
     * @return documento
     */
    public String getDocumento()   { return documento; }

    /**
     * Retorna el nombre completo del paciente.
     * @return nombre
     */
    public String getNombre()      { return nombre; }

    /**
     * Retorna la fecha de ingreso del paciente.
     * @return fechaIngreso
     */
    public String getFechaIngreso(){ return fechaIngreso; }

    /**
     * Retorna el nivel de triage del paciente.
     * @return triage (1–5)
     */
    public int getTriage()         { return triage; }

    /**
     * Retorna el motivo de consulta del paciente.
     * @return motivo
     */
    public String getMotivo()      { return motivo; }

    /**
     * Representación en cadena del paciente con todos sus datos.
     * @return String con los datos del paciente.
     */
    @Override
    public String toString() {
        return String.format(
            "[Doc: %s | Nombre: %s | Ingreso: %s | Triage: %d | Motivo: %s]",
            documento, nombre, fechaIngreso, triage, motivo
        );
    }
}

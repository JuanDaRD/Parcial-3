package clinica.modulo_a;

/**
 * Representa a un paciente registrado en el área de urgencias de la Clínica VidasPlus.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class Paciente {

    /** Número de documento de identidad del paciente. */
    private String documento;

    /** Nombre completo del paciente. */
    private String nombre;

    /** Fecha de ingreso a urgencias (formato DD/MM/YYYY). */
    private String fechaIngreso;

    /**
     * Nivel de triage del paciente (1 = crítico, 5 = leve).
     * Según el sistema de clasificación de urgencias hospitalarias.
     */
    private int triage;

    /** Motivo de consulta del paciente. */
    private String motivo;

    /**
     * Constructor que inicializa todos los atributos del paciente.
     *
     * @param documento   Número de documento de identidad.
     * @param nombre      Nombre completo del paciente.
     * @param fechaIngreso Fecha de ingreso en formato DD/MM/YYYY.
     * @param triage      Nivel de triage (1-5).
     * @param motivo      Motivo de consulta.
     */
    public Paciente(String documento, String nombre, String fechaIngreso, int triage, String motivo) {
        this.documento   = documento;
        this.nombre      = nombre;
        this.fechaIngreso = fechaIngreso;
        this.triage      = triage;
        this.motivo      = motivo;
    }

    /**
     * Retorna el número de documento del paciente.
     * @return documento
     */
    public String getDocumento() { return documento; }

    /**
     * Retorna el nombre completo del paciente.
     * @return nombre
     */
    public String getNombre() { return nombre; }

    /**
     * Retorna la fecha de ingreso del paciente.
     * @return fechaIngreso
     */
    public String getFechaIngreso() { return fechaIngreso; }

    /**
     * Retorna el nivel de triage del paciente.
     * @return triage (1-5)
     */
    public int getTriage() { return triage; }

    /**
     * Retorna el motivo de consulta del paciente.
     * @return motivo
     */
    public String getMotivo() { return motivo; }

    /**
     * Retorna una representación en cadena del paciente con todos sus datos.
     * @return String con la información del paciente.
     */
    @Override
    public String toString() {
        return String.format(
            "Paciente{doc='%s', nombre='%s', ingreso='%s', triage=%d, motivo='%s'}",
            documento, nombre, fechaIngreso, triage, motivo
        );
    }
}

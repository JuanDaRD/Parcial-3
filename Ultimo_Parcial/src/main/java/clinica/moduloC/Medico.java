package clinica.moduloC;

/**
 * Representa un médico registrado en el directorio de la Clínica VidasPlus.
 * Es la entidad almacenada en cada nodo del BST de médicos.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class Medico {

    /** Código único del médico (criterio de ordenación en el BST). */
    private int codigo;

    /** Nombre completo del médico. */
    private String nombre;

    /** Especialidad médica. */
    private String especialidad;

    /** Turno de trabajo: mañana, tarde o noche. */
    private String turno;

    /** Número total de pacientes atendidos por este médico. */
    private int pacientesAtendidos;

    /**
     * Construye un médico con todos sus atributos.
     *
     * @param codigo             Código único del médico.
     * @param nombre             Nombre completo.
     * @param especialidad       Especialidad.
     * @param turno              Turno (mañana / tarde / noche).
     * @param pacientesAtendidos Número de pacientes atendidos.
     */
    public Medico(int codigo, String nombre, String especialidad,
                  String turno, int pacientesAtendidos) {
        this.codigo              = codigo;
        this.nombre              = nombre;
        this.especialidad        = especialidad;
        this.turno               = turno;
        this.pacientesAtendidos  = pacientesAtendidos;
    }

    // ──────────────────────── Getters ────────────────────────

    /** @return Código único del médico. */
    public int getCodigo()               { return codigo; }

    /** @return Nombre completo del médico. */
    public String getNombre()            { return nombre; }

    /** @return Especialidad médica. */
    public String getEspecialidad()      { return especialidad; }

    /** @return Turno de trabajo. */
    public String getTurno()             { return turno; }

    /** @return Número de pacientes atendidos. */
    public int getPacientesAtendidos()   { return pacientesAtendidos; }

    /**
     * Representación en cadena del médico.
     * @return String con todos los datos del médico.
     */
    @Override
    public String toString() {
        return String.format(
            "[Cód: %03d | %s | %s | Turno: %s | Pacientes: %d]",
            codigo, nombre, especialidad, turno, pacientesAtendidos
        );
    }
}

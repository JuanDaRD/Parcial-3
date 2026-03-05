package clinica.modulo_c;

/**
 * Representa un médico del directorio de la Clínica VidasPlus.
 * El atributo {@code codigo} es la clave de ordenación en el BST.
 *
 * @author Juan Rivera
 * @version 1.0
 */
public class Medico {

    /** Código único del médico (clave del BST). */
    private int codigo;

    /** Nombre completo del médico. */
    private String nombre;

    /** Especialidad médica (ej. Cardiología, Traumatología). */
    private String especialidad;

    /** Turno de trabajo: "mañana", "tarde" o "noche". */
    private String turno;

    /** Número total de pacientes atendidos por el médico. */
    private int pacientesAtendidos;

    /**
     * Constructor que inicializa todos los atributos del médico.
     *
     * @param codigo             Código único del médico.
     * @param nombre             Nombre completo.
     * @param especialidad       Especialidad médica.
     * @param turno              Turno de trabajo.
     * @param pacientesAtendidos Número de pacientes atendidos.
     */
    public Medico(int codigo, String nombre, String especialidad, String turno, int pacientesAtendidos) {
        this.codigo             = codigo;
        this.nombre             = nombre;
        this.especialidad       = especialidad;
        this.turno              = turno;
        this.pacientesAtendidos = pacientesAtendidos;
    }

    /** @return Código único del médico. */
    public int getCodigo() { return codigo; }

    /** @return Nombre completo del médico. */
    public String getNombre() { return nombre; }

    /** @return Especialidad del médico. */
    public String getEspecialidad() { return especialidad; }

    /** @return Turno de trabajo del médico. */
    public String getTurno() { return turno; }

    /** @return Número de pacientes atendidos. */
    public int getPacientesAtendidos() { return pacientesAtendidos; }

    /**
     * Representación en cadena del médico.
     * @return String con todos los campos del médico.
     */
    @Override
    public String toString() {
        return String.format(
            "Medico{codigo=%d, nombre='%s', especialidad='%s', turno='%s', pacientesAtendidos=%d}",
            codigo, nombre, especialidad, turno, pacientesAtendidos
        );
    }
}

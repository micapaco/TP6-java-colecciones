public class Asignatura {
    private Integer codigo;
    private Profesor instructor;

    public Asignatura() {}

    public Asignatura(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Profesor getInstructor() {
        return instructor;
    }

    public void setInstructor(Profesor instructor) {
        this.instructor = instructor;
    }

    public void mostrarDatos() {
        System.out.println("Asignatura Código: " + codigo);
        if (instructor != null) {
            System.out.println("Profesor a cargo: " + instructor.getNombre());
        }
    }
}

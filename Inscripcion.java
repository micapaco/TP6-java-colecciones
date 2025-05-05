import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Inscripcion {
    private Date fecha;
    private Asignatura asignatura;
    private Profesor profesor;
    private Map<Integer, Estudiante> formulario;

    // Constructor con parámetros
    public Inscripcion(Date fecha, Asignatura asignatura, Profesor profesor) {
        this.fecha = fecha;
        this.asignatura = asignatura;
        this.profesor = profesor;
        this.formulario = new HashMap<>();
    }

    // Método para inscribir un estudiante
    public void inscribirEstudiante(Estudiante estudiante) {
        formulario.put(estudiante.legajo, estudiante);
    }

    // Método para verificar si un estudiante está inscrito
    public boolean estaInscrito(int legajoEstudiante) {
        return formulario.containsKey(legajoEstudiante);
    }

    public Date getFecha() {
        return fecha;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Map<Integer, Estudiante> getFormulario() {
        return formulario;
    }

    // Método para mostrar los datos de la inscripción
    public void mostrarDatos() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Asignatura: " + asignatura.getCodigo());
        System.out.println("Profesor: " + profesor.getNombre());
        System.out.println("Estudiantes inscriptos:");
        for (Estudiante e : formulario.values()) {
            System.out.println(" - " + e.getNombre());
        }
    }
}

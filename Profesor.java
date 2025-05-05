import java.util.ArrayList;

public class Profesor extends Persona {
    private ArrayList<Asignatura> cursos;
    private ArrayList<Inscripcion> inscripciones;

    public Profesor() {
        cursos = new ArrayList<>();
        inscripciones = new ArrayList<>();
    }

    public Profesor(String nombre, Integer legajo) {
        super(nombre, legajo);
        cursos = new ArrayList<>();
        inscripciones = new ArrayList<>();
    }

    public void agregarAsignatura(Asignatura a) {
        cursos.add(a);
        a.setInstructor(this);
    }

    public void agregarInscripcion(Inscripcion insc) {
        inscripciones.add(insc);
    }

    // Mostrar las asignaturas que imparte el profesor
    public void mostrarAsignaturas() {
        System.out.println("\nProfesor: " + getNombre() + " (Legajo: " + legajo + ")");
        System.out.println("Asignaturas que imparte:");
        for (Asignatura a : cursos) {
            System.out.println(" - Código: " + a.getCodigo());
        }
    }

    // Mostrar la cantidad de inscriptos para una asignatura elegida
    public boolean mostrarCantidadInscriptos(Integer codigoAsignatura) {
        for (Inscripcion insc : inscripciones) {
            if (insc.getAsignatura().getCodigo().equals(codigoAsignatura)) {
                System.out.println("\n--- Datos del Profesor ---");
                System.out.println("Nombre: " + this.getNombre());
                System.out.println("Legajo: " + legajo);
                System.out.println("Asignatura código: " + codigoAsignatura);
                System.out.println("Cantidad de inscriptos: " + insc.getFormulario().size());
                return true;
            }
        }
        return false;
    }

}

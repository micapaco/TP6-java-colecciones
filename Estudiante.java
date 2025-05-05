import java.util.ArrayList;

public class Estudiante extends Persona {
    public Estudiante() {}

    public Estudiante(String nombre, Integer legajo) {
        super(nombre, legajo);
    }
    public void mostrarAsignaturasConProfesores(ArrayList<Inscripcion> inscripciones) {
        System.out.println("\nAsignaturas en las que se inscribió " + nombre + " y su profesor:");
        for (Inscripcion insc : inscripciones) {
            if (insc.getFormulario().containsKey(legajo)) {
                System.out.println("Asignatura: " + insc.getAsignatura().getCodigo() +
                        " - Profesor: " + insc.getProfesor().getNombre());
            }
        }
    }

    public void mostrarFechasDeInscripcion(ArrayList<Inscripcion> inscripciones) {
        System.out.println("\nFechas de inscripción de " + nombre + ":");
        for (Inscripcion insc : inscripciones) {
            if (insc.getFormulario().containsKey(legajo)) {
                System.out.println("Fecha: " + insc.getFecha() +
                        " - Asignatura: " + insc.getAsignatura().getCodigo());
            }
        }
    }

}

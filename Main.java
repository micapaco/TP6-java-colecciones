import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear Profesores
        Profesor prof1 = new Profesor("Prof. Lopez", 101);
        Profesor prof2 = new Profesor("Prof. Rodriguez", 109);

        // Crear Asignaturas
        Asignatura mat = new Asignatura(1001);
        Asignatura fis = new Asignatura(1002);
        Asignatura bio = new Asignatura(1003);

        // Asignar asignaturas a profesores
        prof1.agregarAsignatura(mat);
        prof2.agregarAsignatura(fis);
        prof2.agregarAsignatura(bio);

        // Crear Estudiantes
        Estudiante est1 = new Estudiante("Ana", 201);
        Estudiante est2 = new Estudiante("Luis", 202);
        Estudiante est3 = new Estudiante("Sofía", 203);

        // Crear Inscripciones
        Inscripcion inscMat = new Inscripcion(new Date(), mat, prof1);
        inscMat.inscribirEstudiante(est1);
        inscMat.inscribirEstudiante(est2);

        Inscripcion inscFis = new Inscripcion(new Date(), fis, prof2);
        inscFis.inscribirEstudiante(est1);
        inscFis.inscribirEstudiante(est3);

        Inscripcion inscBio = new Inscripcion(new Date(), bio, prof2);
        inscBio.inscribirEstudiante(est2);
        inscBio.inscribirEstudiante(est3);

        // Agregar inscripciones a los profesores
        prof1.agregarInscripcion(inscMat);
        prof2.agregarInscripcion(inscFis);
        prof2.agregarInscripcion(inscBio);

        // Inscripciones en lista
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        inscripciones.add(inscMat);
        inscripciones.add(inscFis);
        inscripciones.add(inscBio);

        // D1 - Asignaturas que imparte un profesor
        System.out.println("\n--- D1: Asignaturas que imparte el profesor ---");
        prof1.mostrarDatos();
        prof2.mostrarDatos();

        // D2 - Datos del profesor y cantidad de alumnos inscriptos desde el objeto Profesor
        System.out.print("\n--- D2: Ingrese el código de asignatura para ver inscriptos: ");
        Integer codBuscar = scanner.nextInt();

        // Buscar desde los profesores
        boolean hayinsc = false;
        if (prof1.mostrarCantidadInscriptos(codBuscar)) hayinsc = true;
        if (prof2.mostrarCantidadInscriptos(codBuscar)) hayinsc = true;

        if (!hayinsc) {
            System.out.println("Ningún profesor imparte esa asignatura o no hay inscriptos.");
        }

        // E1-Asignaturas de un estudiante y el profesor que la imparte
        est1.mostrarAsignaturasConProfesores(inscripciones);
        est2.mostrarAsignaturasConProfesores(inscripciones);
        est3.mostrarAsignaturasConProfesores(inscripciones);
        // E2-Fechas de inscripción y asignaturas del estudiante
        est1.mostrarFechasDeInscripcion(inscripciones);
        est2.mostrarFechasDeInscripcion(inscripciones);
        est3.mostrarFechasDeInscripcion(inscripciones);

        // F1 - Desde cada inscripción
        System.out.println("\n--- F1: Datos de cada inscripción ---");
        for (Inscripcion insc : inscripciones) {
            insc.mostrarDatos();
            System.out.println("--------------------");
        }

        // F2 - Todas las asignaturas en que se inscribió un alumno dado
        System.out.print("\n--- F2: Ingrese legajo de estudiante para ver sus inscripciones: ");
        Integer legajoBuscar = scanner.nextInt();
        int contador = 0;

        for (Inscripcion insc : inscripciones) {
            if (insc.estaInscrito(legajoBuscar)) {
                System.out.println("Asignatura: " + insc.getAsignatura().getCodigo());
                System.out.println("Profesor: " + insc.getProfesor().getNombre());
                System.out.println("Fecha de inscripción: " + insc.getFecha());
                System.out.println("--------------------");
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("No se encontraron inscripciones para el legajo ingresado.");
        } else if (contador < 2) {
            System.out.println("Advertencia: El alumno está inscripto en menos de dos asignaturas.");
        }

        scanner.close();
    }
}
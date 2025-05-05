public class Persona {
    protected String nombre;
    public Integer legajo;

    public Persona() {}

    public Persona(String nombre, Integer legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Legajo: " + legajo);
    }
}

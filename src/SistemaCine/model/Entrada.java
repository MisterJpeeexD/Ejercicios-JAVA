package SistemaCine.model;

public class Entrada {
    private Pelicula pelicula;
    private Funcion funcion;
    private int numeroAsiento; // Modificado según el Paso 7

    public Entrada(Pelicula pelicula, Funcion funcion, int numeroAsiento) {
        this.pelicula = pelicula;
        this.funcion = funcion;
        this.numeroAsiento = numeroAsiento;
    }

    public Pelicula getPelicula() { return pelicula; }
    public Funcion getFuncion() { return funcion; }
    public int getNumeroAsiento() { return numeroAsiento; }

    public void mostrarEntrada() {
        System.out.println("Película: " + pelicula.getTitle() +
                " | Horario: " + funcion.getStartTime() + " ~ " + funcion.getEndTime() +
                " | Asiento Asignado: Nº " + numeroAsiento);
    }
}
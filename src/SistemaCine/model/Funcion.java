package SistemaCine.model;

public class Funcion {
    protected String startTime;
    protected String endTime;

    protected boolean[] asientos = new boolean[50];

    public Funcion(String startTime, String endTime, int capacity) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    public int getRoomCapacity() {
        int disponibles = 0;
        for (boolean ocupado : asientos) {
            if (!ocupado) disponibles++;
        }
        return disponibles;
    }

    public void mostrarMapaAsientos() {
        System.out.println("\n--- Mapa de Asientos (X = Ocupado) ---");
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i]) {
                System.out.print("[ X ] "); // Ocupado
            } else {
                System.out.printf("[%2d] ", (i + 1)); // Disponible (Base 1 para el usuario)
            }
            if ((i + 1) % 10 == 0) System.out.println();
        }
        System.out.println("---------------------------------------");
    }

    public boolean asientoEstaLibre(int numeroAsiento) {
        int index = numeroAsiento - 1; // Conversión a Base 0
        if (index < 0 || index >= asientos.length) return false;
        return !asientos[index];
    }

    public void ocuparAsiento(int numeroAsiento) {
        asientos[numeroAsiento - 1] = true;
    }
}
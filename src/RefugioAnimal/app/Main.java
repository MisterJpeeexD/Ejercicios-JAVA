package RefugioAnimal.app;

import RefugioAnimal.services.*;

public class Main {

    public static void main(String[] args) {
        RefugioService servicio = new RefugioService();
        servicio.iniciar();
    }
}
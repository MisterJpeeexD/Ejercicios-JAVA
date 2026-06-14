package SistemaCine.service;

import SistemaCine.model.Cliente;
import SistemaCine.model.Entrada;
import SistemaCine.model.Funcion;
import SistemaCine.model.Pelicula;
import SistemaCine.util.Utilidades;

import java.util.*;

public class CineService {

    static List<Cliente> clientes = new ArrayList<>();
    static List<Pelicula> peliculas = new ArrayList<>();
    static Map<Pelicula, List<Funcion>> funciones = new HashMap<>();

    // Carga de peliculas
    public static void LoadMovies() {
        peliculas.add(new Pelicula("Inception", 148));
        peliculas.add(new Pelicula("The Dark Knight", 152));
        peliculas.add(new Pelicula("Avatar", 162));
        peliculas.add(new Pelicula("Gladiator", 155));
        peliculas.add(new Pelicula("Jurassic Park", 127));
    }

    // Carga de hora de funciones
    public static void LoadFunctions() {
        for(Pelicula p : peliculas) {

            List<Funcion> Functions = new ArrayList<>();

            Functions.add(new Funcion("10:00", "13:00",50));
            Functions.add(new Funcion("13:00", "16:00",50));
            Functions.add(new Funcion("16:00", "19:00",50));
            Functions.add(new Funcion("19:00", "22:00",50));

            funciones.put(p,Functions);
        }
    }

    public static void showFuntions(){
        System.out.println("Funciones disponibles: ");
        for (Map.Entry<Pelicula, List<Funcion>> pelicula : funciones.entrySet()) {
            Pelicula verFunciones = pelicula.getKey();
            List<Funcion> listaDeFunciones = pelicula.getValue();

            System.out.println();
            System.out.println("Pelicula: " + verFunciones.getTitle());
            System.out.println("Horarios disponibles: ");
            for (Funcion f : listaDeFunciones) {
                System.out.println("- Desde las " + f.getStartTime() + " ~ " + f.getEndTime() + "[ Quedan " + f.getRoomCapacity() + " ticket disponible/s ]" );
            }
        }
    }

    public static void newClient(){
        System.out.println();
        System.out.print("Ingrese el nombre del cliente: ");
        String newClient = Utilidades.NewStr();
        Cliente addClient = new Cliente(newClient);
        clientes.add(addClient);
        System.out.println();
        System.out.println("Se ha creado con exito el cliente " + newClient + ". Bienvenido/a!");
    }

    public static void sellTicket() {
        System.out.println();
        if (clientes.isEmpty()) {
            System.out.println("Error: No hay clientes registrados en el sistema. Cree uno primero.");
            return;
        }

        System.out.println("\n¿A qué película se aplicará?: ");
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println((i + 1) + ") " + peliculas.get(i).getTitle());
        }

        System.out.print("Selecciona una opción: ");
        int optionMovie = Utilidades.NewInt();
        if (optionMovie < 1 || optionMovie > peliculas.size()) {
            System.out.println("Selección inválida, saliendo...");
            return;
        }

        Pelicula selectMovie = peliculas.get(optionMovie - 1);
        List<Funcion> listaDeFunciones = funciones.get(selectMovie);

        System.out.println("\n¿A qué función deseas aplicar para " + selectMovie.getTitle() + "?:");
        for (int i = 0; i < listaDeFunciones.size(); i++) {
            Funcion f = listaDeFunciones.get(i);
            System.out.println((i + 1) + ") " + f.getStartTime() + " ~ " + f.getEndTime() + " [Disponibles: " + f.getRoomCapacity() + "]");
        }

        System.out.print("Ingresa una opción: ");
        int functionSelect = Utilidades.NewInt();

        while (functionSelect < 1 || functionSelect > listaDeFunciones.size()) {
            System.out.println("Opción de función incorrecta, intenta de nuevo:");
            functionSelect = Utilidades.NewInt();
        }

        Funcion selectedFunction = listaDeFunciones.get(functionSelect - 1);

        if (selectedFunction.getRoomCapacity() == 0) {
            System.out.println("Lo sentimos, esta función no tiene asientos disponibles.");
            return;
        }

        selectedFunction.mostrarMapaAsientos();

        System.out.print("Ingrese el número de asiento que desea comprar (1-50): ");
        int numeroAsiento = Utilidades.NewInt();

        while (numeroAsiento < 1 || numeroAsiento > 50 || !selectedFunction.asientoEstaLibre(numeroAsiento)) {
            System.out.println("Asiento inválido u ocupado. Por favor, seleccione un asiento libre del mapa:");
            numeroAsiento = Utilidades.NewInt();
        }

        System.out.println();
        System.out.printf("""
                ¿Está correcto?: 
                =================
                Película: %s 
                Función: %s ~ %s 
                Asiento: Nº %d
                =================
                1) Si
                2) No
                =================
                """, selectMovie.getTitle(), selectedFunction.getStartTime(), selectedFunction.getEndTime(), numeroAsiento);

        System.out.print("Seleccione una opción: ");
        int finalOption = Utilidades.NewInt();

        if (finalOption == 1) {
            System.out.println("\n¿A quién desea asignar la entrada?");
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println((i + 1) + ") " + clientes.get(i).getName());
            }

            System.out.print("Seleccione el cliente: ");
            int selClient = Utilidades.NewInt();

            while (selClient < 1 || selClient > clientes.size()) {
                System.out.println("Cliente inválido, inténtalo de nuevo.");
                System.out.print("Ingresa una opción válida: ");
                selClient = Utilidades.NewInt();
            }

            Cliente clienteAsignado = clientes.get(selClient - 1);

            selectedFunction.ocuparAsiento(numeroAsiento);
            Entrada nuevaEntrada = new Entrada(selectMovie, selectedFunction, numeroAsiento);
            clienteAsignado.agregarEntrada(nuevaEntrada);

            System.out.println("\n¡Éxito! Entrada asignada correctamente a " + clienteAsignado.getName());
        } else {
            System.out.println("Solicitud cancelada.");
        }
    }

    public static void showClientTickets() {
        System.out.println("\n=== VER ENTRADAS DE CLIENTE ===");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ") " + clientes.get(i).getName());
        }
        System.out.print("Seleccione un cliente para ver sus entradas: ");
        int selClient = Utilidades.NewInt();

        if (selClient < 1 || selClient > clientes.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Cliente c = clientes.get(selClient - 1);
        List<Entrada> entradas = c.getMisEntradas();

        System.out.println("\nHistorial de entradas de " + c.getName() + ":");
        if (entradas.isEmpty()) {
            System.out.println("Este cliente no ha comprado entradas aún.");
        } else {
            for (Entrada e : entradas) {
                e.mostrarEntrada();
            }
        }
    }

    public static void menu(){
        LoadMovies();
        LoadFunctions();
        int menuOption = 0;
        boolean status = true;
        while(status) {
            System.out.println();
            System.out.println("""
                    +-------------------------------------------+
                    | Bienvenido al menu de compra de tickets   |
                    |       para funciones de CineGen           |
                    +-------------------------------------------+
                    | 1) Crear cliente                          |
                    | 2) Ver cartelera                          |
                    | 3) Comprar entrada                        |
                    | 4) Ver entradas del cliente               |
                    | 0) Salir                                  |
                    +-------------------------------------------+
                    """);
            System.out.print("¿Que desea accion desea realizar?: ");
            menuOption = Utilidades.NewInt();
            switch (menuOption){
                case 1:
                    newClient();
                    break;
                case 2:
                    showFuntions();
                    break;
                case 3:
                    sellTicket();
                    break;
                case 4:
                    showClientTickets();
                    break;
                case 0:
                    status = false;
                    break;
                default:
                    System.out.println("Opcion ingresada invalida, intentalo de nuevo");
                    System.out.println();
                    break;
            }
        }
    }
}

package RefugioAnimal.services;

import RefugioAnimal.interfaces.Adoptable;
import RefugioAnimal.model.Cliente;
import RefugioAnimal.model.Gato;
import RefugioAnimal.model.Mascota;
import RefugioAnimal.model.Perro;
import RefugioAnimal.util.InputUtil;

import java.util.*;

import static RefugioAnimal.util.InputUtil.RevisarEdad;

public class RefugioService {
    public static Scanner input = new Scanner(System.in);
    private List<Cliente> clientes = new ArrayList<>();
    private Map<Cliente, List<Mascota>> MapPet = new HashMap<>();

    public boolean CheckDuplicity(String name, int year) {
        for (List<Mascota> ClientList : MapPet.values()) {
            for (Mascota m : ClientList) {
                if (m.getNombre().equalsIgnoreCase(name) && m.getEdad() == year) {
                    return true;
                }
            }
        }
        return false;
    }

    public void crearCliente() {
        System.out.println();
        String ClientValue = InputUtil.leerString("Ingresa el nombre del cliente: ");
        Cliente NewClient = new Cliente(ClientValue);
        clientes.add(NewClient);

        MapPet.put(NewClient, new ArrayList<>()); // Se crea un cliente nuevo con el nombre asignado a new client y se le define una lista vacia
        System.out.println("Cliente " + ClientValue + " registrado con éxito.");
    }

    public void registrarMascota() {
        if (clientes.isEmpty()) {
            System.out.println("Error: Debe existir al menos un cliente para registrar una mascota.");
            return;
        }

        boolean RegMascotaCheck = true;
        int PetType = 0;
        while (RegMascotaCheck) {
            System.out.println();
            System.out.println("""
                    ¿Ingresara un gato o un perro?
                    1) Gato
                    2) Perro
                    """);
            System.out.print("Ingrese una opción: ");
            PetType = InputUtil.leerInt();
            if (PetType != 1 && PetType != 2) {
                System.out.println("Selección invalida, intentalo de nuevo");
            } else {
                RegMascotaCheck = false;
            }
        }
        String PetName = InputUtil.leerString("Ingresa el nombre de la mascota : ");
        System.out.print("Ingresa la edad de la mascota (en años): ");
        int PetYear = RevisarEdad();

        if (CheckDuplicity(PetName, PetYear)) {
            System.out.println("Error: La mascota " + PetName + " con edad " + PetYear + " ya se encuentra registrada");
            return;
        }

        System.out.println("\nSelecciona el índice del cliente responsable:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + ") " + clientes.get(i).getNombre());
        }
        int clientIndex = InputUtil.leerInt();
        Cliente SelectedClient = clientes.get(clientIndex);

        Mascota NewPet;
        if (PetType == 1) {
            NewPet = new Gato(PetName, PetYear);
        } else {
            NewPet = new Perro(PetName, PetYear);
        }

        MapPet.get(SelectedClient).add(NewPet);
        System.out.println(PetName + " ha sido registrado/a con éxito bajo la responsabilidad de " + SelectedClient.getNombre());
    }

    public void mostrarDatos() {
        System.out.println("\n=== REGISTRO GENERAL DE ADOPCIONES ===");
        if (MapPet.isEmpty()) {
            System.out.println("No hay datos registrados.");
            return;
        }
        for (Map.Entry<Cliente, List<Mascota>> register : MapPet.entrySet()) {
            System.out.println("Cliente: " + register.getKey().getNombre());
            List<Mascota> mascotasDelCliente = register.getValue();
            if (mascotasDelCliente.isEmpty()) {
                System.out.println("  [Sin mascotas adoptadas]");
            } else {
                for (Mascota m : mascotasDelCliente) {
                    System.out.print("  - ");
                    m.mostrarInfo();
                    m.hacerSonido();
                }
            }

        }
    }

    public void MascotasAdoptables() {
        int contadorPerros = 0;
        int contadorGatos = 0;
        System.out.println("\nMascotas disponibles de adopción (En el Refugio): ");
        boolean hayAdoptables = false;

        for (Map.Entry<Cliente, List<Mascota>> register : MapPet.entrySet()) {
            Cliente client = register.getKey();

            if (client.getNombre().equalsIgnoreCase("Refugio")) {
                List<Mascota> PetList = register.getValue();

                for (Mascota m : PetList) {
                    if (m instanceof Adoptable) {
                        hayAdoptables = true;
                        Adoptable PetAdoptable = (Adoptable) m;
                        System.out.println("- " + PetAdoptable.datosAdopcion() + " (Responsable: " + client.getNombre() + ")");
                        if (m instanceof Perro) {
                            contadorPerros++;
                        } else if (m instanceof Gato) {
                            contadorGatos++;
                        }
                    }
                }
                System.out.println();
                System.out.println("Hay un total de " + contadorGatos + " gato/s y " + contadorPerros + " perro/s");
            }
        }

        if (!hayAdoptables) {
            System.out.println("No hay ninguna mascota registrada en el refugio que sea adoptable.");
        }
    }

    public void Adoptar() {
        if (clientes.size() <= 1) {
            System.out.println("Error: Debe existir al menos un cliente registrado para poder adoptar.");
            return;
        }

        int OptionAdopt = 0;
        boolean cancelar = true;

        while (cancelar) {
            System.out.println("""
                    \n¿Qué mascota desea adoptar?:
                    1) Gato
                    2) Perro
                    0) Cancelar
                    """);
            System.out.print("Elija una opción: ");
            OptionAdopt = InputUtil.leerInt();

            Cliente refugioObj = null;
            for (Cliente c : clientes) {
                if (c.getNombre().equalsIgnoreCase("Refugio")) {
                    refugioObj = c;
                    break;
                }
            }

            List<Mascota> disponibles = MapPet.get(refugioObj);

            switch (OptionAdopt) {
                case 1:
                    List<Gato> gatosDisponibles = new ArrayList<>();
                    System.out.println("\nLos gatos disponibles para adoptar son: ");
                    for (Mascota m : disponibles) {
                        if (m instanceof Gato) {
                            gatosDisponibles.add((Gato) m);
                            System.out.println(gatosDisponibles.size() - 1 + ") " + m.getNombre() + " (" + ((Adoptable) m).datosAdopcion() + ") Edad: " + m.getEdad());
                        }
                    }

                    if (gatosDisponibles.isEmpty()) {
                        System.out.println("No hay ningún gato disponible en el refugio.");
                        break;
                    }

                    System.out.print("Selecciona el índice del gato a adoptar: ");
                    int indexGato = InputUtil.leerInt();
                    if (indexGato < 0 || indexGato >= gatosDisponibles.size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }
                    Gato gatoSeleccionado = gatosDisponibles.get(indexGato);

                    Cliente adoptanteGato = seleccionarClienteAdoptante();
                    if (adoptanteGato == null){
                        break;
                    }

                    MapPet.get(refugioObj).remove(gatoSeleccionado);
                    MapPet.get(adoptanteGato).add(gatoSeleccionado);

                    System.out.println("\n¡Felicidades! " + gatoSeleccionado.getNombre() + " ahora es responsabilidad de " + adoptanteGato.getNombre());
                    cancelar = false;
                    break;

                case 2:
                    List<Perro> perrosDisponibles = new ArrayList<>();
                    System.out.println("\nLos perros disponibles para adoptar son: ");
                    for (Mascota m : disponibles) {
                        if (m instanceof Perro) {
                            perrosDisponibles.add((Perro) m);
                            System.out.println(perrosDisponibles.size() - 1 + ") " + m.getNombre() + " (" + ((Adoptable) m).datosAdopcion() + ") Edad: " + m.getEdad());
                        }
                    }

                    if (perrosDisponibles.isEmpty()) {
                        System.out.println("No hay ningún perro disponible en el refugio.");
                        break;
                    }

                    System.out.print("Selecciona el índice del perro a adoptar: ");
                    int indexPerro = InputUtil.leerInt();
                    if (indexPerro < 0 || indexPerro >= perrosDisponibles.size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }
                    Perro perroSeleccionado = perrosDisponibles.get(indexPerro);

                    Cliente adoptantePerro = seleccionarClienteAdoptante();
                    if (adoptantePerro == null) break;

                    MapPet.get(refugioObj).remove(perroSeleccionado);
                    MapPet.get(adoptantePerro).add(perroSeleccionado);

                    System.out.println("\n¡Felicidades! " + perroSeleccionado.getNombre() + " ahora es responsabilidad de " + adoptantePerro.getNombre());
                    cancelar = false;
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Ingresa una opción válida");
                    break;
            }
        }
    }

    private Cliente seleccionarClienteAdoptante() {
        System.out.println("\nSelecciona el índice del cliente que adopta:");
        for (int i = 0; i < clientes.size(); i++) {
            // Impedimos que el propio "Refugio" aparezca como adoptante de sí mismo
            if (!clientes.get(i).getNombre().equalsIgnoreCase("Refugio")) {
                System.out.println(i + ") " + clientes.get(i).getNombre());
            }
        }
        System.out.print("Ingrese el índice del adoptante: ");
        int clientIndex = InputUtil.leerInt();

        if (clientIndex < 0 || clientIndex >= clientes.size() || clientes.get(clientIndex).getNombre().equalsIgnoreCase("Refugio")) {
            System.out.println("Selección de cliente inválida.");
            return null;
        }
        return clientes.get(clientIndex);
    }

    public void iniciar() {
        Cliente Refugio = new Cliente("Refugio");
        clientes.add(Refugio);
        MapPet.put(Refugio, new ArrayList<>());

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== REFUGIO ANIMAL ===");
            System.out.println("1) Crear cliente");
            System.out.println("2) Registrar mascota");
            System.out.println("3) Ver clientes y mascotas");
            System.out.println("4) Mostrar mascotas disponibles para adoptar");
            System.out.println("5) Adoptar");
            System.out.println("0) Salir");
            System.out.print("Ingresa una opcion: ");

            int op = InputUtil.leerInt();

            switch (op) {
                case 1 -> crearCliente();
                case 2 -> registrarMascota();
                case 3 -> mostrarDatos();
                case 4 -> MascotasAdoptables();
                case 5 -> Adoptar();
                case 0 -> salir = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }
}
import java.sql.SQLOutput;
import java.util.*;

public class Colecciones {
    public static void main(String[] args){
        // Scanner
        Scanner input = new Scanner(System.in);

        // Ejercicio 1: ArrayList
        System.out.println("Ejercicio 1: ArrayLists");
        List<String> products = new ArrayList<>();

        System.out.print("Ingrese cuantos productos necesita ingresar: ");
        int QtyProduct = input.nextInt();
        if(QtyProduct == 0) {
            System.out.println("Ingrese una cantidad valida, intentelo de nuevo");
        } else if(QtyProduct >= 1) {
            for(int count = 1 ; count <= QtyProduct ; count++){
                if (count == QtyProduct) {
                    System.out.print("Ingrese el producto N°" + count + ": ");
                    products.add(input.next());
                    System.out.println();
                    System.out.println("Se han registrado con exito " + products.size() + " productos");
                } else {
                    System.out.print("Ingrese el producto N°"+count+": ");
                    products.add(input.next());
                }
            }
        }

        System.out.println();
        System.out.println("Opcion 1:");
        System.out.println("Productos agregados: ");
        products.forEach(System.out::println);

        System.out.println();
        System.out.println("Opcion 2:");
        System.out.println("Productos agregados: ");
        for(String product : products){
            System.out.println(product);
        }

        System.out.println();
        System.out.println("Ejercicio 2: Set");

        Set<String> usernames = new HashSet<>();

        System.out.print("Ingrese cuantos usuarios necesita ingresar: ");
        int QtyUsers = input.nextInt();
        String CreateUser;
        boolean CheckUser;

        if(QtyUsers == 0) {
            System.out.println("Ingrese una cantidad valida, intentelo de nuevo");
        } else if(QtyUsers >= 1) {
            for(int count = 1 ; count <= QtyUsers ; count++){
                if(count == QtyUsers){
                    System.out.print("Ingrese el usuario N°" + count + ": ");
                    CreateUser = (input.next());
                    CheckUser = usernames.contains(CreateUser);
                    if(CheckUser){
                        System.out.println("El usuario " + CreateUser + " se encuentra repetido, omitido");
                    } else {
                        usernames.add(CreateUser);
                        System.out.println("Se han registrado con exito " + usernames.size() + " usuarios");
                    }
                } else {
                    System.out.print("Ingrese el usuario N°"+count+": ");
                    CreateUser = (input.next());
                    CheckUser = usernames.contains(CreateUser);
                    if(CheckUser){
                        System.out.println("El usuario " + CreateUser + " se encuentra repetido, omitido");
                    } else {
                        usernames.add(CreateUser);
                    }
                }
            }
        }
        System.out.println("Lista de usuarios");
        usernames.forEach(System.out::println);

        System.out.println();
        System.out.println("Ejercicio 3: Map");

        Map<String,String> Contacts = new HashMap<>();
        int LimitContact = 5;
        String ContactName;
        String ContactNumber;
        for(int count = 1 ; count <= 5 ; count++) {
            System.out.print("Ingrese el nombre del contacto: ");
            ContactName = input.next();
            System.out.print("Ingrese el numero del contacto: ");
            ContactNumber = input.next();
            Contacts.put(ContactName,ContactNumber);

        }
        System.out.println("Los usuarios registrados son los siguientes:");
        for(Map.Entry<String, String> ContactView : Contacts.entrySet()){
            System.out.println("Nombre: " + ContactView.getKey());
            System.out.println("N. de Contacto: " + ContactView.getValue());
            System.out.println();
        }

        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String FindContact = input.next();
        System.out.println(FindContact);
        System.out.println(Contacts.get(FindContact));
    }
}
package RefugioAnimal.util;

import java.util.Scanner;

public class InputUtil {
    public static Scanner input = new Scanner(System.in);

    public static String leerString(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = input.nextLine();
            if (!valor.trim().isEmpty()) {
                return valor;
            }
            System.out.println("Debes ingresar un valor, intentalo de nuevo");
        }
    }

    public static int leerInt(){
        while(true) {
            try {
                String Value = input.nextLine();
                return Integer.parseInt(Value.trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un numero valido: ");
            }
        }
    }

    public static int RevisarEdad(){
        while(true) {
            try {
                String Value = input.nextLine();
                int ProcessYear = Integer.parseInt(Value.trim());
                if (ProcessYear <= 0){
                    System.out.println("Ingresa una edad valida, si la mascota tiene menos de un año, introducir 1");
                } else {
                    return ProcessYear;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un numero valido: ");
            }
        }
    }
}
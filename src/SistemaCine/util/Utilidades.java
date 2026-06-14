package SistemaCine.util;

import java.util.Scanner;

public class Utilidades {

    public static Scanner input = new Scanner(System.in);

    public static int NewInt(){
        while(true) {
            try {
                String value = input.next();
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Valor ingresado incorrecto, intentalo de nuevo");
                System.out.println();
            }
        }
    }

    public static String NewStr(){
        String value;
        while(true) {
            value = input.next();
            if(value.isEmpty()){
                System.out.println("Por favor ingresa un valor");
                System.out.println();
            } else {
                return value;
            }

        }
    }

}

import java.util.Scanner;

public class Calculadora {
    // Scanner
    static Scanner input = new Scanner(System.in);

    // Suma
    static double CalcSum(double NumberA, double NumberB) {
        return NumberA + NumberB;
    }

    // Resta
    static double CalcSus(double NumberA, double NumberB) {
        return NumberA - NumberB;
    }

    // Division
    static double CalcDiv(double NumberA, double NumberB) {
        return NumberA / NumberB;
    }

    // Multiplicación
    static double CalcMul(double NumberA, double NumberB) {
        return NumberA * NumberB;
    }

    // Modulo
    static double CalcMod(double NumberA, double NumberB) {
        return NumberA % NumberB;
    }

    // Revision numero
    static double pedirNumero(){
        while(true){
            if(input.hasNextDouble()){
                return input.nextDouble();
            } else {
                System.out.println("Debe ingresar un número valido");
                input.next();
            }
        }
    }

    // Menu
    static void Menu() {
        double FirstNumCalc;
        double SecondNumCalc;
        int MenuSelector = 0;
        while (MenuSelector != 6){
            System.out.println("""
                    +-----------------------------------+
                    |    Bienvenido a la calculadora    |
                    | Ingresa una operacion a realizar  |
                    +-----------------------------------+
                    | 1. Suma                           |
                    | 2. Resta                          |
                    | 3. Division                       |
                    | 4. Multiplicacion                 |
                    | 5. Modulo                         |
                    | 6. Salir                          |
                    +-----------------------------------+
                    """);
            System.out.print("Ingresa una opción: ");

            if(input.hasNextInt()) {
                MenuSelector = input.nextInt();
            } else {
                System.out.println("Ingresa un numero valido");
                input.next();
                continue;
            }

            switch (MenuSelector) {
                case 1: // Suma
                    System.out.print("Ingresa el primer numero: ");
                    FirstNumCalc = pedirNumero();
                    System.out.print("Ingresa el segundo numero: ");
                    SecondNumCalc = pedirNumero();
                    System.out.println("El valor es " + CalcSum(FirstNumCalc, SecondNumCalc));
                    break;
                case 2: // Resta
                    System.out.print("Ingresa el primer numero: ");
                    FirstNumCalc = pedirNumero();
                    System.out.print("Ingresa el segundo numero: ");
                    SecondNumCalc = pedirNumero();
                    System.out.println("El valor es " + CalcSus(FirstNumCalc, SecondNumCalc));
                    break;
                case 3: // Division
                    System.out.print("Ingresa el numerador: ");
                    FirstNumCalc = pedirNumero();
                    System.out.print("Ingresa el denominador: ");
                    SecondNumCalc = pedirNumero();
                    if (FirstNumCalc == 0 && SecondNumCalc == 0) {
                        System.out.println("No puedes dividir 0 / 0");
                        break;
                    } else if (SecondNumCalc == 0) {
                        System.out.println("El denominador no puede ser 0");
                        break;
                    } else {
                        System.out.println("El valor es " + CalcDiv(FirstNumCalc, SecondNumCalc));
                        break;
                    }
                case 4: // Multiplicación
                    System.out.print("Ingresa el primer numero: ");
                    FirstNumCalc = pedirNumero();
                    System.out.print("Ingresa el segundo numero: ");
                    SecondNumCalc = pedirNumero();
                    System.out.println("El valor es " + CalcMul(FirstNumCalc, SecondNumCalc));
                    break;
                case 5: // Modulo
                    System.out.print("Ingresa el numerador: ");
                    FirstNumCalc = pedirNumero();
                    System.out.print("Ingresa el denominador: ");
                    SecondNumCalc = pedirNumero();
                    if (FirstNumCalc == 0 && SecondNumCalc == 0) {
                        System.out.println("No puedes dividir 0 / 0");
                        break;
                    } else if (SecondNumCalc == 0) {
                        System.out.println("El denominador no puede ser 0");
                        break;
                    } else {
                        System.out.println("El valor es " + CalcMod(FirstNumCalc, SecondNumCalc));
                        break;
                    }
                case 6: // Salida
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Ingrese una selección valida");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}


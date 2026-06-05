import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ejercicio 1: Calculadora de Edad");
        System.out.println();
        System.out.print("Indica tu nombre: ");
        String name = input.nextLine();
        System.out.print("Indica tu año de nacimiento: ");
        int birthday_year = input.nextInt();
        System.out.println("Hola " + name + ", tienes aproximadamente " + (2026-birthday_year));
        System.out.println();

        System.out.println("Ejercicio 2: Conversor de Temperatura");
        System.out.println();
        System.out.print("Ingresa la temperatura en C°: ");
        double Celsius = input.nextInt();
        double CtoF = ((Celsius * 9/5)+32);
        System.out.printf("La temperatura convertida en F° es de %.2f",CtoF);
        System.out.println();

        System.out.println("Ejercicio 3: Área y Perímetro de un Rectángulo");
        System.out.println();
        System.out.println("""
                           +---------------+ ^
                           |               | | Altura
                           +---------------+ v
                           <-----base------>
                           """);
        System.out.println();
        System.out.print("Ingresa la longitud de la base: ");
        double base = input.nextDouble();
        System.out.print("Ingresa la longitud de la altura: ");
        double height = input.nextDouble();
        final double PERIMETER = 2*(base+height);
        final double AREA = base*height;
        System.out.printf("""
                            El valor del area es de %.1f,
                            El valor del perimetro es de %.1f
                            """,PERIMETER,AREA);
        System.out.println();

        System.out.println("4. Calculadora de Descuento");
        System.out.println();
        System.out.print("Ingrese el valor del producto: ");
        double ProductValue = input.nextInt();
        System.out.print("Ingrese porcentaje de descuento (Solo numero): ");
        double DiscountValue = input.nextInt();
        double NewProductValue = ProductValue * (1  - (DiscountValue/100));
        System.out.printf("""
                Aplicando el descuento de %.0f,
                El valor final del producto con descuento es de %.0f
                """,DiscountValue,NewProductValue);
        System.out.println();

        System.out.println("Ejercicio 5: Número Positivo o Negativo");
        System.out.println();
        System.out.print("Ingresa un numero: ");
        int NumberCheck = input.nextInt();
        if(NumberCheck == 0){
            System.out.println("El numero es 0");
        } else if (NumberCheck > 0) {
            System.out.println("El numero es positivo");
        } else {
            System.out.println("El numero es negativo");
        }
        System.out.println();

        System.out.println("Ejercicio 6: Mayor de Edad");
        System.out.println();
        System.out.print("Ingresa tu edad: ");
        int YearValue = input.nextInt();
        if(YearValue >= 18){
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
        System.out.println();

        System.out.println("Ejercicio 7: Número Par o Impar");
        System.out.println();
        System.out.print("Ingresa un numero: ");
        int EvenOrOddCheck = input.nextInt();
        if (EvenOrOddCheck % 2 == 0){
            System.out.println("El numero es Par");
        } else {
            System.out.println("El numero es impar");
        }
        System.out.println();

        System.out.println("Ejercicio 8: Comparador de Números");
        System.out.println();
        System.out.print("Ingresa el primer numero: ");
        int FirstNumber = input.nextInt();
        System.out.print("Ingresa el segundo numero: ");
        int SecondNumber = input.nextInt();
        if(FirstNumber == SecondNumber){
            System.out.println("Los números son iguales");
        } else if (FirstNumber > SecondNumber) {
            System.out.printf("El primer numero (%d) es mayor que el segundo numero (%d)",FirstNumber,SecondNumber);
        } else {
            System.out.printf("El primer numero (%d) es menor que el segundo numero (%d)",FirstNumber,SecondNumber);
        }
        System.out.println();

        System.out.println("Ejercicio 9: Calculadora Simple");
        System.out.println();
        double FirstNumCalc;
        double SecondNumCalc;
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
        int MenuSelector = input.nextInt();
        switch (MenuSelector) {
            case 1: // Suma
                System.out.print("Ingresa el primer numero: ");
                FirstNumCalc = input.nextDouble();
                System.out.print("Ingresa el segundo numero: ");
                SecondNumCalc = input.nextDouble();
                System.out.println("El valor es " + (FirstNumCalc + SecondNumCalc));
                break;
            case 2: // Resta
                System.out.print("Ingresa el primer numero: ");
                FirstNumCalc = input.nextDouble();
                System.out.print("Ingresa el segundo numero: ");
                SecondNumCalc = input.nextDouble();
                System.out.println("El valor es " + (FirstNumCalc - SecondNumCalc));
                break;
            case 3: // Division
                System.out.print("Ingresa el numerador: ");
                FirstNumCalc = input.nextDouble();
                System.out.print("Ingresa el denominador: ");
                SecondNumCalc = input.nextDouble();
                if (FirstNumCalc == 0 && SecondNumCalc == 0) {
                    System.out.println("No puedes dividir 0 / 0");
                    break;
                } else if (SecondNumCalc == 0) {
                    System.out.println("El denominador no puede ser 0");
                    break;
                } else {
                    System.out.println("El valor es " + (FirstNumCalc / SecondNumCalc));
                    break;
                }
            case 4: // Multiplicación
                System.out.print("Ingresa el primer numero: ");
                FirstNumCalc = input.nextDouble();
                System.out.print("Ingresa el segundo numero: ");
                SecondNumCalc = input.nextDouble();
                System.out.println("El valor es " + (FirstNumCalc * SecondNumCalc));
                break;
            case 5: // Modulo
                System.out.print("Ingresa el numerador: ");
                FirstNumCalc = input.nextDouble();
                System.out.print("Ingresa el denominador: ");
                SecondNumCalc = input.nextDouble();
                if (FirstNumCalc == 0 && SecondNumCalc == 0) {
                    System.out.println("No puedes dividir 0 / 0");
                    break;
                } else if (SecondNumCalc == 0) {
                    System.out.println("El denominador no puede ser 0");
                    break;
                } else {
                    System.out.println("El valor es " + (FirstNumCalc % SecondNumCalc));
                    break;
                }
            case 6: // Salida
                System.out.println("Hasta pronto!");
                break;
        }
        System.out.println();

        System.out.println("Ejercicio 10: Clasificador de Notas");
        System.out.println();
        System.out.print("Ingresa una nota: ");
        String CheckText = input.next();
        String TextFix = CheckText.replace(",",".");
        double GradeResult = Double.parseDouble(TextFix);
        if(GradeResult >= 6.0) {
            System.out.println("Excelente");
        } else if (GradeResult <= 5.9 && GradeResult >= 4.0) {
            System.out.println("Aprobado");
        } else {
            System.out.println("Reprobado");
        }
        input.nextLine(); // Clean NextLine
        System.out.println();

        System.out.println("Ejercicio 11: Contador de Letras");
        System.out.println();
        System.out.print("Ingresa una palabra: ");
        String WordLengthCheck = input.nextLine();
        System.out.println("Tu palabra " + WordLengthCheck + " tiene " + WordLengthCheck.length() + " letras");
        System.out.println();

        System.out.println("Ejercicio 12: Iniciales del Nombre");
        System.out.println();
        System.out.print("Ingresa tu nombre: ");
        String FirstName = input.nextLine();
        System.out.print("Ingresa tu apellido: ");
        String LastName = input.nextLine();
        System.out.println("Tus iniciales son " + FirstName.charAt(0) + LastName.charAt(0));
        System.out.println();

        System.out.println("Ejercicio 13: Verificador de Contraseña");
        System.out.println();
        System.out.print("Ingresa una contraseña: ");
        var Password = input.nextLine();
        if(Password.equals("1234567890")){
            System.out.println("Contraseña Correcta");
        } else {
            System.out.println("Contraseña Incorrecta");
        }
        System.out.println();

        System.out.println("Ejercicio 14: Convertidor de Texto");
        System.out.println();
        System.out.print("Ingresa una palabra: ");
        String WordChangeCase = input.nextLine();
        System.out.println(WordChangeCase.toUpperCase());
        System.out.println(WordChangeCase.toLowerCase());
        System.out.println();

        System.out.println("Ejercicio 15: Contador del 1 al 10");
        System.out.println();
        for(int Count = 0 ; Count <= 10 ; Count++){
            System.out.println(Count);
        }
        System.out.println();

        System.out.print("Ejercicio 16: Tabla de Multiplicar");
        System.out.println();
        System.out.print("Ingresa un numero para mostrar tabla de multiplicar: ");
        int ValueToMultiTable = input.nextInt();
        for(int Count = 0 ; Count <= 10 ; Count++){
            System.out.println(ValueToMultiTable + " x " + Count + " = " + (Count * ValueToMultiTable));
        }
        System.out.println();

        System.out.println("Ejercicio 17: Suma de Números");
        System.out.println();
        System.out.print("Ingresa el numero de comienzo: ");
        int StartNumber = input.nextInt();
        System.out.print("Ingresa el numero destino: ");
        int EndNumber = input.nextInt();
        int TotalSum = 0;
        for (int Count = StartNumber ; Count <= EndNumber ; Count++){
            System.out.println(TotalSum);
            TotalSum += Count;
        }
        System.out.println();

        System.out.println("Ejercicio 18: Contador de Pares");
        System.out.println();
        for (int Count = 2 ; Count <= 100 ; Count+=2){
            System.out.println(Count);
        }
        System.out.println();

        System.out.println("Ejercicio 19: Adivina el Número");
        int SecretInt = 7;
        int SecretNumSelected = 0;
        while(SecretInt != SecretNumSelected){
            System.out.print("Adivina el numero secreto (1-10): ");
            SecretNumSelected = input.nextInt();
            if (SecretNumSelected == 7){
                System.out.println("Adivinaste el numero");
            } else {
                System.out.println("Intentalo de nuevo");
                System.out.println();
            }
        }
        System.out.println();

        System.out.println("Ejercicio 20: Menú Interactivo");
        System.out.println();
        int Option = 0;
        while(Option != 3){
            System.out.println("""
                        +-----------------------------------+
                        | Bienvenido al menu interactivo    |
                        +-----------------------------------+
                        | 1. Saludar                        |
                        | 2. Mostrar fecha ficticia         |
                        | 3. Salir                          |
                        +-----------------------------------+
                        """);
            System.out.print("Ingresa una opción: ");
            Option = input.nextInt();
            switch (Option){
                case 1:
                    System.out.println("Hola! Bienvenido al menu interactivo, espero que la estés pasando bien");
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("La fecha de hoy es 02-06-2026");
                    break;
                case 3:
                    System.out.println("Adios! Que tengas una buena jornada");
                    break;
            }
        }
    }
}
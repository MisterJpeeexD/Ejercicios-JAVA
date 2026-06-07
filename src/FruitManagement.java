import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FruitManagement {
    // Scanner
    static Scanner input = new Scanner(System.in);

    // Lista
    static List<String> Fruits = new ArrayList<>();

    // Variables
    static int SelectOptionMenu;
    static String FruitHistory;


    // Solicitar al usuario ingresar frutas
    public static void FruitAdd(){
        System.out.print("Ingrese una fruta: ");
        String fruit = input.next();
        if(Fruits.contains(fruit)){
            System.out.println("El valor ya existe en el sistema");
        } else {
            Fruits.add(fruit);
            System.out.println("Fruta " + fruit + " agregada!");
        }
    }

    // Mostrar frutas
    public static void ShowFruits() {
        for (int count = 0; count+1 <= Fruits.size(); count++) {
            System.out.println(count + ". " + Fruits.get(count));
        }
    }

    // Mostrar cantidad de frutas
    public static void ShowQtyFruits(){
        if(Fruits.size() == 1){
            System.out.println("Existe " + Fruits.size() + " agregada");
        } else {
            System.out.println("Existen " + Fruits.size() + " agregadas" +
                    "");
        }
    }

    // Reemplazar fruta
    public static void ReplaceFruit() {
        System.out.println();
        for (int count = 0; count+1 <= Fruits.size(); count++) {
            System.out.println(count + ". " + Fruits.get(count));
        }
        System.out.println();
        System.out.print("Ingrese la fruta a reemplazar: ");
        String FruitSelect = input.next();
        if(!Fruits.contains(FruitSelect)){
            System.out.println("El valor no existe, omitido");
        } else {
            System.out.print("Ingrese el nombre de la fruta a ingresar: ");
            String Fruit2Replace = input.next();
            FruitHistory = FruitSelect;
            if(!Fruits.contains(Fruit2Replace)){
                System.out.println("Estas seguro/a de reemplazar " + FruitHistory + " por " + Fruit2Replace + "? (S/N)");
                String ConfirmFruitReplace = input.next().toUpperCase();
                if (ConfirmFruitReplace.equals("S")) {
                    Fruits.set(Fruits.indexOf(Fruit2Replace), Fruit2Replace);
                    System.out.println("Fruta " + FruitHistory + " reemplazada por " + Fruit2Replace + " con exito!");
                } else if (ConfirmFruitReplace.equals("N")) {
                    System.out.println("Operacion cancelada por el usuario");
                } else {
                    System.out.println("Confirmacion incorrecta, omitiendo operacion");
                }
            } else {
                System.out.println("El valor existe en la lista");
            }
        }
    }

    // Quitar una fruta
    public static void DeleteFruit() {
        System.out.println();
        for (int count = 0; count+1 <= Fruits.size(); count++) {
            System.out.println(count + ". " + Fruits.get(count));
        }
        System.out.println();
        System.out.print("Ingrese la fruta a eliminar: ");
        String FruitSelect = input.next();
        if(Fruits.contains(FruitSelect)){
            FruitHistory = FruitSelect;
            System.out.println("Estas seguro/a de borrar la fruta " + FruitHistory + "? (S/N)");
            String ConfirmFruitReplace = input.next().toUpperCase();
            if (ConfirmFruitReplace.equals("S")) {
                Fruits.remove(FruitSelect);
                System.out.println("Fruta " + FruitHistory + " eliminada con exito!");
            } else if (ConfirmFruitReplace.equals("N")) {
                System.out.println("Operacion cancelada por el usuario");
            } else {
                System.out.println("Confirmacion incorrecta, omitiendo operacion");
            }
        } else {
            System.out.println("Fruta ingresada no existe, omitiendo");
        }

    }

    // Mostrar resultado final
    public static void ExitingMenu() {
        System.out.println("Saliendo del programa...");
        System.out.println();
        System.out.println("Resultado final de la lista");
        for (int count = 0; count+1 <= Fruits.size(); count++) {
            System.out.println(count + ". " + Fruits.get(count));
        }
    }

    public static void main(String[] args){
// Crear un programa en Java que permita administrar una lista de frutas utilizando funciones para organizar el codigo
        String OptionMenu = "Continue";
        while(!OptionMenu.equals("Exit")){
            System.out.println("""
                    +---------------------------------------+
                    | Bienvenido al menu de administracion  |
                    |              de frutas                |
                    +---------------------------------------+
                    | 1. Agregar fruta                      |
                    | 2. Mostrar frutas                     |
                    | 3. Mostrar cantidad de frutas         |
                    | 4. Reemplazar una fruta               |
                    | 5. Quitar una fruta                   |
                    | 6. Salir                              |
                    +---------------------------------------+
                    """);
            System.out.print("Ingrese una opcion: ");
            SelectOptionMenu = input.nextInt();
            switch (SelectOptionMenu) {
                case 1:
                    FruitAdd();
                    System.out.println();
                    break;
                case 2:
                    ShowFruits();
                    System.out.println();
                    break;
                case 3:
                    ShowQtyFruits();
                    System.out.println();
                    break;
                case 4:
                    ReplaceFruit();
                    System.out.println();
                    break;
                case 5:
                    DeleteFruit();
                    System.out.println();
                    break;
                case 6:
                    ExitingMenu();
                    OptionMenu = "Exit";
                }
            }
        }
    }



package ExerciseOOP;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<VideoGame> VideoGamesList = new ArrayList<>();

    public static void main(String[] args){
        var Minecraft = new VideoGame("Minecraft","Sandbox",20000);
        var FIFA = new VideoGame("FIFA","Sports",35000);

        System.out.printf("""
                Juego: %s
                Genero: %s
                Precio: %d \n""",Minecraft.getName(),Minecraft.getGenre(),Minecraft.getPrice());
        System.out.println();


        System.out.printf("""
                Juego: %s
                Genero: %s
                Precio: %d \n""",FIFA.getName(),FIFA.getGenre(),FIFA.getPrice());
        System.out.println();

        // Parte 2

        Minecraft.showInfo();
        System.out.println();
        FIFA.showInfo();
        System.out.println();

        // Parte 3

        Minecraft.setPrice("15000");
        System.out.println();
        Minecraft.showInfo();
        System.out.println();

        Minecraft.setPrice("v");
        System.out.println();
        Minecraft.showInfo();

        // Parte 4

        var MinecraftPC = new PCGame("MinecraftPC","Sandbox",20000,3.2,4,2,4.0,"HDD");
        var MinecraftPS = new ConsoleGame("MinecraftPS","Sandbox",30000,"PlayStation",4.0,"HDD");
        var MinecraftXbox = new ConsoleGame("Minecraft Xbox","Sandbox",25000,"X Box",4.0,"HDD");

        System.out.println();
        MinecraftPC.showInfo();
        System.out.println();
        MinecraftPS.showInfo();
        System.out.println();
        MinecraftXbox.showInfo();

        // Parte 5
        var EnlistedPC = new PCGame("Enlisted PC","Action",3000,1.5,4,2,16.0,"HDD");
        var RemnantPC = new PCGame("Remnant PC","Action",15000,2.5,8,4,50.0,"HDD");
        var FH5PC = new PCGame("Forza Horizon 5 PC","Race",50000,3.2,16,8,120.0,"SSD");


        VideoGamesList.add(MinecraftPC);
        VideoGamesList.add(EnlistedPC);
        VideoGamesList.add(RemnantPC);
        VideoGamesList.add(FH5PC);

        VideoGamesList.forEach(VideoGame::showInfo);

        // Parte 6
        var EnlistedPS = new ConsoleGame("Enlisted PS","Action",6000,"PlayStation",16.0,"HDD");
        var RemnantPS = new ConsoleGame("Remnant PS","Action",30000,"PlayStation",50.0,"HDD");
        var FH5PS = new ConsoleGame("Forza Horizon 5 PS","Race",60000,"PlayStation",120.0,"SSD");
        var EnlistedXbox = new ConsoleGame("Enlisted Xbox","Action",5000,"X box",16.0,"HDD");
        var RemnantXbox = new ConsoleGame("Remnant Xbox","Action",19000,"X box",50.0,"HDD");
        var FH5Xbox = new ConsoleGame("Forza Horizon 5 Xbox","Race",60000,"X box",120.0,"SSD");

        VideoGamesList.add(EnlistedPS);
        VideoGamesList.add(RemnantPS);
        VideoGamesList.add(FH5PS);
        VideoGamesList.add(EnlistedXbox);
        VideoGamesList.add(RemnantXbox);
        VideoGamesList.add(FH5Xbox);

        System.out.println("--- Descuentos ---");
        System.out.println();

        VideoGamesList.forEach(game -> {
            System.out.println("Nombre del juego: " + game.getName());
            System.out.println("Precio original: $" + game.getPrice());
            System.out.println("Precio con descuento: $" + game.calculateFinalPrice());
            System.out.println();
        });
    }
}

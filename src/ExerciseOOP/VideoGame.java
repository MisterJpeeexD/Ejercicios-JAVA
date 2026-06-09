package ExerciseOOP;

import ExerciseOOP.PCGame;

public class VideoGame{

    // Variables

    private String name;
    private String genre;
    private int price;

    public VideoGame(String name, String genre, Integer price){
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public void showInfo() {
        System.out.printf("""
                Juego: %s
                Genero: %s
                Precio: %d \n""",this.name,this.genre,this.price);
    }

    public double calculateFinalPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(String price) {
        try {
            int NewPrice = Integer.parseInt(price);
            if(NewPrice <= 0){
                System.out.println("No puedes dejar el juego menor a $0");
            } else {
                int OldPrice = this.price;
                this.price = NewPrice;
                System.out.println("El precio de " + this.getName() + " a cambiado de $" + OldPrice + " a $" + this.getPrice() + " correctamente" );
            }
        } catch (NumberFormatException e) {
            System.out.println("El valor ingresado no es valido");
        }
    }
}

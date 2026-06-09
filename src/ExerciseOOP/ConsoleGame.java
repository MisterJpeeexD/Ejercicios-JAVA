package ExerciseOOP;

public class ConsoleGame extends ExerciseOOP.VideoGame {
    String ConsoleModel;
    double Storage_size;
    String Storage_type;

    public ConsoleGame(String name, String genre, Integer price, String ConsoleModel, Double Storage_size, String Storage_type){
        super(name,genre,price);
        this.ConsoleModel = ConsoleModel;
        this.Storage_size = Storage_size;
        this.Storage_type = Storage_type;
    }

    @Override
    public void showInfo() {
        System.out.printf("""
                Juego: %s
                Genero: %s
                Precio: $%d
                Consola: %s
                Espacio disco: %.2f GB
                Tipo de disco: %s
                \n""",super.getName(),super.getGenre(),super.getPrice(),this.ConsoleModel,this.Storage_size,this.Storage_type);
    }

    @Override
    public double calculateFinalPrice() {
        return super.getPrice() * 0.85;
    }
}

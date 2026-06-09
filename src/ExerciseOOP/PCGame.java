package ExerciseOOP;

public class PCGame extends ExerciseOOP.VideoGame {
    double CPU;
    int RAM;
    int VRAM_card;
    double Storage_size;
    String Storage_type;

    public PCGame(String name, String genre, Integer price, Double CPU, Integer RAM, Integer VRAM_card, Double Storage_size, String Storage_type){
        super(name,genre,price);
        this.CPU = CPU;
        this.RAM = RAM;
        this.VRAM_card = VRAM_card;
        this.Storage_size = Storage_size;
        this.Storage_type = Storage_type;
    }

    @Override
    public void showInfo() {
        System.out.printf("""
                Juego: %s
                Genero: %s
                Precio: $%d
                CPU: %.2f GHz
                RAM: %d GB
                VRAM: %d GB
                Espacio disco: %.2f GB
                Tipo de disco: %s
                \n""",super.getName(),super.getGenre(),super.getPrice(),this.CPU,this.RAM,this.VRAM_card,this.Storage_size,this.Storage_type);
    }

    @Override
    public double calculateFinalPrice() {
        return super.getPrice() * 0.9;
    }
}

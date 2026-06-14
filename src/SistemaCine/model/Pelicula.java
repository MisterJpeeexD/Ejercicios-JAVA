package SistemaCine.model;

public class Pelicula {
    protected String title;
    protected int duration;

    public Pelicula(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public void showMovie(){
        System.out.println("La pelicula " + title + " dura " + duration + " minutos.");
    }
}

package SistemaCine.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private List<Entrada> misEntradas;

    public Cliente(String name) {
        super(name);
        this.misEntradas = new ArrayList<>();
    }

    public List<Entrada> getMisEntradas() {
        return misEntradas;
    }

    public void agregarEntrada(Entrada entrada) {
        this.misEntradas.add(entrada);
    }
}
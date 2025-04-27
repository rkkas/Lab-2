import java.util.*;

public class Votante {

    private int id;
    private String nombre;
    private boolean yaVoto;

    public Votante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.yaVoto = false;
    }

    public void marcarComoVotado() {
        this.yaVoto = true;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isYaVoto() {
        return yaVoto;
    }
}

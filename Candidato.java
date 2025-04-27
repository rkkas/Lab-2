import java.util.*;

public class Candidato {

    private int id;
    private String nombre;
    private String partido;
    private Queue<Voto> votosRecibidos;

    public Candidato(int id, String nombre, String partido) {
        this.id = id;
        this.nombre = nombre;
        this.partido = partido;
        this.votosRecibidos = new LinkedList<>();
    }

    public void agregarVoto(Voto v) {
        votosRecibidos.add(v);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPartido() {
        return partido;
    }

    public Queue<Voto> getVotosRecibidos() {
        return votosRecibidos;
    }
}

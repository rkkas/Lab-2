import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UrnaElectoral {

    private LinkedList<Candidato> listaCandidatos;
    private Stack<Voto> historialVotos;
    private Queue<Voto> votosReportados;
    private int idCounter;

    public UrnaElectoral() {
        this.listaCandidatos = new LinkedList<>();
        this.historialVotos = new Stack<>();
        this.votosReportados = new LinkedList<>();
        this.idCounter = 0;
    }

    public boolean verificarVotante(Votante votante) {
        return !votante.isYaVoto();
    }

    public boolean registrarVoto(Votante votante, int candidatoID) {
        if (!verificarVotante(votante)) {
            return false;
        }

        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        Voto nuevoVoto = new Voto(idCounter++, votante.getId(), candidatoID, timeStamp);

        for (Candidato candidato : listaCandidatos) {
            if (candidato.getId() == candidatoID) {
                candidato.agregarVoto(nuevoVoto);
                break;
            }
        }

        historialVotos.push(nuevoVoto);
        votante.marcarComoVotado();
        return true;
    }

    public boolean reportarVoto(Candidato candidato, int idVoto) {
        Iterator<Voto> it = candidato.getVotosRecibidos().iterator();
        while (it.hasNext()) {
            Voto voto = it.next();
            if (voto.getId() == idVoto) {
                votosReportados.add(voto);
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Map<String, Integer> obtenerResultados() {
        Map<String, Integer> resultados = new HashMap<>();
        for (Candidato candidato : listaCandidatos) {
            resultados.put(candidato.getNombre(), candidato.getVotosRecibidos().size());
        }
        return resultados;
    }

    public LinkedList<Candidato> getListaCandidatos() { return listaCandidatos; }
    public Stack<Voto> getHistorialVotos() { return historialVotos; }
    public Queue<Voto> getVotosReportados() { return votosReportados; }
}

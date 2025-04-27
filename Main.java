import java.util.*;

public class Main {

    public static void main(String[] args) {

        UrnaElectoral urna = new UrnaElectoral();

        Candidato candidato1 = new Candidato(1001, "Felipe Lopez", "Partido A");
        Candidato candidato2 = new Candidato(1002, "Paz Toro", "Partido B");

        urna.getListaCandidatos().add(candidato1);
        urna.getListaCandidatos().add(candidato2);

        Votante votante1 = new Votante(12345, "Cristina Araya");
        Votante votante2 = new Votante(67890, "Emma Perez");
        Votante votante3 = new Votante(11223, "Juan Lopez");

        if (urna.registrarVoto(votante1, 1001)) {
            System.out.println(votante1.getNombre() + " ha votado correctamente.");
        } else {
            System.out.println(votante1.getNombre() + " ya ha votado.");
        }

        if (urna.registrarVoto(votante2, 1002)) {
            System.out.println(votante2.getNombre() + " ha votado correctamente.");
        } else {
            System.out.println(votante2.getNombre() + " ya ha votado.");
        }

        if (urna.registrarVoto(votante3, 1001)) {
            System.out.println(votante3.getNombre() + " ha votado correctamente.");
        } else {
            System.out.println(votante3.getNombre() + " ya ha votado.");
        }

        System.out.println("\nResultados de la elección:");
        mostrarResultados(urna.obtenerResultados());

        System.out.println("\nReportando voto de Cristina Araya (ID: 12345):");
        Voto votoReportado = candidato1.getVotosRecibidos().peek();
        if (urna.reportarVoto(candidato1, votoReportado.getId())) {
            System.out.println("El voto ha sido reportado.");
        } else {
            System.out.println("El voto no existe o ya ha sido reportado.");
        }

        System.out.println("\nResultados después de reportar el voto:");
        mostrarResultados(urna.obtenerResultados());
    }

    private static void mostrarResultados(Map<String, Integer> resultados) {
        for (Map.Entry<String, Integer> entry : resultados.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votos");
        }
    }
}

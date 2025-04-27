public class Voto {

    private int id;
    private int votanteId;
    private int candidatoId;
    private String timeStamp;

    public Voto(int id, int votanteId, int candidatoId, String timeStamp) {
        this.id = id;
        this.votanteId = votanteId;
        this.candidatoId = candidatoId;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public int getVotanteId() {
        return votanteId;
    }

    public int getCandidatoId() {
        return candidatoId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVotanteId(int votanteId) {
        this.votanteId = votanteId;
    }

    public void setCandidatoId(int candidatoId) {
        this.candidatoId = candidatoId;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}

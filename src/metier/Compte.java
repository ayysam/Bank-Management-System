package metier;

public class Compte {
    private Long rib;
    private int id_client;
    private double solde;
    private String type;

    public Compte(Long rib, double solde, String type, int id_client) {
        this.rib = rib;
        this.solde = solde;
        this.type = type;
        this.id_client = id_client;
    }

    public Long getRib() {
        return rib;
    }

    public void setRib(Long rib) {
        this.rib = rib;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

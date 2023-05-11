package metier;

public class Demande {

    private int id_demande,id_client;
    private String datedm,etat;

    public Demande(int id_demande, String datedm, String etat  ,int id_client) {
        this.id_demande = id_demande;
        this.id_client = id_client;
        this.datedm = datedm;
        this.etat = etat;
    }

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getDatedm() {
        return datedm;
    }

    public void setDatedm(String datedm) {
        this.datedm = datedm;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}

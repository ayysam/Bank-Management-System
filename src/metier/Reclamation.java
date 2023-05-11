package metier;

public class Reclamation {

    private int id_reclam,id_client;
     private String objet,date_rec,text;

    public Reclamation(int id_reclam, String objet, String date_rec, String text, int id_client) {
        this.id_reclam = id_reclam;
        this.objet = objet;
        this.date_rec = date_rec;
        this.text = text;
        this.id_client = id_client;
    }

    public int getId_reclam() {
        return id_reclam;
    }

    public void setId_reclam(int id_reclam) {
        this.id_reclam = id_reclam;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDate_rec() {
        return date_rec;
    }

    public void setDate_rec(String date_rec) {
        this.date_rec = date_rec;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

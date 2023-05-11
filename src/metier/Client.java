package metier;

public class Client {


        private int id_client,cin;
        private String nom, prenom,daten,sexe;

    public Client(Integer id_client, Integer cin, String nom, String prenom, String daten, String sexe) {
        this.id_client = id_client;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.daten = daten;
        this.sexe = sexe;
    }

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDaten() {
        return daten;
    }

    public void setDaten(String daten) {
        this.daten = daten;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}

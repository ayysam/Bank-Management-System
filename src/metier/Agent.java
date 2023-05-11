package metier;

public class Agent {
    private int id_agent,cin;
    private String nom,prenom,daten,date_embauche,sexe;
    private Long matricule_cnss;
    public Agent(int id_agent, String nom, String prenom, int cin, String daten, String date_embauche,Long matricule_cnss, String sexe) {
        this.id_agent=id_agent;
        this.cin = cin;
        this.matricule_cnss = matricule_cnss;
        this.nom = nom;
        this.prenom = prenom;
        this.daten = daten;
        this.date_embauche = date_embauche;
        this.sexe = sexe;
    }

    public int getId_agent() {
        return id_agent;
    }

    public void setId_agent(int id_agent) {
        this.id_agent = id_agent;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public Long getMatricule_cnss() {
        return matricule_cnss;
    }

    public void setMatricule_cnss(Long matricule_cnss) {
        this.matricule_cnss = matricule_cnss;
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

    public String getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(String date_embauche) {
        this.date_embauche = date_embauche;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}

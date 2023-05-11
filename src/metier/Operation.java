package metier;



public class Operation  {

    private int id_op;
    private long rib;
    private String typeop,date_op;
    private double montant;

    public Operation(int id_op, long rib, String typeop, double montant, String date_op) {
        this.id_op = id_op;
        this.rib = rib;
        this.typeop = typeop;
        this.montant = montant;
        this.date_op = date_op;

    }

    public int getId_op() {
        return id_op;
    }

    public void setId_op(int id_op) {
        this.id_op = id_op;
    }

    public long getRib() {
        return rib;
    }

    public void setRib(long rib) {
        this.rib = rib;
    }

    public String getTypeop() {
        return typeop;
    }

    public void setTypeop(String typeop) {
        this.typeop = typeop;
    }

    public String getDate_op() {
        return date_op;
    }

    public void setDate_op(String date_op) {
        this.date_op = date_op;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}

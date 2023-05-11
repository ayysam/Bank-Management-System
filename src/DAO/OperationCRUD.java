package DAO;


import metier.Operation;

import java.sql.*;

public class OperationCRUD implements InterfaceDAO<Operation>{

    Statement transmission;
    ResultSet leResultat;
    private Connection cnx = ConnectDB.getInstance().Connect();




    @Override
    public int add(Operation operation) {
        try {
            PreparedStatement st = cnx.prepareStatement("Insert Into operation(rib,typeop,montant,date_op) Values (?,?,?,?)");
            st.setLong(1, operation.getRib());
            st.setString(2, operation.getTypeop());
            st.setDouble(3, operation.getMontant());
            st.setString(4, operation.getDate_op());


            st.executeUpdate();
            return 1;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }


    }

    @Override
    public int delete(int id_op) {
        try {
            PreparedStatement st = cnx.prepareStatement("Delete from operation Where id_op = ?");
            st.setLong(1, id_op);
            st.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }
    @Override
    public int modify(Operation operation) {
        try
        {
            PreparedStatement st = cnx.prepareStatement("Update operation Set rib=?,typeop=?,montant=?,date_op=? Where id_op=?");
            st.setLong(1, operation.getRib());
            st.setString(2, operation.getTypeop());
            st.setDouble(3, operation.getMontant());
            st.setString(4, operation.getDate_op());
            st.setInt(5, operation.getId_op());


            st.executeUpdate();
            return 1;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public  void  select()  {
        String query = "select * from operation";
        try (Statement stmt = cnx.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_op = rs.getInt("id_op");
                long rib = rs.getLong("rib");
                double montant = rs.getDouble("montant");
                String typeop = rs.getString("typeop");
                String date_op = rs.getString("date_op");


                System.out.println(id_op+", "+rib + ", " + montant + ", " + typeop+", "+ date_op );
            }
        } catch (SQLException e) {

        }

    }


}

package DAO;


import metier.Reclamation;

import java.sql.*;

public class ReclamationCRUD implements InterfaceDAO<Reclamation>{

    Statement transmission;
    ResultSet leResultat;
    private Connection cnx = ConnectDB.getInstance().Connect();




    @Override
    public int add(Reclamation reclamation) {
        try {
            PreparedStatement st = cnx.prepareStatement("Insert Into reclamation(objet,date_rec,text,id_client) Values (?,?,?,?)");
            st.setString(1, reclamation.getObjet());
            st.setString(2, reclamation.getDate_rec());
            st.setString(3, reclamation.getText());
            st.setInt(4, reclamation.getId_client());



            st.executeUpdate();
            return 1;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }


    }

    @Override
    public int delete(int id_reclam) {
        try {
            PreparedStatement st = cnx.prepareStatement("Delete from reclamation Where id_reclam = ?");
            st.setInt(1, id_reclam);
            st.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    @Override
    public int modify(Reclamation reclamation) {
        try
        {
            PreparedStatement st = cnx.prepareStatement("Update reclamation Set objet=?,date_rec=?,text=?,id_client=? Where id_reclam=?");
            st.setString(1, reclamation.getObjet());
            st.setString(2, reclamation.getDate_rec());
            st.setString(3, reclamation.getText());
            st.setInt(4, reclamation.getId_client());
            st.setInt(5, reclamation.getId_reclam());


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
        String query = "select * from reclamation";
        try (Statement stmt = cnx.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                int id_reclam = rs.getInt("id_reclam");
                String objet = rs.getString("objet");
                String date_rec = rs.getString("date_rec");
                String text = rs.getString("text");
                int id_client = rs.getInt("id_client");

                System.out.println(id_reclam + ", " + objet + ", " + date_rec+ ", " + text+ ", " + id_client );
            }
        } catch (SQLException e) {

        }

    }


}

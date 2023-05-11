package DAO;

import metier.Client;


import java.sql.*;


public class ClientCRUD implements InterfaceDAO<Client> {


    Statement transmission;
    ResultSet leResultat;
    private Connection cnx = ConnectDB.getInstance().Connect();




    @Override
    public int add(Client client) {
        try {
            PreparedStatement st = cnx.prepareStatement("Insert Into client(nom,prenom,cin,daten,sexe) Values (?,?,?,?,?)");
            st.setString(1, client.getNom());
            st.setString(2, client.getPrenom());
            st.setInt(3, client.getCin());
            st.setString(4, client.getDaten());
            st.setString(5, client.getSexe());


            st.executeUpdate();
            return 1;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }


    }

    @Override
    public int delete(int id) {
        try {
            PreparedStatement st = cnx.prepareStatement("Delete from client Where id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    @Override
    public int modify(Client client) {
        try
        {
            PreparedStatement st = cnx.prepareStatement("Update client Set nom=?, prenom=? Where id=?");
            st.setString(1, client.getNom());
            st.setString(2, client.getPrenom());
            st.setInt(3, client.getId_client());


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
        String query = "select * from client";
        try (Statement stmt = cnx.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");

                System.out.println(id + ", " + nom + ", " + prenom );
            }
        } catch (SQLException e) {

        }

    }




}
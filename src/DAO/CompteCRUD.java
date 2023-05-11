package DAO;


import metier.Compte;
import net.proteanit.sql.DbUtils;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CompteCRUD  {


    Statement transmission;
    ResultSet rs;
    private Connection cnx = ConnectDB.getInstance().Connect();





    public int add(Compte compte) {
        try {
            PreparedStatement st = cnx.prepareStatement("Insert Into compte(rib,solde,type,id_client) Values (?,?,?,?)");
            st.setLong(1, compte.getRib());
            st.setDouble(2, compte.getSolde());
            st.setString(3, compte.getType());
            st.setInt(4, compte.getId_client());


            st.executeUpdate();
            return 1;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }


    }


    public int delete(Long rib) {
        try {
            PreparedStatement st = cnx.prepareStatement("Delete from compte Where rib = ?");
            st.setLong(1, rib);
            st.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public int modify(Compte compte) {
        try
        {
            PreparedStatement st = cnx.prepareStatement("Update compte Set solde=?,type=?,id_client=? Where rib=?");
            st.setDouble(1, compte.getSolde());
            st.setString(2, compte.getType());
            st.setInt(3, compte.getId_client());
            st.setLong(4, compte.getRib());


            st.executeUpdate();
            return 1;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public  void  select(JTable table) {
		 try {
          

             PreparedStatement st = (PreparedStatement) cnx.prepareStatement("Select * from compte");

              rs = st.executeQuery();
              table.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception ee) {
				JOptionPane.showConfirmDialog(null,"erreur de système","Erreur",JOptionPane.PLAIN_MESSAGE);	
			}
	}
	
    public Compte selectCompte(long rib) {
        Compte c1=new Compte(null,0,null,0);
        try {
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement("Select * from compte where rib=? ");
            st.setLong(1, rib);

            rs = st.executeQuery();

            if (rs.next()) {
                  c1.setRib(rs.getLong("rib"));
                c1.setSolde(rs.getDouble("solde"));
                c1.setType(rs.getString("type"));
                c1.setId_client(rs.getInt("id_client"));
                return c1;

            } else {
                System.out.println("no rib exists");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());


        }
        return c1;
    }
    public void rechercheCompte(Long a, JTable table) {
		 try {  
		PreparedStatement st = (PreparedStatement) cnx.prepareStatement("Select * from compte where rib=? or id_client=? ");
			
			st.setLong(1, a);
	        st.setLong(2, a);
          rs = st.executeQuery();
          table.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception ee) {
				JOptionPane.showConfirmDialog(null,"erreur de système","Erreur",JOptionPane.PLAIN_MESSAGE);	
			}
		
	}







}

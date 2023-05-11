package DAO;


import metier.Demande;
import net.proteanit.sql.DbUtils;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class DemandeCRUD implements InterfaceDAO<Demande>{

    Statement transmission;
    ResultSet rs;
    private Connection cnx = ConnectDB.getInstance().Connect();




    @Override
    public int add(Demande demande) {
        try {
            PreparedStatement st = cnx.prepareStatement("Insert Into demande(datedm,etat,id_client) Values (?,?,?)");

            st.setString(1, demande.getDatedm());
            st.setString(2, demande.getEtat());
            st.setInt(3, demande.getId_client());

            st.executeUpdate();

            return 1;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }


    }

    @Override
    public int delete(int id_demande) {
        try {
            PreparedStatement st = cnx.prepareStatement("Delete from demande Where id_demande = ?");
            st.setInt(1, id_demande);
            st.executeUpdate();
            return 1;
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return 0;
        }

    }

    @Override
    public int modify(Demande demande) {
        try
        {
            PreparedStatement st = cnx.prepareStatement("Update demande Set datedm=?,etat=?,id_client=? Where id_demande=?");

            st.setString(1, demande.getDatedm());
            st.setString(2, demande.getEtat());
            st.setInt(3, demande.getId_client());
            st.setInt(4, demande.getId_demande());


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
        
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement("Select * from demande");
             rs = st.executeQuery();
             table.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception ee) {
				JOptionPane.showConfirmDialog(null,"erreur de système","Erreur",JOptionPane.PLAIN_MESSAGE);	
			}
	}
    
    public void rechercheDemande(int a, JTable table) {
		 try {  
		PreparedStatement st = (PreparedStatement) cnx.prepareStatement("Select * from demande where id_demande=?");
		st.setInt(1, a);
         rs = st.executeQuery();
         table.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception ee) {
				JOptionPane.showConfirmDialog(null,"erreur de système","Erreur",JOptionPane.PLAIN_MESSAGE);	
			}
		
	}
    
    public Demande selectDemande(int id) {
        Demande d = new Demande(0,null,null,0);
        try {
            PreparedStatement st = (PreparedStatement) cnx.prepareStatement("Select * from demande where id_demande=? ");
            st.setLong(1, id);

            rs = st.executeQuery();

            if (rs.next()) {
                d.setId_demande(rs.getInt("id_demande"));
                d.setId_client(rs.getInt("id_client"));
                d.setDatedm(rs.getString("datedm"));
                d.setEtat(rs.getString("etat"));
                return d;

            } else {
				JOptionPane.showConfirmDialog(null,"Pas de demande","Erreur",JOptionPane.PLAIN_MESSAGE);	
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return d;
    }


}

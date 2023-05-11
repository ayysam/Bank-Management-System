package DAO;

import metier.Agent;


import java.sql.*;

public class AgentCRUD implements InterfaceDAO<Agent> {


    Statement transmission;
    ResultSet leResultat;
    private Connection cnx = ConnectDB.getInstance().Connect();



    @Override
    public int add(Agent agent) {
        try {
            PreparedStatement st = cnx.prepareStatement("Insert Into agent(nom,prenom,cin,daten,date_embauche,matricule_cnss,sexe) Values (?,?,?,?,?,?,?)");
            st.setString(1, agent.getNom());
            st.setString(2, agent.getPrenom());
            st.setInt(3, agent.getCin());
            st.setString(4, agent.getDaten());
            st.setString(5, agent.getDate_embauche());
            st.setLong(6, agent.getMatricule_cnss());
            st.setString(7, agent.getSexe());


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
            PreparedStatement st = cnx.prepareStatement("Delete from agent Where id_agent = ?");
            st.setInt(1, id);
            st.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    @Override
    public int modify(Agent agent) {
        try
        {
            PreparedStatement st = cnx.prepareStatement("Update agent Set nom=?,prenom=?,cin=?,daten=?,date_embauche=?,matricule_cnss=?,sexe=? Where id_agent=?");
            st.setString(1, agent.getNom());
            st.setString(2, agent.getPrenom());
            st.setInt(3, agent.getCin());
            st.setString(4, agent.getDaten());
            st.setString(5, agent.getDate_embauche());
            st.setLong(6, agent.getMatricule_cnss());
            st.setString(7, agent.getSexe());
            st.setInt(8, agent.getId_agent());


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
        String query = "select * from agent";
        try (Statement stmt = cnx.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

                int id_agent = rs.getInt("id_agent");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                int cin=rs.getInt("cin");
                String daten = rs.getString("daten");
                String date_embauche = rs.getString("date_embauche");
                String matricule_cnss = rs.getString("matricule_cnss");
                String sexe = rs.getString("sexe");
                System.out.println(id_agent + ", " + nom + ", " + prenom  + ", " + cin + ", " + daten  + ", " + date_embauche + ", " + matricule_cnss  + ", " + sexe  );
            }
        } catch (SQLException e) {

        }
    }
public String Login(Long a, String b) {
		
		String verif="false";
		 try {
			PreparedStatement st = (PreparedStatement) cnx.prepareStatement("Select * from agent where cin=? and password=?");
			st.setLong(1, a);
	        st.setString(2, b);
	         leResultat = st.executeQuery();
		if(leResultat.next()) {
			String nom = leResultat.getString("prenom");
			verif=nom;
		}else {
		
			verif="false";
		}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
            
			
		}
		 return verif;
		
		 

		
        
        }

}

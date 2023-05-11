import DAO.*;
import metier.*;


import presentation.*;

public class Main {
    public static void main(String[] args) {
       /* SimpleDateFormat s=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        Date date= new Date(
                "12/8/2023 05:12:55"
        );
    CompteCRUD compteCRUD =new CompteCRUD();
    OperationCRUD operationCRUD=new OperationCRUD();
        Operation operation = new Operation(1,123987555588554458L,"versement",1200,java.time.LocalDateTime.now().toString());

        
        if(operationCRUD.add(operation) ==1) {
            Compte c1 = compteCRUD.selectCompte(operation.getRib());
            c1.setSolde(c1.getSolde()+operation.getMontant());
            compteCRUD.modify(c1);

        }else {
            System.out.println("non");
        }
        operationCRUD.select();
        compteCRUD.select();

        ReclamationCRUD reclamationCRUD =new ReclamationCRUD();
        Reclamation reclamation =new Reclamation(1,"yyyyyyy",java.time.LocalDateTime.now().toString(),"xxxxxxxx",1);

        if(reclamationCRUD.delete(1) ==1) {

            System.out.println("ok");
        }else {
            System.out.println("non");
        }
        reclamationCRUD.select();
        
        */
    	
    	Login l1= new Login();
    	l1.setVisible(true);

    }
}
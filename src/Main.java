import DAO.ClientCRUD;
import metier.Client;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



        ClientCRUD clientCRUD = new ClientCRUD();
        Client c1 = new Client(3, "samaali", "ayoub");


        if(clientCRUD.add(c1)==1) {
            System.out.println("ok");

        }else {
            System.out.println("non");
        }
        clientCRUD.select();
    }
}
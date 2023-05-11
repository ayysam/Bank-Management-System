package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectDB {

        private String url="jdbc:mysql://localhost:3306/banksystem";
        private String user="root";
        private String password="";
        private static  ConnectDB  INSTANCE=null;
        private Connection cnx ;

        public static ConnectDB getInstance() {
            if(INSTANCE==null) {
                synchronized(ConnectDB.class) {
                    if(INSTANCE==null)
                        INSTANCE=new ConnectDB();
                }
            }
            return INSTANCE;
        }



        public Connection Connect() {

            try {


                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx= DriverManager.getConnection(url, user, password);
                System.out.println("connecte");



                return cnx;
            }
            catch(ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
                return null;
            }

        }



}
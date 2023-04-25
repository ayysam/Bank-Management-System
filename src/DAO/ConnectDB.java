package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectDB {

        private String url="jdbc:mysql://localhost:3306/banking";
        private String user="root";
        private String password="";
        private static  ConnectDB  INSTANCE=null;
        private Connection con ;

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
                con = DriverManager.getConnection(url, user, password);
                System.out.println("connecte");



                return con;
            }
            catch(ClassNotFoundException | SQLException e1) {
                e1.printStackTrace();
                return null;
            }

        }

        public void disconnect() {
            try {
                if(con!=null) {
                    con=null;
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }

}
import java.sql.Connection;
import java.sql.DriverManager;

class MySQLConnection{
    public static void main(String[] args){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "1234");
            System.out.println("Connection Established!");
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


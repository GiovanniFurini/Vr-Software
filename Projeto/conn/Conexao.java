package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection get() throws ClassNotFoundException, SQLException {
       Class.forName("org.postgresql.Driver");
      Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/locadora", "postgres", "1234567");
       
        return conn;
    }
}

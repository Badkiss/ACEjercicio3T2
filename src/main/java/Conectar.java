import java.sql.Connection;
import java.sql.SQLException;

public class Conectar {
    public void iniciar() {
        MiConector miConector = new MiConector();
        Connection con = miConector.getConnection();
        try {
            System.out.println("Conectado com sucesso: " + con.getCatalog());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        miConector.closeConnection();
    }
}

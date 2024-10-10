import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        MiConector miConector = new MiConector();
        Connection con = miConector.getConnection();
        for (int i = 1; i < 7; i++) {
            try (PreparedStatement prs = con.prepareStatement("select c1.name as charactername, c2.name as killername from deaths d join characters c1 on d.id_character = c1.id join characters c2 on d.id_killer = c2.id where id_film like ?")) {
                prs.setInt(1, i);
                ResultSet rs = prs.executeQuery();
                System.out.println();
                System.out.println("Episodio: "+ i);
                System.out.println();
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " muerto por " + rs.getString(2));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
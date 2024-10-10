import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio2 {
    public static void main(String[] args) {
        MiConector miConector = new MiConector();
        Connection conn = miConector.getConnection();

        try(PreparedStatement prt = conn.prepareStatement("insert into characters(id,name,planet_id) values (?,?,?),(?,?,?),(?,?,?)")){
           prt.setInt(1, 103);
           prt.setString(2, "paco1");
           prt.setInt(3, 1);
           prt.setInt(4, 104);
           prt.setString(5, "paco2");
           prt.setInt(6, 2);
           prt.setInt(7, 105);
           prt.setString(8, "paco3");
           prt.setInt(9, 3);
           prt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try (PreparedStatement prt2 = conn.prepareStatement("insert into character_films values(?,?),(?,?),(?,?)")){
            prt2.setInt(1, 103);
            prt2.setInt(2, 1);
            prt2.setInt(3, 104);
            prt2.setInt(4, 2);
            prt2.setInt(5, 105);
            prt2.setInt(6, 3);
            prt2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

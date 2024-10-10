import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        MiConector miConector = new MiConector();
        Connection conn=miConector.getConnection();
        int diametroMax;
        int diametroMin;
        for (int i = 0; i < 3; i++) {
            System.out.println("Planeta con diametro Max que: ");
                diametroMax=meterNumero();
            System.out.println("Planeta con diametro Min que: ");
                diametroMin=meterNumero();
                try(PreparedStatement preparedStatement = conn.prepareStatement("select id , name , diameter from planets where diameter > ? and diameter < ?")){
                    preparedStatement.setInt(1,diametroMin);
                    preparedStatement.setInt(2,diametroMax);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getInt("diameter"));
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }


    }
   public static int meterNumero(){
       Scanner entrada = new Scanner(System.in);
       return  entrada.nextInt();
    }
}

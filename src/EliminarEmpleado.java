import java.sql.*;
import java.util.Scanner;

public class EliminarEmpleado {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "RIBERA";
        String password = "ribera";

        Scanner sc = new Scanner(System.in);

        System.out.print("introduc el ID que quieres eliminar: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM EMPLEADO WHERE ID = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("empleado eliminado");
            } else {
                System.out.println("no existe ese empleado");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
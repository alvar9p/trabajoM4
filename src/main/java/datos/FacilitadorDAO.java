package datos;

import dominio.Facilitador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacilitadorDAO {

    private static final String SQL_SELECT = "SELECT id, rut, nombre, email, telefono, valorhora, banco, ctabancaria, last_update FROM facilitador";

    public List<Facilitador> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Facilitador facilitador = null;
        List<Facilitador> facilitadores = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String rut = rs.getString("rut");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                float valorHora = rs.getFloat("valorhora");
                String banco = rs.getString("banco");
                String ctabancaria = rs.getString("ctabancaria");
                Date lastUpdate = rs.getDate(9);

                facilitador = new Facilitador(id, rut, nombre, email, telefono, valorHora, banco, ctabancaria, lastUpdate);
                facilitadores.add(facilitador);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return facilitadores;
    }
}

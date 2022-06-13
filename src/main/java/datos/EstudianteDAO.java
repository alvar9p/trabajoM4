package datos;

import dominio.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EstudianteDAO {

    private static final String SQL_SELECT = "SELECT id, rut, nombre, email, telefono, last_update FROM estudiante";
    private static final String SQL_SELECT_BY_ID = "SELECT id, rut, nombre, email, telefono, last_update FROM estudiante WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO estudiante(rut, nombre, email, telefono, last_update) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE estudiante SET rut = ?, nombre = ?, email = ?, telefono = ?, last_update = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM estudiante WHERE id = ?";
    private static final String SQL_INNER = "SELECT * FROM estudiante INNER JOIN matricula ON estudiante.id = matricula.id_estudiante";
    
    
    public List<Estudiante> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estudiante estudiante = null;
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEst = rs.getInt("id");
                String rut = rs.getString("rut");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                Date lastUpdate = rs.getDate(6);

                estudiante = new Estudiante(idEst, rut, nombre, email, telefono, lastUpdate);
                estudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return estudiantes;
    }

    public Estudiante encontrar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, estudiante.getIdEstudiante());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String rut = rs.getString("rut");
            String nombre = rs.getString("nombre");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            Date lastUpdate = rs.getDate(6);

            estudiante.setRutEst(rut);
            estudiante.setNombreEst(nombre);
            estudiante.setEmailEst(email);
            estudiante.setTelefonoEst(telefono);
            estudiante.setLastUpdateEst(lastUpdate);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return estudiante;
    }

    public int insertar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0; // Para saber cantidad de registros modificados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, estudiante.getRutEst());
            stmt.setString(2, estudiante.getNombreEst());
            stmt.setString(3, estudiante.getEmailEst());
            stmt.setString(4, estudiante.getTelefonoEst());
            java.util.Date fechaUtil = estudiante.getLastUpdateEst();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            stmt.setDate(5, fechaSql);

            // Devuelve entero de cuantos registros se modificaron
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int actualizar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, estudiante.getRutEst());
            stmt.setString(2, estudiante.getNombreEst());
            stmt.setString(3, estudiante.getEmailEst());
            stmt.setString(4, estudiante.getTelefonoEst());
            java.util.Date fechaUtil = estudiante.getLastUpdateEst();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            stmt.setDate(5, fechaSql);
            stmt.setInt(6, estudiante.getIdEstudiante());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
        public int eliminar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, estudiante.getIdEstudiante());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    
}

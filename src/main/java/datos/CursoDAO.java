package datos;

import dominio.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CursoDAO {

    private static final String SQL_SELECT = "SELECT id, codigo, nombre, id_facilitador, last_update FROM curso";
    private static final String SQL_SELECT_BY_ID = "SELECT id, codigo, nombre, id_facilitador, last_update FROM curso WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO curso(id, codigo, nombre, id_facilitador, last_update) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE curso SET codigo = ?, nombre = ?, id_facilitador = ?, last_update = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM curso WHERE id = ?";

    public List<Curso> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = null;
        List<Curso> cursos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                int idFacilitador = rs.getInt("id_facilitador");
                Date lastUpdate = rs.getDate(5);

                curso = new Curso(id, codigo, nombre, idFacilitador, lastUpdate);
                cursos.add(curso);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cursos;
    }

    public Curso encontrar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, curso.getIdCurso());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            int id = rs.getInt("id");
            String codigo = rs.getString("codigo");
            String nombre = rs.getString("nombre");
            int idFacilitador = rs.getInt("id_facilitador");
            Date lastUpdate = rs.getDate(5);

            curso.setIdCurso(id);
            curso.setCodigoCurso(codigo);
            curso.setNombreCurso(nombre);
            curso.setIdFacilitadorFK(idFacilitador);
            curso.setLastUpdateCurso(lastUpdate);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return curso;
    }
    
    public int insertar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0; // Para saber cantidad de registros modificados
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, curso.getIdCurso());
            stmt.setString(2, curso.getCodigoCurso());
            stmt.setString(3, curso.getNombreCurso());
            stmt.setInt(4, curso.getIdFacilitadorFK());
            java.util.Date fechaUtil = curso.getLastUpdateCurso();
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
    
    public int actualizar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, curso.getIdCurso());
            stmt.setString(2, curso.getCodigoCurso());
            stmt.setString(3, curso.getNombreCurso());
            stmt.setInt(4, curso.getIdFacilitadorFK());
            java.util.Date fechaUtil = curso.getLastUpdateCurso();
            java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
            stmt.setDate(5, fechaSql);

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int eliminar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, curso.getIdCurso());

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

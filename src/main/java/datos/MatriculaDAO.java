package datos;

import dominio.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatriculaDAO {
    
    private static final String SQL_SELECT = "SELECT id_estudiante, id_curso, fecha, last_update FROM matricula";
    
    public List<Matricula> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Matricula matricula = null;
        List<Matricula> matriculas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEstudianteFK = rs.getInt("id_estudiante");
                int idCursoFK = rs.getInt("id_curso");
                Date fecha = rs.getDate(3);
                Date lastUpdateMatricula = rs.getDate(4);

                matricula = new Matricula(idEstudianteFK, idCursoFK, fecha, lastUpdateMatricula);
                matriculas.add(matricula);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return matriculas;
    }
    
}

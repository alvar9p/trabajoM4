package dominio;

import java.util.Date;

public class Matricula {

    private int idEstudianteFK; // NOT NULL PK
    private int idCursoFK; // NOT NULL PK
    private Date fecha;
    private Date lastUpdateMatricula;

    public Matricula() {
    }

    public Matricula(int idEstudianteFK) {
        this.idEstudianteFK = idEstudianteFK;
    }
    
    public Matricula(int idEstudianteFK, int idCursoFK, Date fecha, Date lastUpdateMatricula) {
        this.idEstudianteFK = idEstudianteFK;
        this.idCursoFK = idCursoFK;
        this.fecha = fecha;
        this.lastUpdateMatricula = lastUpdateMatricula;
    }
    
    public int getIdEstudianteFK() {
        return idEstudianteFK;
    }

    public void setIdEstudianteFK(int idEstudianteFK) {
        this.idEstudianteFK = idEstudianteFK;
    }

    public int getIdCursoFK() {
        return idCursoFK;
    }

    public void setIdCursoFK(int idCursoFK) {
        this.idCursoFK = idCursoFK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getLastUpdateMatricula() {
        return lastUpdateMatricula;
    }

    public void setLastUpdateMatricula(Date lastUpdateMatricula) {
        this.lastUpdateMatricula = lastUpdateMatricula;
    }
    
    @Override
    public String toString() {
        return "Matricula{" + "idEstudianteFK=" + idEstudianteFK + ", idCursoFK=" + idCursoFK + ", fecha=" + fecha + ", lastUpdateMatricula=" + lastUpdateMatricula + '}';
    }

    
}

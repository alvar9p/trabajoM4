package dominio;

import java.util.Date;

public class Curso {

    private static int idAuto;

    // Debe ser PK
    private int idCurso;
    private String codigoCurso;
    private String nombreCurso;

    // Este hace referencia al ID de Facilitador 
    // on delete restrict no deja borrar
    private int idFacilitadorFK;
    private Date lastUpdateCurso;

    public Curso() {
    }

    public Curso(String codigoCurso, String nombreCurso, int idFacilitadorFK, Date lastUpdateCurso) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.idFacilitadorFK = idFacilitadorFK;
        this.lastUpdateCurso = lastUpdateCurso;
    }

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(int idCurso, String codigoCurso, String nombreCurso, int idFacilitadorFK, Date lastUpdateCurso) {
        this.idCurso = idCurso;
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.idFacilitadorFK = idFacilitadorFK;
        this.lastUpdateCurso = lastUpdateCurso;
    }

    public static int getIdAuto() {
        return idAuto;
    }

    public static void setIdAuto(int aIdAuto) {
        idAuto = aIdAuto;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getIdFacilitadorFK() {
        return idFacilitadorFK;
    }

    public void setIdFacilitadorFK(int idFacilitadorFK) {
        this.idFacilitadorFK = idFacilitadorFK;
    }

    public Date getLastUpdateCurso() {
        return lastUpdateCurso;
    }

    public void setLastUpdateCurso(Date lastUpdateCurso) {
        this.lastUpdateCurso = lastUpdateCurso;
    }

}

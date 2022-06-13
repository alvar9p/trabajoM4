package dominio;

import java.util.Date;

public class Estudiante {
    
    // Para id autoincremental
    private static int idAuto;

    public static int getIdAuto() {
        return idAuto;
    }

    public static void setIdAuto(int aIdAuto) {
        idAuto = aIdAuto;
    }
    
    // Debe ser PK
    private int idEstudiante;
    private String rutEst;
    private String nombreEst;
    private String emailEst;
    private String telefonoEst;
    private Date lastUpdateEst;

    public Estudiante() {
    }

    // Solo ID, para buscar y borrar
    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    // ID autoincremental con el método estático
    public Estudiante(String rutEst, String nombreEst, String emailEst, String telefonoEst, Date lastUpdateEst) {
        this.idEstudiante = idAuto++;
        this.rutEst = rutEst;
        this.nombreEst = nombreEst;
        this.emailEst = emailEst;
        this.telefonoEst = telefonoEst;
        this.lastUpdateEst = lastUpdateEst;
    }

    // Todos los atributos para poder hacer un Update
    public Estudiante(int idEstudiante, String rutEst, String nombreEst, String emailEst, String telefonoEst, Date lastUpdateEst) {
        this.idEstudiante = idEstudiante;
        this.rutEst = rutEst;
        this.nombreEst = nombreEst;
        this.emailEst = emailEst;
        this.telefonoEst = telefonoEst;
        this.lastUpdateEst = lastUpdateEst;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getRutEst() {
        return rutEst;
    }

    public void setRutEst(String rutEst) {
        this.rutEst = rutEst;
    }

    public String getNombreEst() {
        return nombreEst;
    }

    public void setNombreEst(String nombreEst) {
        this.nombreEst = nombreEst;
    }

    public String getEmailEst() {
        return emailEst;
    }

    public void setEmailEst(String emailEst) {
        this.emailEst = emailEst;
    }

    public String getTelefonoEst() {
        return telefonoEst;
    }

    public void setTelefonoEst(String telefonoEst) {
        this.telefonoEst = telefonoEst;
    }

    public Date getLastUpdateEst() {
        return lastUpdateEst;
    }

    public void setLastUpdateEst(Date lastUpdateEst) {
        this.lastUpdateEst = lastUpdateEst;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "idEstudiante=" + idEstudiante + ", rutEst=" + rutEst + ", nombreEst=" + nombreEst + ", emailEst=" + emailEst + ", telefonoEst=" + telefonoEst + ", lastUpdateEst=" + lastUpdateEst + '}';
    }
    
    
    
    
}

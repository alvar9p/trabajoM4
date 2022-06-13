package dominio;

import java.util.Date;

public class Facilitador {
    
    private static int idAuto;

    public static int getIdAuto() {
        return idAuto;
    }

    public static void setIdAuto(int aIdAuto) {
        idAuto = aIdAuto;
    }
    
    // Debe ser PK
    private int idFacilitador;
    private String rutFac;
    private String nombreFac;
    private String emailFac;
    private String telefonoFac;
    private float valorHoraFac;
    private String BancoFac;
    private String ctaBcoFac;
    private Date lastUpdateFac;

    public Facilitador() {
    }

    public Facilitador(int idFacilitador) {
        this.idFacilitador = idFacilitador;
    }

    public Facilitador(int idFacilitador, String rutFac, String nombreFac, String emailFac, String telefonoFac, float valorHoraFac, String BancoFac, String ctaBcoFac, Date lastUpdateFac) {
        this.idFacilitador = idFacilitador;
        this.rutFac = rutFac;
        this.nombreFac = nombreFac;
        this.emailFac = emailFac;
        this.telefonoFac = telefonoFac;
        this.valorHoraFac = valorHoraFac;
        this.BancoFac = BancoFac;
        this.ctaBcoFac = ctaBcoFac;
        this.lastUpdateFac = lastUpdateFac;
    }

    public int getIdFacilitador() {
        return idFacilitador;
    }

    public void setIdFacilitador(int idFacilitador) {
        this.idFacilitador = idFacilitador;
    }

    public String getRutFac() {
        return rutFac;
    }

    public void setRutFac(String rutFac) {
        this.rutFac = rutFac;
    }

    public String getNombreFac() {
        return nombreFac;
    }

    public void setNombreFac(String nombreFac) {
        this.nombreFac = nombreFac;
    }

    public String getEmailFac() {
        return emailFac;
    }

    public void setEmailFac(String emailFac) {
        this.emailFac = emailFac;
    }

    public String getTelefonoFac() {
        return telefonoFac;
    }

    public void setTelefonoFac(String telefonoFac) {
        this.telefonoFac = telefonoFac;
    }

    public float getValorHoraFac() {
        return valorHoraFac;
    }

    public void setValorHoraFac(float valorHoraFac) {
        this.valorHoraFac = valorHoraFac;
    }

    public String getBancoFac() {
        return BancoFac;
    }

    public void setBancoFac(String BancoFac) {
        this.BancoFac = BancoFac;
    }

    public String getCtaBcoFac() {
        return ctaBcoFac;
    }

    public void setCtaBcoFac(String ctaBcoFac) {
        this.ctaBcoFac = ctaBcoFac;
    }

    public Date getLastUpdateFac() {
        return lastUpdateFac;
    }

    public void setLastUpdateFac(Date lastUpdateFac) {
        this.lastUpdateFac = lastUpdateFac;
    }

    @Override
    public String toString() {
        return "Facilitador{" + "idFacilitador=" + idFacilitador + ", rutFac=" + rutFac + ", nombreFac=" + nombreFac + ", emailFac=" + emailFac + ", telefonoFac=" + telefonoFac + ", valorHoraFac=" + valorHoraFac + ", BancoFac=" + BancoFac + ", ctaBcoFac=" + ctaBcoFac + ", lastUpdateFac=" + lastUpdateFac + '}';
    }
    
    
}

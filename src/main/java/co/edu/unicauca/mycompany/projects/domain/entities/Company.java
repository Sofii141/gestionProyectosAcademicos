package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 *
 * @author Libardo, Julio
 */
public class Company {

    private String comNit;
    private String comName;
    private Sector comSector; 
    private String comEmail;
    private String comPassword;
    private String comContactName;
    private String comContactLastName;
    private String comContactCharge;
    private String comContactPhone;

    public Company(String comNit, String comName, Sector comSector, String comEmail, String comPassword, String comContactName, String comContactLastName, String comContactCharge, String comContactPhone) {
        this.comNit = comNit;
        this.comName = comName;
        this.comSector = comSector;
        this.comEmail = comEmail;
        this.comPassword = comPassword;
        this.comContactName = comContactName;
        this.comContactLastName = comContactLastName;
        this.comContactCharge = comContactCharge;
        this.comContactPhone = comContactPhone;
    }

    public String getComNit() {
        return comNit;
    }

    public void setComNit(String comNit) {
        this.comNit = comNit;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Sector getComSector() {
        return comSector;
    }

    public void setComSector(Sector comSector) {
        this.comSector = comSector;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String comEmail) {
        this.comEmail = comEmail;
    }

    public String getComPassword() {
        return comPassword;
    }

    public void setComPassword(String comPassword) {
        this.comPassword = comPassword;
    }

    public String getComContactName() {
        return comContactName;
    }

    public void setComContactName(String comContactName) {
        this.comContactName = comContactName;
    }

    public String getComContactLastName() {
        return comContactLastName;
    }

    public void setComContactLastName(String comContactLastName) {
        this.comContactLastName = comContactLastName;
    }

    public String getComContactCharge() {
        return comContactCharge;
    }

    public void setComContactCharge(String comContactCharge) {
        this.comContactCharge = comContactCharge;
    }

    public String getComContactPhone() {
        return comContactPhone;
    }

    public void setComContactPhone(String comContactPhone) {
        this.comContactPhone = comContactPhone;
    }

    

}

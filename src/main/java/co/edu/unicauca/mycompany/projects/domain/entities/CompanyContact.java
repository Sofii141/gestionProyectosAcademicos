package co.edu.unicauca.mycompany.projects.domain.entities;

/**
 *
 * @author Libardo, Julio
 */
public class Company {

    private String nit;
    private String name;
    private String phone;
    private String pageWeb;
    private Sector sector;
    private String email;
    private String password;

    public Company(String nit, String name, String phone, String pageWeb, Sector sector, String email, String password) {
        this.nit = nit;
        this.name = name;
        this.phone = phone;
        this.pageWeb = pageWeb;
        this.sector = sector;
        this.email = email;
        this.password = password;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPageWeb() {
        return pageWeb;
    }

    public void setPageWeb(String pageWeb) {
        this.pageWeb = pageWeb;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

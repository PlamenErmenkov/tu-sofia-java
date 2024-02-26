public class Company {
    private String nameCompany;
    private String dateOfCreation;
    private String bulstat;

    public Company(String nameCompany, String dateOfCreation, String bulstat){
        this.nameCompany = nameCompany;
        this.dateOfCreation = dateOfCreation;
        this.bulstat = bulstat;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getBulstat() {
        return bulstat;
    }

    public void setBulstat(String bulstat) {
        if(bulstat.length() == 10){
            this.bulstat = bulstat;
        }else {
            System.out.println("Not a real bulstat!");
        }
    }
}

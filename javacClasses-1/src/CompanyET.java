public class CompanyET {
    private String founderName;
    private double startingCapital;
    private double currentCapital;

    public CompanyET(String founderName, double startingCapital, double currentCapital) {
        this.founderName = founderName;
        this.startingCapital = startingCapital;
        this.currentCapital = currentCapital;
    }

    public String getFounderName() {
        return founderName;
    }

    public void setFounderName(String founderName) {
        this.founderName = founderName;
    }

    public double getStartingCapital() {
        return startingCapital;
    }

    public void setStartingCapital(double startingCapital) {
        this.startingCapital = startingCapital;
    }

    public double getCurrentCapital() {
        return currentCapital;
    }

    public void setCurrentCapital(double currentCapital) {
        this.currentCapital = currentCapital;
    }

    public double currentProfit(){
        return getCurrentCapital() - getStartingCapital();
    }
}

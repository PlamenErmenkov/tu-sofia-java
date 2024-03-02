public abstract class Resource {
    private double amount;
    private double harvestRate;

    public Resource(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getHarvestRate() {
        return harvestRate;
    }

    public void setHarvestRate(double harvestRate) {
        this.harvestRate = harvestRate;
    }

    public void harvest() {
        setAmount(getAmount()+ 1*getHarvestRate());
    }
}

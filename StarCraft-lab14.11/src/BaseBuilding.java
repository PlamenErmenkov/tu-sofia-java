public abstract class BaseBuilding {
    private String name;
    private int level;
    private double constructionTime;
    private double metalRequired;
    private double crystalRequired;
    private double gasRequired;
    private double uraniumRequired;

    public BaseBuilding(String name, int level, double constructionTime, double metalRequired,
                        double crystalRequired, double gasRequired, double uraniumRequired) {
        this.name = name;
        this.level = level;
        this.constructionTime = constructionTime;
        this.metalRequired = metalRequired;
        this.crystalRequired = crystalRequired;
        this.gasRequired = gasRequired;
        this.uraniumRequired = uraniumRequired;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getConstructionTime() {
        return constructionTime;
    }

    public double getMetalRequired() {
        return metalRequired;
    }

    public double getCrystalRequired() {
        return crystalRequired;
    }

    public double getGasRequired() {
        return gasRequired;
    }

    public double getUraniumRequired() {
        return uraniumRequired;
    }

    public void construct(Planet target){

    }
}

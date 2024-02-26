public class Car {
    private String brand;
    private String model;
    private int power;
    private String engine;

    public Car() {
        this.brand = "";
        this.model = "";
        this.power = 0;
        this.engine = "";
    }

    public Car(String brand, String model, int power, String engine) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}

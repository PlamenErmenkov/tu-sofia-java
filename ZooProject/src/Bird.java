import java.util.Date;

public abstract class Bird extends Animal{
    public Bird(String name, Date birthDate, Sex sex, AnimalType type, double weight) {
        super(name, birthDate, sex, type, weight);
    }

    @Override
    public void move() {
        System.out.println("Bird moving");
    }

    @Override
    public void eat() {
        System.out.println("Bird eating");
    }

    @Override
    public void sleep() {
        System.out.println("Bird sleeping");

    }

    @Override
    public void reproduce() {
        System.out.println("Bird reproducing");
    }

}

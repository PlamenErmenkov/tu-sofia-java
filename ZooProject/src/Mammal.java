import java.util.Date;

public class Mammal extends Animal{
    public Mammal(String name, Date birthDate, Sex sex, AnimalType type, double weight) {
        super(name, birthDate, sex, type, weight);
    }

    @Override
    public void move() {
        System.out.println("Mammal moving");
    }

    @Override
    public void eat() {
        System.out.println("Mammal eating");
    }

    @Override
    public void sleep() {
        System.out.println("Mammal sleeping");

    }

    @Override
    public void reproduce() {
        System.out.println("Mammal reproducing");
    }
}

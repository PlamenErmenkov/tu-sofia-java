import java.util.Date;

public class Lion extends Mammal{
    public Lion(String name, Date birthDate, Sex sex, AnimalType type, double weight) {
        super(name, birthDate, sex, type=AnimalType.LION, weight);
    }
    @Override
    public void move() {
        System.out.println("Lion moving");
    }

    @Override
    public void eat() {
        System.out.println("Lion eating");
    }

    @Override
    public void sleep() {
        System.out.println("Lion sleeping");

    }

    @Override
    public void reproduce() {
        System.out.println("Lion reproducing");
    }
}

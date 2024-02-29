import java.util.Date;

public class Penguin extends Bird implements IFly{
    //private static AnimalType type = AnimalType.PENGUIN;

    public Penguin(String name, Date birthDate, Sex sex, double weight) {
        super(name, birthDate, sex, AnimalType.PENGUIN, weight);
    }

    @Override
    public void fly() {
        System.out.println("Penguin is flying");
    }
}

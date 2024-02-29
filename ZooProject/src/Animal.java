import java.lang.reflect.Type;
import java.util.Date;

public  abstract class Animal {
    private String name;
    private Date birthDate;
    private Sex sex;
    private AnimalType type;
    private double weight;

    public Animal(String name, Date birthDate, Sex sex, AnimalType type, double weight) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.type = type;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }


    public Date getBirthDate() {
        return birthDate;
    }



    public Sex getSex() {
        return sex;
    }


    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type){
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract void move();

    public abstract void eat();
    public abstract void sleep();
    public abstract void reproduce();


}

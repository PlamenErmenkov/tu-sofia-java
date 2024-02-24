public class SimpleCar extends Vehicle implements Honkable{
    private int speed;

    public SimpleCar(int speed){
        this.speed = speed;
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void accelerate(){
        setSpeed(getSpeed()+10);
    }

    public void honk(){
        System.out.println("Honk!");
    }

    public void move(){
        System.out.println("The car is moving");
    }

}

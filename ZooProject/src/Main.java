import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        Penguin penguin = new Penguin("PP", date, Sex.MALE, 4);

        if (penguin instanceof IFly){
            ((IFly)penguin).fly();
        } else {
            penguin.move();
        }
    }
}
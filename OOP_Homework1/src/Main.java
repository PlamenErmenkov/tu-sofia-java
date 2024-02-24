import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
        SimpleCar car1 = new SimpleCar(30);
        FamilyCar car2 = new FamilyCar(20, 5);

        SimpleCar[] cars = {car1, car2};

        for (SimpleCar car: cars) {
            if(car instanceof FamilyCar){
                System.out.println("This is a FamilyCar");
                ((FamilyCar) car).addSeat();
                System.out.println(((FamilyCar) car).getSeats());
            }else {
                System.out.println("This is a SimpleCar");
            }
        }
*/
        DanceMove move1 = new DanceMove("moonwalk", 5);
        //move1.perform();
        BreakDanceMove move2 = new BreakDanceMove("windmill", 8, 8);
//        move2.perform();
//        move1.dance();
//        move2.start();
        Song song1 = new Song("Bohemian Rhapsody");
        //song1.sing();

        ArrayList<Performance> moves = new ArrayList<>();
        moves.add(move1);
        moves.add(move2);
        moves.add(song1);

//        for(Performance move : moves){
//            move.start();
//        }

        Performance[] performances = {move1, move2, song1};

        Party party1 = new Party(performances);
        party1.startParty();


    }
}
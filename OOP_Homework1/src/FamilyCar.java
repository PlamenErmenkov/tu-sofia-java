public class FamilyCar extends SimpleCar{
    private int seats;

    public FamilyCar(int speed, int seats){
        super(speed);
        this.seats = seats;
    }

    public int getSeats(){
        return seats;
    }

    public void setSeats(int seats){
        this.seats = seats;
    }

    public void addSeat(){
        setSeats(getSeats()+1);
    }

}

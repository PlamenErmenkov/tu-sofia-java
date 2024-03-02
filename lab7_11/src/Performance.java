import java.util.Date;

public class Performance implements Ticketable{
    protected String title;
    protected String director;
    protected Date date;
    protected int totalSeats;
    protected double pricePerSeat;

    public Performance(String title, String director, Date date, int totalSeats, double pricePerSeat) {
        this.title = title;
        this.director = director;
        this.date = date;
        this.totalSeats = totalSeats;
        this.pricePerSeat = pricePerSeat;
    }

    @Override
    public boolean book(int num) throws NoMoreSeatsException {
        if(totalSeats >= num){
            this.totalSeats -= num;
            return true;
        }else {
            throw new NoMoreSeatsException("There are no more seats");
        }
    }
}

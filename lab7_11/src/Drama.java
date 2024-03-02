import java.util.Date;

public class Drama extends Performance{
    protected String mainActor;

    public Drama(String title, String director, Date date, int totalSeats, double pricePerSeat, String mainActor) {
        super(title, director, date, totalSeats, pricePerSeat);
        this.mainActor = mainActor;
    }

}

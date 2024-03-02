import java.util.Date;

public class leadComedian extends Performance{
    protected String leadComedian;

    public leadComedian(String title, String director, Date date, int totalSeats, double pricePerSeat, String leadComedian) {
        super(title, director, date, totalSeats, pricePerSeat);
        this.leadComedian = leadComedian;
    }
}

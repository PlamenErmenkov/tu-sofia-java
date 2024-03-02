import java.util.Date;

public class ClassicArt extends Exhibition{
    protected String eraRepresented;

    public ClassicArt(String title, String artist, Date startDate, int totalArtworks, double ticketPrive, String eraRepresented) {
        super(title, artist, startDate, totalArtworks, ticketPrive);
        this.eraRepresented = eraRepresented;
    }
}

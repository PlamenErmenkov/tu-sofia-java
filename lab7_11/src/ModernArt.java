import java.util.Date;

public class ModernArt extends Exhibition{
    protected String mainTheme;

    public ModernArt(String title, String artist, Date startDate, int totalArtworks, double ticketPrive, String mainTheme) {
        super(title, artist, startDate, totalArtworks, ticketPrive);
        this.mainTheme = mainTheme;
    }

}

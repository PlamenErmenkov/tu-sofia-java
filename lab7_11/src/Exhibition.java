import java.util.Date;

public class Exhibition implements Purchasable{
    protected String title;
    protected String artist;
    protected Date startDate;
    protected int totalArtworks;
    protected double ticketPrive;

    public Exhibition(String title, String artist, Date startDate, int totalArtworks, double ticketPrive) {
        this.title = title;
        this.artist = artist;
        this.startDate = startDate;
        this.totalArtworks = totalArtworks;
        this.ticketPrive = ticketPrive;
    }

    @Override
    public boolean purchase(int num) throws SoldOutException {
        if(this.totalArtworks >= num){
            this.totalArtworks -= num;
            return true;
        }else {
            throw new SoldOutException();
        }
    }
}

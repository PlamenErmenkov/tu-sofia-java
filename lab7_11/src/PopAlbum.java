public class PopAlbum extends Album{
    protected String producer;

    public PopAlbum(String albumName, String artist, int releaseYear, int totalTracks, double pricePerAlbum, String producer) {
        super(albumName, artist, releaseYear, totalTracks, pricePerAlbum);
        this.producer = producer;
    }

}

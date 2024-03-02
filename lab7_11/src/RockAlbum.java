public class RockAlbum extends Album{
    protected String bandName;

    public RockAlbum(String albumName, String artist, int releaseYear, int totalTracks, double pricePerAlbum, String bandName) {
        super(albumName, artist, releaseYear, totalTracks, pricePerAlbum);
        this.bandName = bandName;
    }

}

public class Album {
    protected String albumName;
    protected String artist;
    protected int releaseYear;
    protected int totalTracks;
    protected double pricePerAlbum;

    public Album(String albumName, String artist, int releaseYear, int totalTracks, double pricePerAlbum) {
        this.albumName = albumName;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.totalTracks = totalTracks;
        this.pricePerAlbum = pricePerAlbum;
    }

    public boolean buyAlbum(int num) throws OutOfStockException{
        if(this.totalTracks >= num){
            return true;
        }else {
            throw new OutOfStockException("No more tracks");
        }
    }
}

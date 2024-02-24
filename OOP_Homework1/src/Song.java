public class Song extends Performance{

    private String songName;
    public Song(String songName) {
        this.songName = songName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void sing(){
        System.out.println("Singing '"+getSongName()+"'");
    }

    @Override
    public void start() {
        System.out.println("Starting "+getSongName());
    }
}

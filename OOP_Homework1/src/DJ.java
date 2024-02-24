public class DJ implements Playable{
    public void playSong(Song song){
        System.out.println("Playing "+song);
    }

    @Override
    public void play() {
        System.out.println("Playing");

    }
}

public class DanceMove extends Performance implements Dancable{
    private String name;
    private int duration;

    public DanceMove(String name, int duration){
        this.name = name;
        this.duration = duration;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getDuration(){
        return this.duration;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    public void perform(){
        System.out.println("Performing the "+getName()+" for "+getDuration()+" seconds.");
    }

    public void dance(){
        System.out.println("Dancing the "+getName());
    }

    public void start(){
        System.out.println("Starting the "+getName());
    }

}

public class BreakDanceMove extends DanceMove{
    private int complexity;

    public BreakDanceMove(String name, int duration, int complexity){
        super(name, duration);
        this.complexity = complexity;
    }
    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public void perform(){
        System.out.println("Performing the "+getName()+" with complexity level "+getComplexity());
    }

}

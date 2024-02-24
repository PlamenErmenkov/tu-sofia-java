public class Fish extends Animal implements Swimming{
    @Override
    public void swim(){
        System.out.println("The fish is swimming");
    }
    @Override
    public void sound(){
        System.out.println("The fish does -");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog("Husky", 7);
        myDog.sound();

        Dog yourDog = new Dog("Wolf", 3);
        yourDog.sound();

        Animal fish1 = new Fish();
        fish1.sound();


        Fish fish2 = new Fish();
        fish2.swim();

        Swimming fish3 = new Fish();
        fish3.swim();
    }
}
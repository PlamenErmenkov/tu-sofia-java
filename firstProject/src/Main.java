
public class Main {
    public static void main(String[] args) {

        System.out.print("Hello and welcome!\n");
        boolean flag = false;
        for (int i = 1; i <= 5 && !flag; i++) {
            if (i == 3){
                flag = true;
            }
            System.out.println("i = " + i);
        }
    }
}
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int num = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e.toString());
        }
    }
}
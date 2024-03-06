import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // Създаване на сокет към сървъра
        Socket s = new Socket("127.0.0.1", 1211);

        // Създаване на Scanner за четене от конзолата

        // Създаване на Scanner за четене на отговор от сървъра

        // Изпращане на число към сървъра
        PrintStream printout = new PrintStream(s.getOutputStream());
        System.out.print("Enter some value: ");
        try (s; Scanner scan = new Scanner(System.in); Scanner scan2 = new Scanner(s.getInputStream())) {
            int number = scan.nextInt();
            printout.println(number);

            // Четене на отговора от сървъра и извеждане на конзолата
            String input = scan2.nextLine();
            System.out.println(input);
        } catch (InputMismatchException e) {
            System.out.println("Enter a correct value");
        }
        // Затваряне на ресурсите
    }
}
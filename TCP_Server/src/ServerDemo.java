import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // Създаване на ServerSocket на порт 1211
        ServerSocket server = new ServerSocket(1211);

        // Сървърът "слуша" за входящи връзки
        Socket socket = server.accept();

        // Създаване на Scanner обект за четене на данни от клиента
        Scanner scan = new Scanner(socket.getInputStream());

        // Прочитане на числото, изпратено от клиента
        int number = scan.nextInt();

        // Изпращане на отговор обратно към клиента
        PrintStream printout = new PrintStream(socket.getOutputStream());
        printout.println((number % 2 == 0) ? "Your number is even" : "Your number is odd");

        // Затваряне на сървъра
        server.close();
    }
}
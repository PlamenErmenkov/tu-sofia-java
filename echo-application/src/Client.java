import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client started");
        try {
            Socket socket = new Socket("localhost", 9806);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter a String: ");
            String userString = userInput.readLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(userString);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

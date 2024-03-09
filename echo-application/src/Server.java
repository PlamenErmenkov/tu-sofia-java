import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Waiting for clients...");

        try {
            ServerSocket ss = new ServerSocket(9806);
            Socket socket = ss.accept();
            System.out.println("Connection established: ");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str = in.readLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Server says: " + str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

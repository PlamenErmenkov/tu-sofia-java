import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket server;
    private ExecutorService pool;
    private List<Car> carsForSale;

    public Server(int port) {
        try {
            server = new ServerSocket(port);
            pool = Executors.newFixedThreadPool(3);
            carsForSale = Collections.synchronizedList(new ArrayList<>() {
                {
                    add(new Car("BMW", "X5", 50000));
                    add(new Car("BMW", "X6", 60000));
                    add(new Car("BMW", "X7", 70000));
                    add(new Car("Audi", "A6", 40000));
                    add(new Car("Audi", "A7", 50000));
                    add(new Car("Audi", "A8", 60000));
                    add(new Car("Mercedes", "S500", 80000));
                    add(new Car("Mercedes", "S600", 90000));
                    add(new Car("Mercedes", "S700", 100000));
                    add(new Car("Toyota", "Auris", 20000));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                Socket client = server.accept();
                ClientHandler clientHandler = new ClientHandler(client, carsForSale);
                pool.execute(clientHandler);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(1234);
        server.start();
    }
}


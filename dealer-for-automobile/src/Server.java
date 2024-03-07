import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ServerSocket serverSocket;
    private List<Car> carsForSale;
    private ExecutorService pool;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            carsForSale = new ArrayList<>();
            carsForSale.add(new Car("BMW", "M5", 200000));
            pool = Executors.newFixedThreadPool(3);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

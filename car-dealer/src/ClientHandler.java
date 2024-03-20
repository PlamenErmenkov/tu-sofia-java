import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    private Scanner reader;
    private PrintStream writer;
    private Socket client;
    private List<Car> carsForSale;

    public ClientHandler(Socket socket, List<Car> carsForSale) {
        this.carsForSale = carsForSale;
        client = socket;
        try {
            reader = new Scanner(client.getInputStream());
            writer = new PrintStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String request;
            while ((request = reader.nextLine()) != null) {
                String[] tokens = request.split(" ", 2);
                String command = tokens[0];
                switch (command) {
                    case "PRICE":
                    sendCarPrice(tokens[1]);
                    break;
                    case "EVALUATE":
                        evaluateCar(tokens[1]);
                        break;
                    case "SELL":
                        sellCar(tokens[1]);
                        break;
                    default:
                        writer.println("Invalid command");
                        break;
                }
            }
        } finally {
            closeConnection();
        }
    }

    private void sendCarPrice(String model) {
        Car car = carsForSale.stream()
                .filter(c -> c.getModel().equalsIgnoreCase(model))
                .findFirst()
                .orElse(null);
        if (car != null) {
            System.out.println("Sending details to the client");
            writer.println("Price of " + model + ": " + car.getPrice());
        } else {
            writer.println("Car not found");
        }
    }

    private void evaluateCar(String carDetails) {
        System.out.println("Sending evaluation to the client");
        writer.println("Car evaluated: " + carDetails);
    }

    private void sellCar(String carDetails) {
        String[] details = carDetails.split(" ");
        System.out.println("Sending sell confirmation to the client");
        Car car = new Car(details[1], details[2], Double.parseDouble(details[3]));
        carsForSale.add(car);
        writer.println("Car sold: " + carDetails);
    }

    private void closeConnection() {
        try {
            writer.close();
            reader.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

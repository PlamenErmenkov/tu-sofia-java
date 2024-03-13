import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        List<Account> bankAccounts = new ArrayList<>();
        bankAccounts.add(new Account(1001, 0, 1234));
        bankAccounts.add(new Account(1002, 10, 1234));
        bankAccounts.add(new Account(1003, 100, 1234));
        bankAccounts.add(new Account(1004, 1000, 1234));

        try (
                // creating server connected to TCP port 1234
                ServerSocket server = new ServerSocket(1234);
                // listening for new connections
                Socket socket = server.accept();

                // creating input and output streams
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
                Scanner reader = new Scanner(in);
                PrintStream writer = new PrintStream(out);
        ){
            writer.println("Welcome! Enter account number: "); // send message to client
            var bankNumber = reader.nextInt(); // receive number from client
            System.out.println(bankNumber);

            // search for bank account
            Account accountFound = null;
            for (var bankAccount : bankAccounts) {
                if (bankAccount.getAccountNumber() == bankNumber) {
                    accountFound = bankAccount;
                    writer.println("Bank account found with that number!");
                    break;
                }
            }
            if (accountFound == null) {
                writer.println("No bank account found with that number! Bye!");
                return;
            }

            writer.println("Enter pin code: "); // send message to client
            var pin = reader.nextInt(); // receive number from client

            // check pin
            if (accountFound.checkPin(pin)) {
                writer.println("PIN is correct!");
            }
            else {
                writer.println("Try again!");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
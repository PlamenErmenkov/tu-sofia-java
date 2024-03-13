/*
 * balance: променлива за съхранение на баланса на сметката.
 * accountNumber: уникален идентификатор на сметката.
 * pin: личен идентификационен номер за достъп до сметката.
 *
 * Методи за достъп до тези стойности (getters/setters).
 * checkBalance(): връща текущия баланс на сметката.
 * deposit(amount): позволява на потребителя да депозира средства в сметката.
 * withdraw(amount): позволява на потребителя да тегли средства, ако има достатъчно средства в сметката.
 */

public class Account {
    private double balance;
    private int accountNumber, pin;

    Account (int accountNumber, double balance, int pin) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    boolean checkPin(int pin) {
        return this.pin == pin;
    }

    public double checkBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


}
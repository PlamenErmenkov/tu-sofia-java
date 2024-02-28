public class Bank implements User, Admin{
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }
    @Override
    public double getBalance(){
        return this.balance;
    }

    @Override
    public void setBalance(double balance){
        this.balance = balance;
    }
}

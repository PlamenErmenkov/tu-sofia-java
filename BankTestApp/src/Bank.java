public class Bank implements User, Admin{
    private int balance;
    public Bank(int balance){
        this.balance = balance;
    }

    @Override
    public int getBalance(){
        return this.balance;
    }

    @Override
    public void setBalance(int balance){
        this.balance = balance;
    }

}

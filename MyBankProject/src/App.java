public class App {
    public static void main(String[] args) {
//        Bank bank = new Bank(5000);
//        bank.getBalance();
//        bank.setBalance(20);

        Admin pako = new Bank(2900);
        User magi = pako;

        System.out.println(magi.getBalance()+" this is before updating the balance (user)");
        pako.setBalance(pako.getBalance() + 200);

        System.out.println(magi.getBalance()+" this is after updating the balance (user)");
        System.out.println(pako.getBalance()+" This is admin");

        //user.setBalance(300);
    }
}
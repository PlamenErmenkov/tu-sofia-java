public class App{
    public static void main(String[] args){
        Bank bank = new Bank(5000);
        User user = bank;
        Admin admin = bank;

        System.out.println(user.getBalance());
        admin.setBalance(admin.getBalance() + 500);
        System.out.println(admin.getBalance());
    }
}
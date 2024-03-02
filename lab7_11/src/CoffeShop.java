public class CoffeShop {
    protected String shopName;
    protected String location;
    protected int foundingYear;
    protected int totalTables;
    protected double pricePerCoffee;

    public CoffeShop(String shopName, String location, int foundingYear, int totalTables, double pricePerCoffee) {
        this.shopName = shopName;
        this.location = location;
        this.foundingYear = foundingYear;
        this.totalTables = totalTables;
        this.pricePerCoffee = pricePerCoffee;
    }

    public boolean reverseTable(int num) throws NoMoreSeatsException{
        if (this.totalTables >= num){
            totalTables -= num;
            return true;
        }else {
            throw new NoMoreSeatsException("No more tables");
        }
    }
}

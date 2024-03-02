public class TraditionalCafe extends CoffeShop{
    protected String mainDessert;

    public TraditionalCafe(String shopName, String location, int foundingYear, int totalTables, double pricePerCoffee, String mainDessert) {
        super(shopName, location, foundingYear, totalTables, pricePerCoffee);
        this.mainDessert = mainDessert;
    }

}

public class ModernCafe extends CoffeShop{
    protected String signature;

    public ModernCafe(String shopName, String location, int foundingYear, int totalTables, double pricePerCoffee, String signature) {
        super(shopName, location, foundingYear, totalTables, pricePerCoffee);
        this.signature = signature;
    }

}

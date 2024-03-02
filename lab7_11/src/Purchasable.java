public interface Purchasable {
    boolean purchase(int num) throws SoldOutException;
}

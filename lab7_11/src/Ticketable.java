public interface Ticketable {
    boolean book(int num) throws NoMoreSeatsException;
}

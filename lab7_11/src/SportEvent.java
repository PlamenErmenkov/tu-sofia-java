import java.util.Date;

public class SportEvent implements Attendable{
    protected String eventName;
    protected String sportType;
    protected Date date;
    protected int totalTickets;
    protected double ticketPrice;

    public SportEvent(String eventName, String sportType, Date date, int totalTickets, double ticketPrice) {
        this.eventName = eventName;
        this.sportType = sportType;
        this.date = date;
        this.totalTickets = totalTickets;
        this.ticketPrice = ticketPrice;
    }

    public boolean attend(int num)throws NoMoreSeatsException{
        if(this.totalTickets >= num){
            this.totalTickets -= num;
            return true;
        }else {
            throw new NoMoreSeatsException("No more tickets");
        }
    }
}

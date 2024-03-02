public class Formula1Competition implements Competition{
    private double winnersTime;
    private Participant[] schedule;

    public Formula1Competition() {

    }

    public Formula1Competition(double winnersTime, Participant[] schedule) {
        this.winnersTime = winnersTime;
        this.schedule = schedule;
    }


    @Override
    public Participant[] getSchedule() {
        return schedule;
    }

    @Override
    public void setSchedule(Participant[] schedule) {
        this.schedule = schedule;
    }
}

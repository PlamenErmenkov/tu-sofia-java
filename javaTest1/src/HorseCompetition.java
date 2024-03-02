public class HorseCompetition implements Competition{
    private String breed;
    private Participant[] schedule;

    public HorseCompetition() {

    }

    public HorseCompetition(String breed, Participant[] schedule) {
        this.breed = breed;
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

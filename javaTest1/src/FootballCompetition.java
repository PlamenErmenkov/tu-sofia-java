public class FootballCompetition implements Competition{
    private double fastestGoal;
    private Participant[] schedule;

    public FootballCompetition() {
        this.schedule = new Participant[0];
    }

    public FootballCompetition(double fastestGoal, Participant[] schedule) {
        this.fastestGoal = fastestGoal;
        this.schedule = schedule;
    }

    public double getFastestGoal() {
        return fastestGoal;
    }

    public void setFastestGoal(double fastestGoal) {
        this.fastestGoal = fastestGoal;
    }

    public void setSchedule(Participant[] schedule) {
        this.schedule = schedule;
    }

    @Override
    public Participant[] getSchedule() {
        return schedule;
    }
}

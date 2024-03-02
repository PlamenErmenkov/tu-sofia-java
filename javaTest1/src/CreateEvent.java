public class CreateEvent {
    private Competition typeOfEvent;

    public CreateEvent() {

    }

    public Competition getEvent(String competitionType) throws EventException {
        switch (competitionType){
            case "FootballCompetition":
                typeOfEvent = new FootballCompetition();
                return typeOfEvent;
            case "HorseCompetition":
                typeOfEvent = new HorseCompetition();
                return typeOfEvent;
            case "Formula1Competition":
                typeOfEvent = new Formula1Competition();
                return typeOfEvent;
            default:
                throw new EventException();
        }
    }

    public void fillSchedule(Competition ob, Participant[] schedule) throws EmptySetException {
        if(schedule == null || schedule.length == 0){
            throw new EmptySetException();
        }

        ob.setSchedule(schedule);
    }
}

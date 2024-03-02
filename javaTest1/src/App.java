public class App {
    public static void main(String[] args) {
        try {
            Participant[] participants = {
                    new Participant(1, "Player1", 25, 50.0, 100.0),
                    new Participant(2, "Player2", 28, 40.0, 80.0),
            };

            CreateEvent event = new CreateEvent();
            Competition footbalEvent = event.getEvent("FootballCompetition");
            event.fillSchedule(footbalEvent, participants);

            for (Participant participant : footbalEvent.getSchedule()) {
                System.out.println("Participant ID: " + participant.getId());
                System.out.println("Participant Name: " + participant.getName());
                System.out.println("Participant Chance to Win: " + participant.getChanceToWin());
                System.out.println("Participant Bet for Win: " + participant.getBetForWin());
                System.out.println("-----------------------------");
            }

            bets(footbalEvent, 2, 55);
            System.out.println(participants[1].getBetForWin());
            System.out.println(participants[1].getChanceToWin());

        } catch (EmptySetException e) {
                System.err.println("Error: Schedule is empty");
        } catch (NullPointerException e) {
            System.err.println("Error: Unable to find participant");
        } catch (EventException e) {
            System.err.println("Error: Unknown event type");
        }
    }
    static void bets(Competition ob, int id, double bet) throws NullPointerException{
        Participant myParticipant = null;

        if (ob.getSchedule() != null) {
            for (Participant participant : ob.getSchedule()) {
                System.out.println("Checking participant with ID: " + participant.getId());
                if (participant.getId() == id) {
                    myParticipant = participant;
                    System.out.println("Participant found!");
                    break;
                }
            }
        }

        if(myParticipant == null){
            throw new NullPointerException();
        }

        double totalBet = (bet + myParticipant.getBetForWin()); // myParticipant.getBetForWin();
        myParticipant.setBetForWin(totalBet);
        myParticipant.setChanceToWin(myParticipant.getChanceToWin() - totalBet * 1/100);

        if(myParticipant.getChanceToWin() < 1.1){
            myParticipant.setChanceToWin(1.1);
        }
    }
}
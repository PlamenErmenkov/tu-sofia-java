import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        displayMainMenu(scanner);
        scanner.close();

    }

    private static void displayMainMenu(Scanner scanner) {
        System.out.println("------------------------");
        System.out.println("| Welcome to Arkanum   |");
        System.out.println("| 1. Start a new game  |");
        System.out.println("| 2. Load a saved game |");
        System.out.println("| 3. Quit              |");
        System.out.println("------------------------");
        System.out.print("Enter your choice: ");

        String  choice = scanner.nextLine();

        switch (choice) {
            case "1":
                newGame(scanner);
                sleepForMilliseconds(2000);
                endCredits();
                break;
            case "2":
                // TODO Implement loading saved games
                break;
            case "3":
                endCredits();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu(scanner);
        }
    }

    public static void newGame(Scanner scanner) {
        System.out.println("A new adventure awaits you...");
        Game.sleepForMilliseconds(2000);
        String characterName = enterCharacterName(scanner);
        Character player = Game.selectCharacter(characterName);
        try {
            ArrayList<Monster> monstersToBattle = Game.selectOpponents(scanner);
            Game.allBattles(player, monstersToBattle, scanner);
        } catch(NullPointerException e){
            System.out.println("The is something wrong with the player!");
            System.out.println(e.getMessage());
        }
    }

    public static String enterCharacterName(Scanner scanner){
        String characterName;
        System.out.print("Enter your character's name: ");
        characterName = scanner.nextLine();

        while (characterName.isEmpty()){
            System.out.println("Invalid name!");
            System.out.print("Enter your character's name: ");
            characterName = scanner.nextLine();
        }

        return characterName;
    }
    public static Character selectCharacter(String characterName) {
        Character player = null;
        String[] racesCharacter = {"Human", "Elf", "Ork", "Dwarf", "BloodyElf"};
        int characterRace;
        Scanner scanner = new Scanner(System.in);

        while(player == null) {
            try {
                System.out.println("Enter the desired type of character: ");
                for (int i = 0; i < racesCharacter.length; i++) {
                    System.out.println((i + 1) + ". " + racesCharacter[i]);
                }
                characterRace = scanner.nextInt();

                if (characterRace >= 1 && characterRace <= racesCharacter.length) {
                    switch (characterRace) {
                        case 1:
                            player = new Human(characterName, 200, 13);
                            player.introduce();
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Please select a valid character.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid input! Please enter a number.");
                scanner.next();
            }
        }

        enterCharToContinue(scanner);
        return player;
    }

    public static ArrayList<Monster> selectOpponents(Scanner scanner) {
        String[] racesMonster = {"FallenShaman", "SkeletonKing", "Butcher"};
        ArrayList<Monster> monstersToBattle = new ArrayList<>();
        boolean[] descriptionShown = new boolean[racesMonster.length];

        int desiredOpponent;

        do {
            desiredOpponent = getValidOpponentChoice(scanner, racesMonster);
            Monster opponent = createOpponent(desiredOpponent);
            displayOpponentDescription(opponent, desiredOpponent, scanner, descriptionShown);
            monstersToBattle.add(opponent);

        } while (addMoreOpponents(scanner));

        return monstersToBattle;
    }

    public static void displayOpponentMenu(String[] racesMonster) {
        System.out.println("Enter your opponents:");
        for (int i = 0; i < racesMonster.length; i++) {
            System.out.println((i + 1) + ". " + racesMonster[i]);
        }
    }

    public static int getValidOpponentChoice(Scanner scanner, String[] racesMonster) {
        int desiredOpponent;

        while(true){
            try {
                displayOpponentMenu(racesMonster);
                desiredOpponent = scanner.nextInt();
                scanner.nextLine();
                if (desiredOpponent >= 1 && desiredOpponent <= racesMonster.length) {
                    return desiredOpponent;
                } else {
                    System.out.println("Invalid choice. Please select a valid character.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid input! Please enter a number.");
                scanner.next();
            }
        }
    }

    public static Monster createOpponent(int desiredOpponent) {
        Monster opponent = null;
        switch (desiredOpponent) {
            case (1):
                opponent = new FallenShaman("FallenShaman", 75, 6);
        }

        return opponent;
    }

    public static boolean addMoreOpponents(Scanner scanner) {
        String userWantsOpponents;

        while(true) {
            try{
                System.out.println("Do you want more opponents? (y/n)");
                userWantsOpponents = scanner.nextLine().toLowerCase().trim();
                if(userWantsOpponents.equals("y")){
                    return true;
                } else if(userWantsOpponents.equals("n")){
                    return false;
                }else {
                    throw new InvalidParameterException();
                }

            } catch (InvalidParameterException e){
                System.out.println("You should either enter 'y' or 'n'!");
            }
        }
    }

    public static boolean shouldAskForDescription(Scanner scanner) {
        System.out.println("Do you want a brief description for this opponent? (y/n)");
        String userWantDescription = scanner.nextLine().toLowerCase().trim();

        while(!userWantDescription.equals("y") && !userWantDescription.equals("n")){
            System.out.println("Invalid choice. Enter: (y/n)");
            userWantDescription = scanner.nextLine().trim().toLowerCase();
        }
        return userWantDescription.equals("y");
    }

    public static void displayOpponentDescription(Monster opponent, int opponentEqualNum, Scanner scanner, boolean[] descriptionShown) {

        if (!descriptionShown[opponentEqualNum - 1]) {
            descriptionShown[opponentEqualNum - 1] = shouldAskForDescription(scanner);
            if (descriptionShown[opponentEqualNum - 1]) {
                System.out.println(opponent.getDescription());
            }
        }
        descriptionShown[opponentEqualNum - 1] = true;
    }

    public static void singleBattle(Character player, Monster opponent) {
        int round = 1;
        while (true){
            System.out.println("---------------------------------");
            System.out.println("Round: "+round);
            round++;
            player.attack(opponent);
            System.out.println(player.getName() + " attacks " + opponent.getName() + " for " + player.getPower() + " damage.");

            if(opponent.isMonsterDead()){
                sleepForMilliseconds(2000);
                System.out.println("You have defeated "+opponent.getName());
                break;
            }else {
                System.out.println(opponent.getName() + " has " + opponent.getHealth() + " health remaining.");
                System.out.println("---------------------------------");
            }
            opponent.attack(player);
            System.out.println(opponent.getName() + " attacks " + player.getName() + " for " + opponent.getPower() + " damage.");

            if(player.isCharacterDead()){
                sleepForMilliseconds(2000);
                System.out.println("\n"+player.getName()+" is defeated!");
                System.out.println("You lose!\n");
                break;
            }else {
                System.out.println(player.getName() + " has " + player.getHealth() + " health remaining.");
                System.out.println("---------------------------------");
            }
            sleepForMilliseconds(2000);
            System.out.print("\n");
        }
    }

    public static void allBattles(Character player, ArrayList<Monster> monstersToBattle, Scanner scanner){
        for(int i = 0; i < monstersToBattle.size(); i++){
            System.out.println("Battle "+(i+1)+". is about to start!");
            System.out.println("Your opponent is: ");//+monstersToBattle.get(i).getName());
            monstersToBattle.get(i).introduce();
            enterCharToContinue(scanner);
            singleBattle(player, monstersToBattle.get(i));
            if(player.isCharacterDead()){
                break;
            }
        }
    }

    public static void endCredits(){
        System.out.println("Thanks for playing Arkanun!");
        System.out.println(
                "I want to say thanks to the creator for all the \n" +
                "dedication and hard work that went into this project :D"
        );
    }

    public static void enterCharToContinue(Scanner scanner){
        String userString = "";
        System.out.print("Press something to continue: ");
        while (userString.isEmpty()){
            userString = scanner.nextLine();
        }
    }

    public static void sleepForMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
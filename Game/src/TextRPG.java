import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

public class TextRPG {
    //private static Skill fireball = new Skill("Fireball", "Inflicts damage and has a small chance for fire damage over time.", 40, 3);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        playSound();
        System.out.println("Welcome to TopG Simulation!");
        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();

        Hero player = new Hero(playerName);

        // Game loop
        boolean running = true;
        while (running) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Explore");
            System.out.println("2. Visit the shop");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You venture into the wilderness...");
                    sleepForMilliseconds(2000);

                    do {
                        Monster monster = createMonster(player);
                        System.out.println("A monster has been encountered!");
                        monster.printMonsterStartingStats();
                        sleepForMilliseconds(2000);

                        while (true) {
                            //fireball.useFireBall(player, monster);
                            chooseAttackForPlayer(player, monster, scanner);
                            if (!monster.isMonsterAlive()) {
                                System.out.println("The monster was defeated!");
                                System.out.print("\n");
                                player.giveGoldToPlayer(monster);
                                player.checkLevelUp(monster);
                                printPlayerStats(player);
                                sleepForMilliseconds(2000);

                                break;
                            }
                            monster.attack(player);
                            if (!player.isPlayerAlive()) {
                                System.out.println("You have been defeated!");
                                printPlayerStats(player);
                                sleepForMilliseconds(2000);
                                //TODO
                                break;
                            }
                            printCurrentHealth(player, monster);
                            sleepForMilliseconds(2000);
                        }
                        player.levelUp();
                        sleepForMilliseconds(2000);
                    } while (continueBattle());
                    break;
                case 2:
                    System.out.println("You enter the shop...");

                    // TODO
                    break;
                case 3:
                    System.out.println("Thanks for playing!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        scanner.close();
    }

    public static void sleepForMilliseconds(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void printCurrentHealth(Hero player, Monster monster){
        System.out.println(player.getName()+"'s health is: "+player.getHealth()+"\t||\t"+monster.getName()+"'s health is: "+monster.getHealth()+"\n");
    }

    public static boolean continueBattle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue battling (y/n): ");
        String userInput = scanner.nextLine().trim().toLowerCase();
        while(true){
            if(userInput.equals("y")){
                return true;
            }else if (userInput.equals("n")){
                return false;
            }else {
                System.out.println("Invalid input!!!");
                return false;
            }
        }
    }

    public static void printPlayerStats(Hero player){
        System.out.println("Remaining Health: " + player.getHealth());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Exp: " + player.getExp());
        System.out.println("Gold: " + player.getGold());
    }

    public static Monster createMonster(Hero player){
        String monsterName = "Chubaka The Great";
        return new Monster(monsterName, player);
    }

    public static void chooseAttackForPlayer(Hero player, Monster monster, Scanner scanner){

        if(player.isEmptySkillsList()){
            player.attack(monster);
        }else {
            System.out.println("Do you want to use a special skill? (y/n)");
            String userInput = scanner.next().trim().toLowerCase();
            if(userInput.equals("n")){
                player.attack(monster);
            }else {
                int i = 1;
                System.out.println("Available skills: ");
                for(Skill skill : player.getSkills()){
                    System.out.print(i+"."+skill.getName()+" ");
                    i++;
                }
                int userChoiceForSkill = scanner.nextInt();
                switch (userChoiceForSkill) {
                    case 1:
                        if (userChoiceForSkill <= player.getSkills().size()) {
                            Skill selectedSkill = player.getSkills().get(userChoiceForSkill - 1);
                            selectedSkill.useSkill(player, monster);
                        } else {
                            System.out.println("Invalid skill choice.");
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            }
        }
    }

    public static void playSound() {
        try {
            File file = new File("GameSound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

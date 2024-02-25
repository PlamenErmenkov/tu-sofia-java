//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class PlayNewGame {
//    public static void newGame(Scanner scanner) {
//        System.out.println("A new adventure awaits you...");
//        Game.sleepForMilliseconds(2000);
//        System.out.print("Enter your character's name: ");
//        String characterName = scanner.nextLine();
//        Character player = Game.selectCharacter(characterName, scanner);
//        if (player != null) {
//            ArrayList<Monster> monstersToBattle = Game.selectOpponents(scanner);
//            Game.allBattles(player, monstersToBattle, scanner);
//        }else{
//            System.out.println("The is something wrong with the player!");
//        }
//    }
//}

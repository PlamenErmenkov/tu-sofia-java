import java.util.Random;

public class Monster {
    private String name;
    private int health;
    private int attack;
    private int level;
    private int exp;
    private int gold;
    public Monster(String name, Hero player) {
        this.name = name;
        this.level = calculateMonsterLevel(player.getLevel());
        this.health = 130 * level;
        this.attack = 7 * level;
        this.exp = 80 * level;
        this.gold = calculateMonsterGold();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void attack(Hero player) {
        System.out.println(getName()+" attacks "+player.getName()+" with "+getAttack()+" damage!");
        player.setHealth(player.getHealth() - getAttack());
    }

    public int calculateMonsterLevel(int playerLevel){
        Random random = new Random();

        if(playerLevel == 1){
            return 1;
        }else if(playerLevel == 2){
            return random.nextInt(2)+1;
        }else {
            int levelVariance = random.nextInt(5) - 2;
            int monsterLevel = levelVariance + playerLevel;
            return monsterLevel;
        }
    }

    public int calculateMonsterGold(){
        Random random = new Random();
        int randomGoldVariance = random.nextInt(3) + 1;
        return randomGoldVariance * (getLevel() * 10);
    }

    public void printMonsterStartingStats(){
        System.out.println("--------------");
        System.out.println("Name: "+getName());
        System.out.println("Health: " + getHealth());
        System.out.println("Attack: " + getAttack());
        System.out.println("Level: " + getLevel());
        System.out.println("Exp: " + getExp());
        System.out.println("--------------");
    }

    public boolean isMonsterAlive() {
        return getHealth() > 0;
    }

}

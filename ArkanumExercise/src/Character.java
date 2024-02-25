public abstract class Character implements Attackable{
    private String name;
    private int health;
    private int power;
    private String type;
    private int totalNumAttack;
    private String description;

    public Character(String name, int health, int power) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.description = null;
        this.type = null;
        this.totalNumAttack = 0;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
    public String getProfession() {
        return type;
    }

    public void setProfession(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalNumAttack() {
        return totalNumAttack;
    }

    public void setTotalNumAttack(int totalNumAttack) {
        this.totalNumAttack = totalNumAttack;
    }

    public boolean isCharacterDead(){
        return getHealth() <= 0;
    }

    public abstract void attack(Character target);

    public void introduce(){
        System.out.println("-------------");
        System.out.println(getClass());
        System.out.println("Health: "+getHealth());
        System.out.println("Attack: "+getPower());
        System.out.println("Profession: "+getProfession());
        System.out.println("Description: "+getDescription());
        System.out.println("--------------");
    }

}

public class Skill {
    private String name;
    private String description;
    private int damage;
    //private int actionCountdownUse;
    //private SpecialEffect specialEffect;  // Add special effect
    private int levelRequired;  // Add level required to unlock

    public Skill(String name, String description, int damage, int levelRequired) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        //this.actionCountdownUse = actionCountdownUse;
        //this.specialEffect = specialEffect;
        this.levelRequired = levelRequired;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

//    public int getActionCountdownUse() {
//        return actionCountdownUse;
//    }

    //public SpecialEffect getSpecialEffect() {
        //return specialEffect;
    //}

    public int getLevelRequired() {
        return levelRequired;
    }

    public void useFireBall(Hero player, Monster monster){
        System.out.println(player.getName()+" uses FireBall.");
        monster.setHealth(monster.getHealth() - getDamage());
    }

    public void useSkill(Hero player, Monster monster) {
        System.out.println(player.getName()+" attacks "+monster.getName()+" with "+getName()+" for "+getDamage()+" damage!");
        monster.setHealth(monster.getHealth() - getDamage());
    }

}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hero {
    private int baseHealth;
    private String name;
    private int attack;
    private int level;
    private int exp;
    private int health;
    private int gold;
    private SpecialEffect activeEffect;
    private List<Skill> skills = new LinkedList<>();

    public Hero(String name) {
        this.name = name;
        this.attack = 15;
        this.baseHealth = 1050; // 250
        this.health = baseHealth;
        this.level = 1;
        this.exp = 0;
        this.gold = 0;
        this.activeEffect = null;
    }

    public String getName() {
        return name;
    }


    public int getHealth() {
        return health;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }

    public int getAttack() {
        return attack;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public SpecialEffect getActiveEffect() {
        return activeEffect;
    }

    public void setActiveEffect(SpecialEffect activeEffect) {
        this.activeEffect = activeEffect;
    }

    public void attack(Monster monster){
        System.out.println(getName()+" attacks "+monster.getName()+" with "+getAttack()+" damage!");
        monster.setHealth(monster.getHealth()-getAttack());
    }

    public void levelUp(){
        if(isEnoughExpForLevelUp()){
            printLevelingUp();
            setLevel(getLevel()+1);
            setExp(getExp() - 100 * (getLevel() - 1));
            setAttack((int) (getAttack() * 1.5));
            setBaseHealth((int) (getBaseHealth() * 1.5));
            setHealth(getBaseHealth());
            Skill skillToUnlock = findSkillToUnlock();
            if (skillToUnlock != null) {
                unlockSkill(skillToUnlock);
            }
        }
    }

    public boolean isEnoughExpForLevelUp(){
        return getExp() >= 100 * getLevel();
    }

    public boolean isPlayerAlive(){
        return getHealth() > 0;
    }

    public void checkLevelUp(Monster monster) {
        if (!monster.isMonsterAlive()) {
            setExp(getExp() + monster.getExp());

            while (isEnoughExpForLevelUp()) {
                Skill skillToUnlock = findSkillToUnlock();
                levelUp();
            }
        }
    }

    public void printLevelingUp(){
        System.out.println(getName()+" is leveling up:");
        System.out.println("Level: "+getLevel()+" ---> " +(getLevel()+1));
        System.out.println("Base Health: "+getBaseHealth()+" ---> "+ (int)(getBaseHealth() * 1.5));
        System.out.println("Attack: "+getAttack()+" ---> "+(int)(getAttack() * 1.5));
        System.out.print("\n");
    }

    public void giveGoldToPlayer(Monster monster){
        if(!monster.isMonsterAlive()){
            setGold(getGold() + monster.getGold());
        }
    }

    public void applySpecialEffect(SpecialEffect effect) {
        if (activeEffect == null) {
            activeEffect = effect;
            System.out.println(name + " is now under the effect of " + effect.getName() + ": " + effect.getDescription());
        } else {
            System.out.println(name + " already has an active effect. Can't apply another.");
        }
    }

    public void unlockSkill(Skill skill) {
        if (getLevel() >= skill.getLevelRequired() && !skills.contains(skill)) {
            skills.add(skill);
            System.out.println(getName() + " unlocked the skill: " + skill.getName());
        }
    }

    public Skill findSkillToUnlock(){
        if(getLevel() >= 3){
            return new Skill("Fireball", "Inflicts damage and has a small chance for fire damage over time.", 40, 3);
        }else{
            return null;
        }
    }

    public boolean isEmptySkillsList(){
        return skills.isEmpty();
    }


}

public abstract class Monster extends Character{
    private String type;
    private String description;

    public Monster(String name, int health, int power) {
        super(name, health, power);
        this.description = null;
        this.type = null;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void attack(Character target) {
        if (target.getHealth() > 0) {
            target.setHealth(target.getHealth() - getPower());
        }
    }

    public boolean isMonsterDead(){
        if(getHealth() <= 0){
            System.out.println(getName()+" is defeated!");
            return true;
        }else{
            return false;
        }
    }

    public void introduce(){
        System.out.println("-------------");
        System.out.println("Class: "+getClass().getSimpleName());
        System.out.println("Health: "+getHealth());
        System.out.println("Attack: "+getPower());
        System.out.println("Type: "+getType());
        System.out.println("--------------");
    }
}

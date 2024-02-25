public class Human extends Character implements Healable{

    public Human(String name, int health, int power) {
        super(name, health, power);
        setDescription(
                """
                        Humans are noble warriors distinguished by their worth and honor.
                        As Paladins, they are defenders of the weak and fight against the
                        dark forces that threaten the world. With their holy weapons and spells,
                        they are a true shield against evil."""
        );
        setProfession("Paladin");
    }


    @Override
    public void attack(Character target) {
        target.setHealth(target.getHealth()-getPower());
        heal();
        setTotalNumAttack(getTotalNumAttack()+1);
    }

    @Override
    public void heal(){
        if(getTotalNumAttack() % 5 == 0 && getTotalNumAttack() != 0){
            setHealth(getHealth() + (int) (getHealth() * 0.2));
            System.out.println(getName()+" healed for "+((int) (getHealth() * 0.2))+" hp!");
        }
    }

}

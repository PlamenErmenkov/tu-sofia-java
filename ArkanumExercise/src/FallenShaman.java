public class FallenShaman extends Monster{

    public FallenShaman(String name, int health, int power) {
        super(name, health, power);
        setDescription("""
                A FallenShaman is a formidable opponent with mastery over dark magic and the ability to\s
                summon undead minions, presenting a challenging adversary for the player's character.
                Defeating a FallenShaman requires strategic combat and resourceful tactics.""");
        setType("Undead");
    }
}

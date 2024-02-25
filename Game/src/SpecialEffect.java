public enum SpecialEffect {
    FIREBALL("Fireball", "Inflicts damage and deals fire damage over time."),
    HEAL("HEAL", "Heals the caster."),
    SHIELD("Shield", "Protects the caster for one turn.");

    private final String name;
    private final String description;
    SpecialEffect(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}

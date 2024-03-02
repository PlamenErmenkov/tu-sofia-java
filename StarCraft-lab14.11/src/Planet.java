import java.util.List;

public class Planet extends OrbitalSpaceObject implements Orbiter{
    private double metal;
    private double gas;
    private double crystal;
    private double uranium;
    public Planet(String name, int coordinateX, int coordinateY, int coordinateZ, double mass,
                  List<SpaceObject> orbiters, double metal, double gas, double crystal, double uranium) {
        super(name, coordinateX, coordinateY, coordinateZ, mass, orbiters);
        this.metal = metal;
        this.gas = gas;
        this.crystal = crystal;
        this.uranium = uranium;
    }

    public double getMetal() {
        return metal;
    }

    public void setMetal(double metal) {
        this.metal = metal;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public double getCrystal() {
        return crystal;
    }

    public void setCrystal(double crystal) {
        this.crystal = crystal;
    }

    public double getUranium() {
        return uranium;
    }

    public void setUranium(double uranium) {
        this.uranium = uranium;
    }

    @Override
    public void orbit(SpaceObject target) throws NotValidObjectException{
        if(!(target instanceof Satellite)){
            throw new NotValidObjectException("Invalid SpaceObject Exception");
        }

        addOrbiter(target);
    }

    public void printResources(){
        System.out.println("Metal: "+getMetal());
        System.out.println("Gas: "+getGas());
        System.out.println("Crystal: "+getCrystal());
        System.out.println("Uranium: "+getUranium());
    }

    public void harvestMetal(double metalHarvested){
        if(getMetal() > metalHarvested){
            setMetal(getMetal() - metalHarvested);
        }else {
            setMetal(0);
        }
    }

    public void harvestGas(double gasHarvested){
        if(getGas() > gasHarvested){
            setGas(getGas() - gasHarvested);
        }else {
            setGas(0);
        }
    }

    public void harvestCrystal(double crystalHarvested){
        if(getCrystal() > crystalHarvested){
            setCrystal(getCrystal() - crystalHarvested);
        }else {
            setCrystal(0);
        }
    }

    public void harvestUranium(double uraniumHarvested){
        if(getUranium() > uraniumHarvested){
            setUranium(getUranium() - uraniumHarvested);
        }else {
            setUranium(0);
        }
    }
}

import java.util.List;

public abstract class OrbitalSpaceObject extends SpaceObject{
    private List<SpaceObject> orbiters;

    public OrbitalSpaceObject(String name, int coordinateX, int coordinateY,
                              int coordinateZ, double mass, List<SpaceObject> orbiters) {
        super(name, coordinateX, coordinateY, coordinateZ, mass);
        this.orbiters = orbiters;
    }

    public void setOrbiters(List<SpaceObject> orbiters) {
        this.orbiters = orbiters;
    }

    public void addOrbiter(SpaceObject orbiter){
        orbiters.add(orbiter);
    }

    public List<SpaceObject> getOrbiters(){
        return this.orbiters;
    }
}

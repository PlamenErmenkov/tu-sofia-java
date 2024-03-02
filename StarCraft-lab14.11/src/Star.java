import java.util.List;

public class Star extends OrbitalSpaceObject implements Orbiter{

    public Star(String name, int coordinateX, int coordinateY, int coordinateZ, double mass, List<SpaceObject> orbiters) {
        super(name, coordinateX, coordinateY, coordinateZ, mass, orbiters);
    }

    @Override
    public void orbit(SpaceObject target) throws NotValidObjectException{
        if(!(target instanceof Planet)){
            throw new NotValidObjectException("Invalid SpaceObject Exception");
        }

        addOrbiter(target);
    }
}

import java.util.List;

public class Satellite extends OrbitalSpaceObject implements Orbiter{
    public Satellite(String name, int coordinateX, int coordinateY, int coordinateZ,
                     double mass, List<SpaceObject> orbiters) {
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

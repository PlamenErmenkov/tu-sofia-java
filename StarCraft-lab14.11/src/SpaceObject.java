public abstract class SpaceObject {
    private String name;
    private int coordinateX;
    private int coordinateY;
    private int coordinateZ;
    private double mass;

    public SpaceObject(String name, int coordinateX, int coordinateY, int coordinateZ, double mass) {
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public int getCoordinateZ() {
        return coordinateZ;
    }

    public void setCoordinateZ(int coordinateZ) {
        this.coordinateZ = coordinateZ;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void displayInfo(){
        System.out.println("Name: "+getName());
        System.out.println("Coordinate X: "+getCoordinateX());
        System.out.println("Coordinate Y:"+getCoordinateY());
        System.out.println("Coordinate Z: "+getCoordinateZ());
        System.out.println("Mass: "+getMass());
    }
}

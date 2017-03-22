package pl.edu.agh.siatka.rigidbody;



import java.util.ArrayList;
import java.util.List;

public class RigidBody {


	List<MaterialPoint> materialPoints;
	private double massCenterPosX = 0;
    private double massCenterPosY = 0;
    private double massCenterPosZ = 0;
    private double inertiaX = 0;
    private double inertiaY = 0;
    private double inertiaZ = 0;
	private static final int DECIMAL_PLACES = 2;

	public RigidBody(){
        materialPoints = new ArrayList<>();
	}           //default constructor

	public void addPoint(MaterialPoint mp){
	    materialPoints.add(mp);
	    calculateMassCenter();
	    System.out.println("Coordinates of the mass center are: (" + massCenterPosX + "," + massCenterPosY + "," + massCenterPosZ + ")");
    }                           //methode that adds new points to the body

    private void calculateMassCenter(){
	    double sumOfPosX = 0;
        double sumOfPosY = 0;
        double sumOfPosZ = 0;
        double sumOfMass = 0;
        for(MaterialPoint mp : materialPoints){
            sumOfPosX += mp.getPosX() * mp.getMass();
            sumOfPosY += mp.getPosY() * mp.getMass();
            sumOfPosZ += mp.getPosZ() * mp.getMass();
            sumOfMass += mp.getMass();
        }
        massCenterPosX = Util.round(sumOfPosX/sumOfMass, DECIMAL_PLACES);
        massCenterPosY = Util.round(sumOfPosY/sumOfMass, DECIMAL_PLACES);
        massCenterPosZ = Util.round(sumOfPosZ/sumOfMass, DECIMAL_PLACES);
    }                               //methode calculating coordinates of the center of mass

	public void calculateInertia(String axis){
		if(axis.equalsIgnoreCase("X")){
            inertiaX = calculateInertiaX();
            System.out.println("Inertia of the body around X axis is:" + inertiaX);
		} else if(axis.equalsIgnoreCase("Y")){
            inertiaY = calculateInertiaY();
            System.out.println("Inertia of the body around Y axis is:" + inertiaY);
		} else if(axis.equalsIgnoreCase("Z")){
            inertiaZ = calculateInertiaZ();
            System.out.println("Inertia of the body around Z axis is:" + inertiaZ);
		}
	}                       //calculates inertia around chosen axis

    public double calculateInertiaX() {
	    double inertiaX = 0;
        for (MaterialPoint mp : materialPoints) {
            inertiaX += mp.calculateSteinerInertia(calculateDistance(mp.getPosZ() - massCenterPosZ, mp.getPosY() - massCenterPosY));
        }
        return inertiaX;
    }                               //calculates inertia around X axis

    public double calculateInertiaY() {
        double inertiaY = 0;
        for (MaterialPoint mp : materialPoints) {
            inertiaY += mp.calculateSteinerInertia(calculateDistance(mp.getPosX() - massCenterPosX  ,mp.getPosZ() - massCenterPosZ ) );
        }
        return inertiaY;
    }                               //calculates inertia around Y axis

    public double calculateInertiaZ() {
        double inertiaZ = 0;
        for (MaterialPoint mp : materialPoints) {
            inertiaZ += mp.calculateSteinerInertia(calculateDistance(mp.getPosX() - massCenterPosX,mp.getPosY() - massCenterPosY));
        }
        return inertiaZ;
    }                               //calculates inertia around Z axis

    public double calculateDistance(double x, double y){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }   //method calculating distance between a point and axis in a view



}

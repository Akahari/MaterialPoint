package pl.edu.agh.siatka.rigidbody;


public class MaterialPoint {
    private double mass;                                        // values
    private double radius = 0;
    private double posX = 0;
    private double posY = 0;
    private double posZ = 0;


    public MaterialPoint(){
        this.mass = 0;
    }                   //constructor without arguments

    public MaterialPoint(double mass){
        this.mass = mass;
    }     //constructor with mass as the olny argument

    public MaterialPoint( double x, double y, double z){        //constructor with coordinates as arguments
        this.posX = x;
        this.posY = y;
        this.posZ = z;
    }

    public MaterialPoint(double mass, double x, double y, double z){    //constructor with all values given as arguments
        this.mass = mass;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
    }

    public double getMass(){
        return this.mass;
    }                  //method that allows reading mass value
    public double getPosX(){ return this.posX;}                    //methods that allow readingvalues of coordinates
    public double getPosY(){ return this.posY;}
    public double getPosZ(){ return this.posZ;}

    public void setMass(double mass){
        if(mass >= 0){
            this.mass = mass;
        }
    }                           //method for setting mass value

    public void setPos(double x, double y, double z){
        this.posX = x;
        this.posY = y;
        this.posZ = z;
    }           //method for setting coordinates


    public double calculateInertia(){
        return mass *  Math.pow(radius,2);
    }       //calculates inetria of the point (equal 0)

    public double calculateSteinerInertia(double distance){
        return calculateInertia() + mass * Math.pow(distance,2);
    }       // method calculating inertia of the point around parallel axis


    public void info(){
        System.out.println("Material point");
    }       //displays info
}

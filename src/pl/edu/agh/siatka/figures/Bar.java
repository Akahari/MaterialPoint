package pl.edu.agh.siatka.figures;

/**
 * Created by Akahari on 25-Mar-17.
 */
public class Bar extends MaterialPoint {
    private static final int DECIMAL_PLACES = 2;

    private double length;


    public Bar(){
        super(1);
        this.length = 1;
    }

    public Bar(double length){
        super(1);
        this.length = length;
    }


    public void getLength(){ System.out.println("Bar length is: " + length); }

    public void setLength(double length){ this.length = length; }

    public double calculateInertia(){ return Util.round(this.mass * Math.pow( this.length , 2) / 12, DECIMAL_PLACES); }

    public void info(){
        System.out.println("Bar");
    }

    public void getValues(){
        this.info();
        System.out.println("Bar mass is: " + this.getMass());
        this.getLength();
        System.out.println("Bar inertia is: " + this.calculateInertia());
    }
}

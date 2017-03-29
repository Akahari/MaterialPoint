package pl.edu.agh.siatka.figures;

/**
 * Created by Akahari on 25-Mar-17.
 */
public class Ball extends MaterialPoint {
    private static final int DECIMAL_PLACES = 2;

    private double radius;


    public Ball(){
        super(1);
        this.radius = 1;
    }

    public Ball(double radius){
        super(1);
        this.radius = radius;
    }


    public void getRadius(){ System.out.println("Ball radius is: " + this.radius); }

    public void setRadius(double radius){ this.radius = radius; }

    public double calculateInertia(){ return Util.round(2 * this.mass * Math.pow(this.radius , 2) / 3, DECIMAL_PLACES); }

    public void info(){
        System.out.println("Ball");
    }

    public void getValues(){
        this.info();
        System.out.println("Ball mass is: " + this.getMass());
        this.getRadius();
        System.out.println("Ball inertia is: " + this.calculateInertia());
    }
}

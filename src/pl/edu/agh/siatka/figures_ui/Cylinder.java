package pl.edu.agh.siatka.figures_ui;

/**
 * Created by Akahari on 25-Mar-17.
 */
public class Cylinder extends MaterialPoint {
    private static final int DECIMAL_PLACES = 2;

    private double radius;
    private double height;

    public Cylinder(){                                              //konstruktor domyślny
        super(1);
        this.radius = 1;
        this.height = 1;
    }

    public Cylinder(double radius, double height){                              //konstruktor z parametrami
        super(1);
        this.radius = radius;
        this.height = height;
    }


    public void getRadius(){ System.out.println("Cylinder radius is: " + this.radius); }        //akcesory i settery

    public void getHeight(){ System.out.println("Cylinder height is: " + this.height); }

    public void setRadius(double radius){ this.radius = radius;}

    public void setHeight(double height){ this.height = height;}

    public double calculateInertia(){ return Util.round(this.mass * Math.pow(this.radius , 2) / 2, DECIMAL_PLACES); }

    public void info(){
        System.out.println("Cylinder");
    }

    public void getValues(){                                                                        //wypisanie wartości pól obiektu
        this.info();
        System.out.println("Cylinder mass is: " + this.getMass());
        this.getHeight();
        this.getRadius();
        System.out.println("Cylinder inertia is: " + this.calculateInertia());
    }
}

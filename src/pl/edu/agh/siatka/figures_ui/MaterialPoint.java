package pl.edu.agh.siatka.figures_ui;

import static java.lang.Math.pow;

public class MaterialPoint {
	private static final int DECIMAL_PLACES = 2;

    protected double mass;
    private double radius = 0;

	
	public MaterialPoint(){
		this.mass = 1;
	}

	public MaterialPoint(double mass){
		this.mass = mass;
	}

	public double getMass(){
		return this.mass;
	}

	public void setMass(double mass){
		if(mass >= 0) {
			this.mass = mass;
		}
	}


	public double calculateInertia(){
		return Util.round( mass *  Math.pow(radius,2), DECIMAL_PLACES) ;
	}

	public double calculateSteinerInertia(double distance){
		return Util.round(calculateInertia() + mass * Math.pow(distance,2), 2);
	}

	public void getValues(){
		this.info();
		this.getMass();
		this.calculateInertia();
	}

	public void info(){
		System.out.println("Material point");
	}
}

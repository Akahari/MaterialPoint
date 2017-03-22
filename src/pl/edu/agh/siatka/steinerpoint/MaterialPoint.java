package pl.edu.agh.siatka.steinerpoint;

import static java.lang.Math.pow;

public class MaterialPoint {

    private double mass;
    private double radius = 0;

	
	public MaterialPoint(){
		this.mass = 0;
	}

	public MaterialPoint(double mass){
		this.mass = mass;
	}

	public double getMass(){
		return this.mass;
	}

	public void setMass(double mass){
		if(mass >= 0){
			this.mass = mass;
		}
	}


	public double calculateInertia(){
		return mass *  Math.pow(radius,2);
	}

	public double calculateSteinerInertia(double distance){
		return calculateInertia() + mass * Math.pow(distance,2);
	}


	public void info(){
		System.out.println("Material point");
	}
}

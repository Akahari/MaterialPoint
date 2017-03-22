package pl.edu.agh.siatka.steinerpoint;


import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args){

		MaterialPoint p1 = new MaterialPoint();
		MaterialPoint p = new MaterialPoint(100);
		p.calculateSteinerInertia(20);

		printValues(p, 20);
		p1.setMass(5);
        printValues(p1, 20);
		ArrayList<MaterialPoint> materialPoints = new ArrayList<>();

		for(int i=0; i <5; i++){
			MaterialPoint pp= new MaterialPoint(10 + 2 * i);
            materialPoints.add(pp);
		}
        System.out.println("---------------------------");
		for(int i=0; i<5; i++){
			printValues(materialPoints.get(i), 20);
		}

	}


	private static void printValues(MaterialPoint mp, double radius){
        mp.info();
		System.out.println("MaterialPoint mass is: " + mp.getMass());
		System.out.println("MaterialPoint inertia is: " + mp.calculateInertia());
		System.out.println("MaterialPoint Steiner inertia for radius = " + radius + " is: " + mp.calculateSteinerInertia(radius));
        System.out.println("---------------------------");
	}
}

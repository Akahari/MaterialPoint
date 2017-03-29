// Created by Paweł Siatka AGH IMiR Mechatronic Engineering 2017
package pl.edu.agh.siatka.figures_ui;

import java.io.BufferedReader;
import java.util.Random;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {
	private static final int DECIMAL_PLACES = 2;

	public static void main(String[] args) {
		Cylinder cylinder = new Cylinder(2, 5);
		Ball ball = new Ball(3);
		Bar bar = new Bar(8);
		cylinder.getValues();
		ball.getValues();
		bar.getValues();

		int figureChoice = 0;
		ArrayList<MaterialPoint> figures = new ArrayList<>();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		System.out.println("Choose the type of figure:");
		System.out.println("1. Cylinder");
		System.out.println("2. Ball");
		System.out.println("3. Bar");
		System.out.println("4. Exit");
		figureChoice = in.read();
		switch(figureChoice){
			case 1: figures.add(cylinderMenu()); break;
			case 2: figures.add(ballMenu()); break;
			case 3: figures.add(barMenu()); break;
			case 4:; break;
			default: System.out.println("Invalid entry");
		}

	}


	private static void printValues(MaterialPoint mp, double radius) {
		mp.getValues();
		System.out.println(" Steiner inertia for radius = " + radius + " is: " + mp.calculateSteinerInertia(radius));
		System.out.println("---------------------------");
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	/*public static ArrayList<MaterialPoint> mainMenu(){
		int figureChoice = 0;
		ArrayList<MaterialPoint> figures = new ArrayList<>();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		System.out.println("Choose the type of figure:");
		System.out.println("1. Cylinder");
		System.out.println("2. Ball");
		System.out.println("3. Bar");
		System.out.println("4. Exit");
		figureChoice = in.read();
		switch(figureChoice){
			case 1: figures.add(cylinderMenu()); break;
			case 2: figures.add(ballMenu()); break;
			case 3: figures.add(barMenu()); break;
			case 4:; break;
			default: System.out.println("Invalid entry");
		}
		return figures;*/
	}

	public static Cylinder cylinderMenu(){
		System.out.println("Enter cylinder mass");
		String mass = BufferedReader.readLine();
		double massValue = Util.round(Double.parseDouble(mass), 2 );
		System.out.println("Enter cylinder radius");
		String radius = BufferedReader.readLine();
		double radiusValue = Util.round(Double.parseDouble(radius), 2 );
		System.out.println("Enter cylinder height");
		String height = BufferedReader.readLine();
		double heightValue = Util.round(Double.parseDouble(height), 2 );

		return new Cylinder(radiusValue,heightValue);
	}

	public static Ball ballMenu(){
		System.out.println("Enter ball mass");
		String mass = BufferedReader.readLine();
		double massValue = Util.round(Double.parseDouble(mass), 2 );
		System.out.println("Enter ball radius");
		String radius = BufferedReader.readLine();
		double radiusValue = Util.round(Double.parseDouble(radius), 2 );

		return new Ball(radiusValue);
	}

	public static Bar barMenu(){
		System.out.println("Enter bar mass");
		String mass = BufferedReader.readLine();
		double massValue = Util.round(Double.parseDouble(mass), 2 );
		System.out.println("Enter bar radius");
		String length = BufferedReader.readLine();
		double lengthValue = Util.round(Double.parseDouble(length), 2 );
		return new Bar(lengthValue);
	}
}
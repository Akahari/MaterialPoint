// Created by Paweł Siatka AGH IMiR Mechatronic Engineering 2017
package pl.edu.agh.siatka.figures_ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {
	private static final int DECIMAL_PLACES = 2;

	public static void main(String[] args) {
		Cylinder cylinder = new Cylinder(2, 5);
		Ball ball = new Ball(3);
		Bar bar = new Bar(8);
		double steinerRadius = 2;
		cylinder.getValues();
		ball.getValues();
		bar.getValues();

		ArrayList<MaterialPoint> figures = new ArrayList<>();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);
		String figureChoice = null;
		int figureChoiceValue;
		do {
			System.out.println("Choose the type of figure:");
			System.out.println("1. Cylinder");
			System.out.println("2. Ball");
			System.out.println("3. Bar");
			System.out.println("4. Exit");

			try {
				figureChoice = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			figureChoiceValue = Integer.parseInt(figureChoice);
			switch (figureChoiceValue) {
				case 1:
					figures.add(cylinderMenu());
					break;
				case 2:
					figures.add(ballMenu());
					break;
				case 3:
					figures.add(barMenu());
					break;
				case 4:
					;
					break;
				default:
					System.out.println("Invalid entry");
			}
		}while(figureChoiceValue != 4);
		for(int i = 0; i < figures.size(); i++)  printValues(figures.get(i), steinerRadius);

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

	public static Cylinder cylinderMenu(){
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);

		System.out.println("Enter cylinder mass");
		String mass = null;
		try {
			mass = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double massValue = Util.round(Double.parseDouble(mass), 2 );
		System.out.println("Enter cylinder radius");
		String radius = null;
		try {
			radius = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double radiusValue = Util.round(Double.parseDouble(radius), 2 );
		System.out.println("Enter cylinder height");
		String height = null;
		try {
			height = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double heightValue = Util.round(Double.parseDouble(height), 2 );
		Cylinder cylinder = new Cylinder(radiusValue,heightValue);
		cylinder.setMass(massValue);

		return cylinder;
	}

	public static Ball ballMenu(){
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);

		System.out.println("Enter ball mass");
		String mass = null;
		try {
			mass = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double massValue = Util.round(Double.parseDouble(mass), 2 );
		System.out.println("Enter ball radius");
		String radius = null;
		try {
			radius = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double radiusValue = Util.round(Double.parseDouble(radius), 2 );
		Ball ball = new Ball(radiusValue);
		ball.setMass(massValue);
		return ball;
	}

	public static Bar barMenu(){
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);

		System.out.println("Enter bar mass");
		String mass = null;
		try {
			mass = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double massValue = Util.round(Double.parseDouble(mass), 2 );
		System.out.println("Enter bar radius");
		String length = null;
		try {
			length = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double lengthValue = Util.round(Double.parseDouble(length), 2 );
		Bar bar = new Bar(lengthValue);
		bar.setMass(massValue);

		return bar;
	}
}
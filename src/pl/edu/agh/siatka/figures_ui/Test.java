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
		ArrayList<MaterialPoint> figures = new ArrayList<>();			//nowa lista przechowująca obiekty klas pochodnych
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);					//zainicjalizowanie instancji klasy BufferedReader
		String figureChoice = null;										//zainicjalizowany string przyjmujący wybór bryły z menu
		int figureChoiceValue;
		do {
			System.out.println("Choose the type of figure:");
			System.out.println("1. Cylinder");
			System.out.println("2. Ball");
			System.out.println("3. Bar");
			System.out.println("4. Exit");									//menu główne programu

			try {
				figureChoice = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}																//przechwytywanie wyjątków przy wyborze
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
			}																	//wykonanie odpowiedniej metody tworzącej obiekt wybrany w menu
		}while(figureChoiceValue != 4);
		for(int i = 0; i < figures.size(); i++)  printValues(figures.get(i), figures.get(i).getSteinerRadius());    //wypisanie danych o utworzonych w menu bryłach

	}


	private static void printValues(MaterialPoint mp, double radius) {												//metoda wypisująca dane obiektów
		mp.getValues();
		System.out.println(" Steiner inertia for radius = " + radius + " is: " + mp.calculateSteinerInertia(radius));
		System.out.println("---------------------------");
	}

	public static Cylinder cylinderMenu(){													//metoda tworząca walec
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);

		System.out.println("Enter cylinder mass");
		String mass = null;
		try {
			mass = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double massValue = Util.round(Double.parseDouble(mass), DECIMAL_PLACES );			//określenie masy walca
		System.out.println("Enter cylinder radius");
		String radius = null;
		try {
			radius = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double radiusValue = Util.round(Double.parseDouble(radius), DECIMAL_PLACES );			//określenie promienia podstawy walca
		System.out.println("Enter cylinder height");
		String height = null;
		try {
			height = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double heightValue = Util.round(Double.parseDouble(height), DECIMAL_PLACES );			// określenie wysokości walca
		System.out.println("Enter cylinder steiner raidus");
		String steinerRadius = null;
		try {
			steinerRadius = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double steinerRadiusValue = Util.round(Double.parseDouble(steinerRadius), DECIMAL_PLACES );			// określenie nowej osi obrotu walca
		Cylinder cylinder = new Cylinder(radiusValue,heightValue);						//tworzenie walca o danych wartościach
		cylinder.setMass(massValue);													//nadanie walcowi masy
		cylinder.setSteinerRadius(steinerRadiusValue);

		return cylinder;
	}

	public static Ball ballMenu(){												//wszystko analogicznie jak dla walca, tworzenie kuli
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);

		System.out.println("Enter ball mass");
		String mass = null;
		try {
			mass = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double massValue = Util.round(Double.parseDouble(mass), DECIMAL_PLACES );
		System.out.println("Enter ball radius");
		String radius = null;
		try {
			radius = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double radiusValue = Util.round(Double.parseDouble(radius), DECIMAL_PLACES );
		System.out.println("Enter ball steiner raidus");
		String steinerRadius = null;
		try {
			steinerRadius = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double steinerRadiusValue = Util.round(Double.parseDouble(steinerRadius), DECIMAL_PLACES );
		Ball ball = new Ball(radiusValue);
		ball.setMass(massValue);
		ball.setSteinerRadius(steinerRadiusValue);
		return ball;
	}

	public static Bar barMenu(){														//wszystko analogicznie jak dla walca, tworzenie pręta
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(reader);

		System.out.println("Enter bar mass");
		String mass = null;
		try {
			mass = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double massValue = Util.round(Double.parseDouble(mass), DECIMAL_PLACES );
		System.out.println("Enter bar radius");
		String length = null;
		try {
			length = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double lengthValue = Util.round(Double.parseDouble(length), DECIMAL_PLACES );
		System.out.println("Enter bar steiner raidus");
		String steinerRadius = null;
		try {
			steinerRadius = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		double steinerRadiusValue = Util.round(Double.parseDouble(steinerRadius), DECIMAL_PLACES );
		Bar bar = new Bar(lengthValue);
		bar.setMass(massValue);
		bar.setSteinerRadius(steinerRadiusValue);

		return bar;
	}
}
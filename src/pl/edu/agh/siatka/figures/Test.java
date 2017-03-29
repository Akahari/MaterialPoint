// Created by Paweł Siatka AGH IMiR Mechatronic Engineering 2017
package pl.edu.agh.siatka.figures;

import java.util.Random;

import java.util.ArrayList;

public class Test {
	private static final int DECIMAL_PLACES = 2;

	public static void main(String[] args) {
		Cylinder cylinder = new Cylinder(2, 5);
		Ball ball = new Ball(3);
		Bar bar = new Bar(8);											//obiekty nowych klas pochodnych zainicjowane z parametrami
		cylinder.getValues();
		ball.getValues();
		bar.getValues();														//wypisanie informacji o utworzonych obiektach

		Random randomGenerator = new Random();
		ArrayList<MaterialPoint> figures = new ArrayList<>();					//zainicjalizowanie listy obiektów
		int k = 1 + randomGenerator.nextInt(10);
		for(int i = 0; i < k; i++){												//w pętli dodawane są losowe obiekty
			int s = randomGenerator.nextInt(3);
			double mass = Util.round(10 * randomGenerator.nextDouble(), DECIMAL_PLACES);
			switch(s){
				case 0: {
					double radius = Util.round(5 * randomGenerator.nextDouble(), DECIMAL_PLACES);				//wyznaczanie wartości oraz tworzenie obiektu o danych wartościach i dodawanie go do listy
					double height = Util.round(5 * randomGenerator.nextDouble(), DECIMAL_PLACES);
					Cylinder figure = new Cylinder(radius, height);
					figure.setMass(mass);
					figures.add(figure);
					break;
				}
				case 1: {
					double radius = Util.round(5 * randomGenerator.nextDouble(), DECIMAL_PLACES);				//jak wyżej
					Ball figure = new Ball(radius);
					figure.setMass(mass);
					figures.add(figure);
					break;
				}
				case 2: {
					double length = Util.round(5 * randomGenerator.nextDouble(), DECIMAL_PLACES);				//jak wyżej
					Bar figure = new Bar(length);
					figure.setMass(mass);
					figures.add(figure);
					break;
				}
				default: break;
			}
		}
		for(int i = 0; i < k; i++) {																					//wypisywanie wartości obiektów na liście
			double steinerRadius = Util.round(5 * randomGenerator.nextDouble(), DECIMAL_PLACES);
			printValues(figures.get(i), steinerRadius);
		}
	}


	private static void printValues(MaterialPoint mp, double radius) {													//metoda do wypisywania wartosci obiektów
		mp.getValues();
		System.out.println(" Steiner inertia for radius = " + radius + " is: " + mp.calculateSteinerInertia(radius));
		System.out.println("---------------------------");
	}
}
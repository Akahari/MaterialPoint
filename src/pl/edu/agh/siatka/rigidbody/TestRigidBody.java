package pl.edu.agh.siatka.rigidbody;

import java.util.Random;

public class TestRigidBody {
    private static final int DECIMAL_PLACES = 2;

    public static void main(String[] args){

        RigidBody body = new RigidBody();                                                           //creating an object for class RigidBody
        Random randomGenerator = new Random();                                                       //creating k (random) number of points with random position and mass
        int k = randomGenerator.nextInt(5);
        for(int i = 0; i < k; i++){
            double x = Util.round( 10 * randomGenerator.nextDouble(), DECIMAL_PLACES);            // assigns a random value rounded to 2 decimal places to the variable x
            double y = Util.round( 10 * randomGenerator.nextDouble(), DECIMAL_PLACES);           // assigns a random value rounded to 2 decimal places to the variable y
            double z = Util.round( 10 * randomGenerator.nextDouble(), DECIMAL_PLACES);          // assigns a random value rounded to 2 decimal places to the variable z
            double mass = Util.round( 10 * randomGenerator.nextDouble(), DECIMAL_PLACES);       // assigns a random value of mass rounded to 2 decimal places to the variable x
            MaterialPoint mp = new MaterialPoint(mass, x, y, z);                                        // creates an object (material point) with coordinates (x,y,z) and mass m
            System.out.println(" Position of point " + (i+1) + ": (" + x + "," + y + "," + z +") and its mass: " + mass );      // prints coordinates and mass of created object
            body.addPoint(mp);                                                                      // adds created point to the list of points that creates the object (body) of RigidBody class
        }
        body.calculateInertia("X");                                 // calculates inertia of the body around X axis and prints it
        body.calculateInertia("Y");                                 // calculates inertia of the body around Y axis and prints it
        body.calculateInertia("Z");                                 // calculates inertia of the body around Z axis and prints it
    }

}

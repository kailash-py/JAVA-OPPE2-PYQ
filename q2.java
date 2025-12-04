/* Q 0.2
 Exception Handling
 Problem Statement
 Write a Java program to simulate an automatic car with speed control. The car should raise
 an exception in the following scenario:
 b " The driver tries to accelerate beyond the maximum speed limit (120 km/h).
 The program should have the following classes:
 b " Class SpeedLimitException extends Exception and has/should have the following
 members:b  Constructor accepting an error message.
 b " Class Car has/should have the following members:b  Instance variables String model and double speedb  Constructor to initialize the instance variables.b  Methodvoid accelerate(double increment) throws SpeedLimitException.
 b If the new speed (current speed + increment) exceeds the maximum speed
 limit of 120 km/h, the method throws a SpeedLimitException with the
 message "Speed limit exceeded, Max allowed is 120 km/h."
 b If the speed increase is within the allowed range, the method updates the
 speed of the car by adding the increment value to the current speed.b  Overridden method toString().
 b " Class CarTest with the main method, which:b  Reads the car model and speed increments from user input.b  Creates a Car object and calls the accelerate.b  Catches and handles the SpeedLimitException, printing the error message if the
 speed limit is exceeded.b  Prints the final state of the car.
 What you have to do
 b " Implement class SpeedLimitException.
 b " Implement the accelerate() method in class Car.
 Page 8
Template Code*/

import java.util.*;
//Define class SpeedLimitException
class SpeedLimitException extends Exception{
    public SpeedLimitException(String message){
        super(message);
    }
}
class Car {
	private String model;
	private double speed;
	public Car(String model) {
		this.model = model;
		this.speed = 0.0;
	}
	public void accelerate(double increment) throws SpeedLimitException {
// Implement the method
        if ((speed + increment )>120){
            throw new SpeedLimitException("Speed limit exceeded, Max allowed is 120 km/h.");
        }
        speed+= increment;
        
	}
	public String toString() {
		return "Car Model: " + model + ", Speed: " + speed + " km/h";
	}
}
public class q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Car myCar = new Car(sc.nextLine());
		try {
			myCar.accelerate(sc.nextDouble());
			myCar.accelerate(sc.nextDouble());
		} catch (SpeedLimitException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(myCar);
		sc.close();
	}
}


/*
Public Test Case 1
Input:
Page 9
Toyota
50
80
Output:
Speed limit exceeded, Max allowed is 120 km/h.
Car Model: Toyota, Speed: 50.0 km/h
*/
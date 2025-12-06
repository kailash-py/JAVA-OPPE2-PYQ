/*Q4.

Complete the following program which models a car rental kiosk, and handles user requests as detailed below.

The program should first accept the number of car rental requests, and then accept details of each request in the following format:

Total number of passengers in the group for the rental request.
Destination of the visit.
These values are used for initialization of fields inside the constructor of CarRental class.
There is a HashMap called available_destinations which contains a set of preassigned destinations and the fare for dropping at that destination. This map is also initialized in the constructor of CarRental class.

The carBooker() method processes the booking requests, and should have the following functionalities:

It should retrieve the fare for the chosen destination from the available_destinations map and calculate the fare per head by dividing the fare for the destination by passenger_count. Then, it should print the destination and the fare per head, in the format shown in the public test cases.

The method should generate/handle the following exceptions:

ImproperHeadCountException should be thrown when passenger_count is zero or negative.
The catch block handling this exception should print the exception type along with the message:
Head count should be positive non-zero value.

If the chosen_destination is not found in available_destinations, a NullPointerException is thrown.
The catch block handling this should create a new exception called WrongDestinationException, set the new exception as the cause of the NullPointerException, and then re-throw it.
WrongDestinationException object should be created such that when getCause() is called, it prints the message as shown in the public test cases.

Solution:*/

import java.util.*;

// Define class WrongDestinationException
class WrongDestinationException extends Exception {
    public WrongDestinationException(String msg) {
        super(msg);
    }
}

// Define class ImproperHeadCountException
class ImproperHeadCountException extends Exception {
    public ImproperHeadCountException(String msg) {
        super(msg);
    }
}

class CarRental {
    int passenger_count;
    String chosen_destination;
    HashMap<String, Double> available_destinations;

    public CarRental(int pc, String dest) {
        passenger_count = pc;
        chosen_destination = dest;
        available_destinations = new HashMap<String, Double>();
        available_destinations.put("Marina Beach", 2000.0);
        available_destinations.put("Elliot's Beach", 5000.0);
        available_destinations.put("Film City", 8000.0);
    }

    public void carBooker() {
        try {
            if (passenger_count <= 0) {
                // message without hyphen
                throw new ImproperHeadCountException("Head count should be positive non zero value");
            }

            Double fare = available_destinations.get(chosen_destination);
            if (fare == null) {
                NullPointerException npe = new NullPointerException();
                // Wrapping WrongDestinationException inside NullPointerException
                npe.initCause(new WrongDestinationException("Invalid destination"));
                throw npe;
            }

            double perHead = fare / passenger_count;
            System.out.println("Destination: " + chosen_destination + ", Head cost: " + perHead);

        } catch (ImproperHeadCountException ihce) {
            System.out.println(ihce.getClass().getSimpleName() + ": " + ihce.getMessage());
        } catch (NullPointerException npe) {
            throw npe; // Will be caught in main
        }
    }
}

public class q20 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt(); // input the number of car rental requests
        try {
            for (int i = 1; i <= num; i++) {
                int heads = s.nextInt(); // enter head count
                s.nextLine(); // consume newline
                String dest = s.nextLine(); // enter destination
                CarRental obj = new CarRental(heads, dest);
                obj.carBooker();
            }
        } catch (Exception e) {
            // This will print the cause message from WrongDestinationException
            System.out.println(e.getCause());
        }
    }
}
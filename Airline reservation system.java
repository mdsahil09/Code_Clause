import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int availableSeats;

    public Flight(String flightNumber, String origin, String destination, int availableSeats) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        if (numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.println("Booking successful. Seats booked: " + numSeats);
        } else {
            System.out.println("Not enough seats available.");
        }
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination +
                " - Available Seats: " + availableSeats;
    }
}

class AirlineReservationSystem {
    private List<Flight> flights;

    public AirlineReservationSystem() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void displayFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println();
    }

    public Flight getFlightByNumber(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        AirlineReservationSystem airlineSystem = new AirlineReservationSystem();

        Flight flight1 = new Flight("AA123", "New York", "Los Angeles", 100);
        Flight flight2 = new Flight("BB456", "Chicago", "Miami", 80);

        airlineSystem.addFlight(flight1);
        airlineSystem.addFlight(flight2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Display Flights");
            System.out.println("2. Book Seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    airlineSystem.displayFlights();
                    break;
                case 2:
                    System.out.print("Enter the flight number: ");
                    String flightNumber = scanner.next();
                    System.out.print("Enter the number of seats to book: ");
                    int numSeats = scanner.nextInt();

                    Flight selectedFlight = airlineSystem.getFlightByNumber(flightNumber);
                    if (selectedFlight != null) {
                        selectedFlight.bookSeats(numSeats);
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

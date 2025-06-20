import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {
    ArrayList<Train> trainList = new ArrayList<>();
    ArrayList<String> bookedTickets = new ArrayList<>();

    public ReservationSystem() {
        trainList.add(new Train(101, "Express A", "Hyderabad", "Chennai", 50));
        trainList.add(new Train(102, "Express B", "Hyderabad", "Bangalore", 45));
        trainList.add(new Train(103, "Express C", "Hyderabad", "Mumbai", 60));
    }

    public void viewTrains() {
        System.out.println("\nAvailable Trains:");
        for (Train train : trainList) {
            train.displayInfo();
        }
    }

    public void bookTicket(Scanner sc) {
        System.out.print("Enter Train Number: ");
        int num = sc.nextInt();
        sc.nextLine();

        for (Train train : trainList) {
            if (train.trainNo == num && train.seats > 0) {
                train.seats--;
                bookedTickets.add("Train " + train.trainNo + " - " + train.trainName);
                System.out.println("Ticket Booked Successfully!");
                return;
            }
        }
        System.out.println("Invalid train number or no seats available.");
    }

    public void cancelTicket(Scanner sc) {
        System.out.print("Enter Train Number to Cancel: ");
        int num = sc.nextInt();
        sc.nextLine();

        for (Train train : trainList) {
            String ticket = "Train " + train.trainNo + " - " + train.trainName;
            if (train.trainNo == num && bookedTickets.contains(ticket)) {
                bookedTickets.remove(ticket);
                train.seats++;
                System.out.println("Ticket Cancelled Successfully!");
                return;
            }
        }
        System.out.println("Ticket not found.");
    }

    public void showBookedTickets() {
        System.out.println("\nYour Booked Tickets:");
        if (bookedTickets.isEmpty()) {
            System.out.println("No tickets booked.");
        } else {
            for (String ticket : bookedTickets) {
                System.out.println(ticket);
            }
        }
    }
}


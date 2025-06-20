import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User user = new User("sailakshmi", "1234");
        ReservationSystem system = new ReservationSystem();

        System.out.println("=== Online Reservation System ===");
        System.out.print("Enter username: ");
        String uname = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (user.login(uname, pass)) {
            int choice;
            do {
                System.out.println("\n1. View Trains");
                System.out.println("2. Book Ticket");
                System.out.println("3. Cancel Ticket");
                System.out.println("4. Show Booked Tickets");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> system.viewTrains();
                    case 2 -> system.bookTicket(sc);
                    case 3 -> system.cancelTicket(sc);
                    case 4 -> system.showBookedTickets();
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Login failed. Exiting...");
        }
        sc.close();
    }
}

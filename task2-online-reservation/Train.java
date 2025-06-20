public class Train {
    int trainNo;
    String trainName;
    String source;
    String destination;
    int seats;

    public Train(int trainNo, String trainName, String source, String destination, int seats) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    public void displayInfo() {
        System.out.println(trainNo + " - " + trainName + " | " + source + " to " + destination + " | Seats: " + seats);
    }
}

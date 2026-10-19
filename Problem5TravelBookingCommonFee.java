import java.util.Scanner;

abstract class Booking {
    private static final double BOOKING_FEE = 50.0;
    protected final double distanceKm;
    Booking(double distanceKm) { this.distanceKm = distanceKm; }
    protected abstract double baseFare();
    public final double totalFare() { return baseFare() + BOOKING_FEE; }
}

class BusBooking extends Booking {
    BusBooking(double distanceKm) { super(distanceKm); }
    protected double baseFare() { return 2.0 * distanceKm; }
}

class TrainBooking extends Booking {
    TrainBooking(double distanceKm) { super(distanceKm); }
    protected double baseFare() { return 1.5 * distanceKm; }
}

class FlightBooking extends Booking {
    FlightBooking(double distanceKm) { super(distanceKm); }
    protected double baseFare() { return 2500.0 + 4.0 * distanceKm; }
}

public class Problem5TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double distance = Double.parseDouble(p[1]);
            Booking booking;
            switch (p[0]) {
                case "BUS": booking = new BusBooking(distance); break;
                case "TRAIN": booking = new TrainBooking(distance); break;
                case "FLIGHT": booking = new FlightBooking(distance); break;
                default: throw new IllegalArgumentException("Unknown mode: " + p[0]);
            }
            System.out.printf("%s: %.2f%n", p[0], booking.totalFare());
        }
        sc.close();
    }
}

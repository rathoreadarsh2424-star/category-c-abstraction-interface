import java.util.Scanner;

abstract class Connection {
    protected final double units;
    Connection(double units) { this.units = units; }
    public abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) { super(units); }
    public double bill() {
        return Math.min(units, 100) * 5.0 + Math.max(0, units - 100) * 7.0;
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) { super(units); }
    public double bill() { return units * 8.0 + 100.0; }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) { super(units); }
    public double bill() { return Math.max(units * 6.0, 1000.0); }
}

public class Problem4ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            double units = Double.parseDouble(p[1]);
            Connection connection;
            switch (p[0]) {
                case "HOME": connection = new HomeConnection(units); break;
                case "SHOP": connection = new ShopConnection(units); break;
                case "FACTORY": connection = new FactoryConnection(units); break;
                default: throw new IllegalArgumentException("Unknown connection type: " + p[0]);
            }
            double bill = connection.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", p[0], bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

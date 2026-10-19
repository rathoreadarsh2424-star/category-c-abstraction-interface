import java.util.Scanner;

abstract class Plot {
    protected final String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    public abstract double area();

    public String shape() {
        return getClass().getSimpleName().replace("Plot", "").toUpperCase();
    }
}

class CirclePlot extends Plot {
    private final double radius;
    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    public double area() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private final double length, width;
    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    public double area() { return length * width; }
}

class TrianglePlot extends Plot {
    private final double base, height;
    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    public double area() { return 0.5 * base * height; }
}

public class Problem1GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Plot plot;
            switch (p[0]) {
                case "CIRCLE": plot = new CirclePlot(p[1], Double.parseDouble(p[2])); break;
                case "RECTANGLE": plot = new RectanglePlot(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3])); break;
                case "TRIANGLE": plot = new TrianglePlot(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3])); break;
                default: throw new IllegalArgumentException("Unknown shape: " + p[0]);
            }
            double area = plot.area();
            total += area;
            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shape(), area);
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}

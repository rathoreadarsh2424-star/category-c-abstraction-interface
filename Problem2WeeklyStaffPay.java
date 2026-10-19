import java.util.Scanner;

abstract class Staff {
    protected final String name;
    Staff(String name) { this.name = name; }
    public abstract double pay();
}

class FullTimeStaff extends Staff {
    private final double weeklySalary;
    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }
    public double pay() { return weeklySalary; }
}

class HourlyStaff extends Staff {
    private final double hours, rate;
    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    public double pay() {
        return Math.min(hours, 40) * rate + Math.max(0, hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    private final double stipend;
    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    public double pay() { return stipend; }
}

public class Problem2WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            Staff staff;
            switch (p[0]) {
                case "FULLTIME": staff = new FullTimeStaff(p[1], Double.parseDouble(p[2])); break;
                case "HOURLY": staff = new HourlyStaff(p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3])); break;
                case "INTERN": staff = new InternStaff(p[1], Double.parseDouble(p[2])); break;
                default: throw new IllegalArgumentException("Unknown staff type: " + p[0]);
            }
            double pay = staff.pay();
            total += pay;
            System.out.printf("%s: %.2f%n", staff.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}

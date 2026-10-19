import java.util.Scanner;

abstract class LibraryItem {
    protected final String title;
    protected final int daysLate;
    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }
    public abstract double fine();
}

class BookItem extends LibraryItem {
    BookItem(String title, int daysLate) { super(title, daysLate); }
    public double fine() { return daysLate * 2.0; }
}

class DvdItem extends LibraryItem {
    DvdItem(String title, int daysLate) { super(title, daysLate); }
    public double fine() { return Math.min(daysLate * 5.0, 50.0); }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title, int daysLate) { super(title, daysLate); }
    public double fine() { return daysLate; }
}

public class Problem3LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");
            LibraryItem item;
            switch (p[0]) {
                case "BOOK": item = new BookItem(p[1], Integer.parseInt(p[2])); break;
                case "DVD": item = new DvdItem(p[1], Integer.parseInt(p[2])); break;
                case "MAGAZINE": item = new MagazineItem(p[1], Integer.parseInt(p[2])); break;
                default: throw new IllegalArgumentException("Unknown item type: " + p[0]);
            }
            double fine = item.fine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}

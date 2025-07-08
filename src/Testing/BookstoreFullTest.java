package Testing;

import Books.*;
import Logic.Inventory;

public class BookstoreFullTest {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        // Add books
        PaperBook paper = new PaperBook("111", "Java 101", "Aly Eldeen", 2018, 150.0, 5);
        EBook ebook = new EBook("222", "Clean Code", "Robert C. Martin", 2020, 90.0, "PDF");
        ShowCaseDemoBook demo = new ShowCaseDemoBook("333", "Preview Book", "Someone", 2015, 0.0);

        inventory.addBook(paper);
        inventory.addBook(ebook);
        inventory.addBook(demo);

        // Remove books older than 7 years
        inventory.removeOutdatedBooks(7);

        // Buy paper book
        try {
            inventory.buyBook("111", 2, "buyer@email.com", "Cairo, Egypt");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Buy ebook
        try {
            inventory.buyBook("222", 1, "reader@email.com", "");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // buy showcase book ( not found )
        try {
            inventory.buyBook("333", 1, "demo@email.com", "Nowhere");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        inventory.printInventory();
    }
}

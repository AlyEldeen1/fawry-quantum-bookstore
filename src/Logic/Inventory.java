package Logic;

import Books.*;
import Services.MailService;
import Services.ShippingService;
import java.util.*;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println(" Book added: " + book.info());
    }

    public void removeOutdatedBooks(int maxAge) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<String> toRemove = new ArrayList<>();

        for (Book book : books.values()) {
            if (currentYear - book.getYear() > maxAge) {
                toRemove.add(book.getIsbn());
                System.out.println("Removed outdated book: " + book.info());
            }
        }

        for (String isbn : toRemove) {
            books.remove(isbn);
        }
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        if (!books.containsKey(isbn)) {
            throw new RuntimeException("Book with ISBN " + isbn + " not found.");
        }

        Book book = books.get(isbn);

        if (!book.isAvailable()) {
            throw new RuntimeException("Book \"" + book.info() + "\" is not available for purchase.");
        }

        double totalPaid = book.getPrice() * quantity;

        if (book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            paperBook.reduceStock(quantity);
            ShippingService.send(address, paperBook.info());
        } else if (book instanceof EBook) {
            MailService.send(email, book.info());
        } else {
            throw new RuntimeException("This book type is not supported for purchase.");
        }

        System.out.println("Paid: $" + totalPaid);
        return totalPaid;
    }

    public void printInventory() {
        System.out.println("book store Current Inventory:");
        for (Book book : books.values()) {
            System.out.println(" - " + book.info());
        }
    }
}

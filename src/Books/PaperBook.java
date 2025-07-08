package Books;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public int getStock() {
        return stock;
    }

    public boolean reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
            return true;
        } else {
            throw new RuntimeException("Not enough stock for ISBN: " + isbn);

        }
    }

    @Override
    public String info() {
        return super.info() + " | Stock: " + stock;
    }
}

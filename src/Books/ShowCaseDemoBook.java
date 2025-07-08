package Books;

public class ShowCaseDemoBook extends Book {

    public ShowCaseDemoBook(String isbn, String title, String author, int year, double price) {
        super(isbn, title, author, year, price);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public String info() {
        return super.info() + " | Showcase (not for sale)";
    }

}

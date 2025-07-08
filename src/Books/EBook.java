package Books;

public class EBook extends Book {
    private final String fileType;

    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(isbn, title, author, year, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String info() {
        return super.info() + " | File Type: " + fileType;
    }
}

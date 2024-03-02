public abstract class Book {
    private String title;
    private String author;
    private int releaseYear;
    private int totalCopies;
    private double pricePerCopy;

    public Book(String title, String author, int releaseYear, int totalCopies, double pricePerCopy) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.totalCopies = totalCopies;
        this.pricePerCopy = pricePerCopy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public double getPricePerCopy() {
        return pricePerCopy;
    }

    public void setPricePerCopy(double pricePerCopy) {
        this.pricePerCopy = pricePerCopy;
    }

    public abstract boolean sellBook(int num) throws OutOfStockException;
}

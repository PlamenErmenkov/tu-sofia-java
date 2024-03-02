public class FictionBook extends Book{
    protected String genre;

    public FictionBook(String title, String author, int releaseYear, int totalCopies, double pricePerCopy, String genre) {
        super(title, author, releaseYear, totalCopies, pricePerCopy);
        this.genre = genre;
    }

    @Override
    public boolean sellBook(int num) throws OutOfStockException {
        if(getTotalCopies() > 0){
            return true;
        }else {
            throw new OutOfStockException("No more books");
        }
    }
}

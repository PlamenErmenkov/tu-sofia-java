public class NonFictionBook extends Book{
    private String subject;
    public NonFictionBook(String title, String author, int releaseYear, int totalCopies, double pricePerCopy, String subject) {
        super(title, author, releaseYear, totalCopies, pricePerCopy);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean sellBook(int num) throws OutOfStockException {
        if(getTotalCopies() >= 0){
            return true;
        }else {
            throw new OutOfStockException("No more books");
        }
    }
}

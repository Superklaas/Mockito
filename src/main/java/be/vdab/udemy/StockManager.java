package be.vdab.udemy;

public class StockManager {

    private DataService webService;
    private DataService database;

    public void setWebService(DataService webService) {
        this.webService = webService;
    }

    public void setDatabase(DataService database) {
        this.database = database;
    }

    // method to create locator code, given isbn
    public String createLocatorCode(String isbn) {

        // find book in database or web service
        Book book = database.lookup(isbn);
        if (book == null) {
            book = webService.lookup(isbn);
        }

        // create locator code with data book and isbn
        StringBuilder locatorCode = new StringBuilder();
        locatorCode.append(isbn.substring(isbn.length()-4));
        locatorCode.append(book.getAuthor().charAt(0));
        locatorCode.append(book.getTitle().split(" ").length);

        return locatorCode.toString();

    }


}

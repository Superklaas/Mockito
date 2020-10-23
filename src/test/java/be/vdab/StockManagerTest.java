package be.vdab;

import be.vdab.udemy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class StockManagerTest {

    DataService database;
    DataService webService;
    StockManager stockManager;

    @BeforeEach
    void setup() {

        // create mock database & web service
        database = mock(DataService.class);
        webService = mock(DataService.class);

        // instantiate stock manager & give him database and web service
        stockManager = new StockManager();
        stockManager.setDatabase(database);
        stockManager.setWebService(webService);

    }

    @Test
    void createLocatorCode_BookInDatabase() {

        // putting data in mock database
        when(database.lookup("0140177396"))
                .thenReturn(new Book("0140177396","John Steinbeck","Of mice and men"));

        // stock manager gets isbn, looks up book and creates locator code
        String isbn = "0140177396";
        String locatorCode = stockManager.createLocatorCode(isbn);

        // assertion
        assertEquals("7396J4",locatorCode);

    }

    @Test
    void createLocatorCode_BookInWebService() {

        when(database.lookup("0140177396")).thenReturn(null);
        when(database.lookup("0140177396"))
                .thenReturn(new Book("0140177396","John Steinbeck","Of mice and men"));

        String isbn = "0140177396";
        String locatorCode = stockManager.createLocatorCode(isbn);

        assertEquals("7396J4",locatorCode);

    }

    @Test
    void ifBookInDatabase_DatabaseIsCalled() {

        // putting data in mock database
        when(database.lookup("0140177396"))
                .thenReturn(new Book("0140177396","John Steinbeck","Of mice and men"));

        // stock manager gets isbn, looks up book and creates locator code
        String isbn = "0140177396";
        String locatorCode = stockManager.createLocatorCode(isbn);

        // verify that database is called but web service is not
        verify(database).lookup("0140177396");
        verify(webService,never()).lookup(anyString());

    }

    @Test
    void ifBookNotInDatabase_DatabaseAndWebServiceAreCalled() {

        // putting data in mocks
        when(database.lookup("0140177396")).thenReturn(null);
        when(webService.lookup("0140177396"))
                .thenReturn(new Book("0140177396","John Steinbeck","Of mice and men"));

        // stock manager gets isbn, looks up book and creates locator code
        String isbn = "0140177396";
        String locatorCode = stockManager.createLocatorCode(isbn);

        // verify that database and web service are called
        verify(database).lookup("0140177396");
        verify(webService).lookup("0140177396");

    }

}

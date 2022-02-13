package edu.bsu.cs222.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class WikiPageAuthenticatorTest {
    private final WikiPageAuthenticator wikiPageAuthenticator = new WikiPageAuthenticator();
    private final InputStreamReader inputStreamReader = new InputStreamReader();
    private InputStream testDataStream;
    private String dataString;

    @Test
    public void doesPageExistTestFalse() {
        testDataStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream("MissingPage.json");
        dataString = inputStreamReader.makeString(testDataStream);
        boolean result = wikiPageAuthenticator.doesPageExist(dataString);
        Assertions.assertFalse(result);
    }

    @Test
    public void doesPageExistTestTrue() {
        testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("SoupQuery.json");
        dataString = inputStreamReader.makeString(testDataStream);
        boolean result = wikiPageAuthenticator.doesPageExist(dataString);
        Assertions.assertTrue(result);
    }
}

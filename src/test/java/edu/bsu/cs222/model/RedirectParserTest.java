package edu.bsu.cs222.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class RedirectParserTest {
    private final RedirectParser parser = new RedirectParser();
    private final InputStreamReader inputStreamReader = new InputStreamReader();
    private InputStream testDataStream;
    private String dataString;

    @Test
    public void doesPageRedirectTestFalse() {
        testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("SoupQuery.json");
        dataString = inputStreamReader.makeString(testDataStream);
        Assertions.assertFalse(parser.doesPageRedirect(dataString));
    }

    @Test
    public void doesPageRedirectTestTrue() {
        testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("RedirectExample.json");
        dataString = inputStreamReader.makeString(testDataStream);
        Assertions.assertTrue(parser.doesPageRedirect(dataString));
    }

    @Test
    public void assertRedirectTo() {
        testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("RedirectExample.json");
        dataString = inputStreamReader.makeString(testDataStream);
        Assertions.assertEquals("Joe Biden", parser.redirectedTo(dataString));
    }
}
